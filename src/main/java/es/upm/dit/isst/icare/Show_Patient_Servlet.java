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

public class Show_Patient_Servlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Show_Patient_Servlet() {}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Patient.class);	
		ObjectifyService.register(Aviso.class);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Logout" ;
		ICareDao dao = ICareDaoImpl.getInstancia();
		
		String email = req.getParameter("email");
		
		Patient patient = dao.readPatient(email);
		
		req.getSession().setAttribute( "patientname" , patient.getPatientname());
		req.getSession().setAttribute( "lastname" , patient.getLastname());
		req.getSession().setAttribute( "birthdate" , patient.getBirthdate());
		req.getSession().setAttribute( "mobilephone" , patient.getMobilephone());
		req.getSession().setAttribute( "landlinephone" , patient.getLandlinephone());
		req.getSession().setAttribute( "adress" , patient.getAddress());
		req.getSession().setAttribute( "location" , patient.getLocation());
		req.getSession().setAttribute( "province" , patient.getProvince());
		req.getSession().setAttribute( "url" , url );
		req.getSession().setAttribute( "urlLinktext" , urlLinktext );

		RequestDispatcher view = req.getRequestDispatcher ("show_patient.jsp");
		view.forward(req,resp);
	}

}
