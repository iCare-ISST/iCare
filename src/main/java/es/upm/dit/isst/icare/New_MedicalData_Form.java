package es.upm.dit.isst.icare;

import java.io.IOException;

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
import es.upm.dit.isst.icare.model.Relative;
import es.upm.dit.isst.icare.model.MedicalData;

public class New_MedicalData_Form extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public New_MedicalData_Form() {}
	
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

				RequestDispatcher view = req.getRequestDispatcher ("NewMedicalData_form.jsp");
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
		String alergias = req.getParameter("alergias");
		String cardiopatias = req.getParameter("cardiopatias");
		String cardiovasculares = req.getParameter("cardiovasculares");
		String mentales = req.getParameter("mentales");
		String gruposanguineo = req.getParameter("gruposanguineo");
		String medicacion = req.getParameter("medicacion");
		String invalidez = req.getParameter("invalidez");
		String otrasafecciones = req.getParameter("otrasafecciones");
		String sobrepeso = req.getParameter("sobrepeso");
		
		MedicalData medicaldata = dao.createMedicalData(email, alergias, cardiopatias, cardiovasculares, mentales, gruposanguineo, medicacion, invalidez, otrasafecciones, sobrepeso);
		
		Patient patient = dao.readPatient(email);
		Relative relative = dao.readRelative(email);
		
		req.getSession().setAttribute( "user" , patient.getPatientname());
		req.getSession().setAttribute( "url" , url );
		req.getSession().setAttribute( "urlLinktext" , urlLinktext );
		req.getSession().setAttribute( "patient" , patient);
		req.getSession().setAttribute( "medicaldata" , medicaldata);
		req.getSession().setAttribute( "relative" , relative);
		RequestDispatcher view = req.getRequestDispatcher ("show_patient.jsp");
		view.forward(req,resp);
	}
}
