package es.upm.dit.isst.icare;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.ICareDao;
import es.upm.dit.isst.icare.dao.ICareDaoImpl;
import es.upm.dit.isst.icare.model.Aviso;
import es.upm.dit.isst.icare.model.Patient;

public class ISST_form_Servlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ISST_form_Servlet() {}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Patient.class);	
		ObjectifyService.register(Aviso.class);
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
				user = req.getUserPrincipal().getName();
				url = userService.createLogoutURL(req.getRequestURI());	
				urlLinktext = "Logout" ;
				
				email = req.getParameter("email");
				if (email != null){
				Patient patient = dao.readPatient(email);				
				req.getSession().setAttribute( "patient" , patient );
				}
				
				req.getSession().setAttribute( "url" , url );
				req.getSession().setAttribute( "urlLinktext" , urlLinktext );

				RequestDispatcher view = req.getRequestDispatcher ("form.jsp");
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
		
		String email = req.getParameter("email");
		String patientname = req.getParameter("patientname");
		String lastname = req.getParameter("lastname");
		String birthdate = req.getParameter("birthdate");
		String mobile = req.getParameter("mobilephone");
		String landlinephone = req.getParameter("landlinephone");
		String address = req.getParameter("address");
		String location = req.getParameter("location");
		String province = req.getParameter("province");
		Patient patient = dao.createPatient(email, patientname, lastname, birthdate, mobile, landlinephone, address, location, province);
		
		ArrayList<Patient> patients = new ArrayList<>();
		patients.addAll(dao.readPatients());
		
		req.getSession().setAttribute( "user" , patientname );
		req.getSession().setAttribute( "url" , url );
		req.getSession().setAttribute( "urlLinktext" , urlLinktext );
		req.getSession().setAttribute( "patients" , patients);
		req.getSession().setAttribute( "patient" , patient);
		RequestDispatcher view = req.getRequestDispatcher ("ICare_Vista.jsp");
		view.forward(req,resp);
	}
}