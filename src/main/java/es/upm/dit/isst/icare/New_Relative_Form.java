package es.upm.dit.isst.icare;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.server.spi.guice.SystemServiceModule;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.ICareDao;
import es.upm.dit.isst.icare.dao.ICareDaoImpl;
import es.upm.dit.isst.icare.model.Aviso;
import es.upm.dit.isst.icare.model.Patient;
import es.upm.dit.isst.icare.model.MedicalData;
import es.upm.dit.isst.icare.model.Relative;

public class New_Relative_Form extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public New_Relative_Form() {}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Patient.class);	
		ObjectifyService.register(Aviso.class);
		ObjectifyService.register(MedicalData.class);
		ObjectifyService.register(Relative.class);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login" ;
		String user = "" ;
		String email ="";
		ICareDao dao = ICareDaoImpl.getInstancia();
		
		if ( req.getUserPrincipal () != null ){
			email = req.getParameter("email");
			Patient patient = dao.readPatient(email);
				url = userService.createLogoutURL(req.getRequestURI());	
				urlLinktext = "Logout" ;
				req.getSession().setAttribute( "email" , patient.getEmail());
				req.getSession().setAttribute( "url" , url );
				req.getSession().setAttribute( "urlLinktext" , urlLinktext );

				RequestDispatcher view = req.getRequestDispatcher ("NewRelative_form.jsp");
				view.forward(req,resp);
		} else {
			req.getSession().setAttribute( "user" , user);
			req.getSession().setAttribute( "url" , url );
			req.getSession().setAttribute( "urlLinktext" , urlLinktext );
			RequestDispatcher view = req.getRequestDispatcher ("index.jsp");
			view.forward(req,resp);
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Logout" ;
		ICareDao dao = ICareDaoImpl.getInstancia();
		
		String patientemail = req.getParameter("patientemail");
		String relativename = req.getParameter("relativename");
		String lastname = req.getParameter("lastname");
		String mobilephone = req.getParameter("mobilephone");
		String landlinephone = req.getParameter("landlinephone");
		String address = req.getParameter("address");
		String location = req.getParameter("location");
		String province = req.getParameter("province");
		
		Relative relative = dao.createRelative(patientemail, relativename, lastname, mobilephone, landlinephone, address, location, province);
		
		Patient patient = dao.readPatient(patientemail);
		MedicalData medicaldata = dao.readMedicalData(patientemail);
		
		req.getSession().setAttribute( "user" , patient.getPatientname());
		req.getSession().setAttribute( "url" , url );
		req.getSession().setAttribute( "urlLinktext" , urlLinktext );
		req.getSession().setAttribute( "patient" , patient);
		req.getSession().setAttribute( "medicaldata" , medicaldata);
		req.getSession().setAttribute("relative", relative);
		RequestDispatcher view = req.getRequestDispatcher ("show_patient.jsp");
		view.forward(req,resp);
	}
}
