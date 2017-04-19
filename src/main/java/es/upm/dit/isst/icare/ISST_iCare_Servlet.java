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
import es.upm.dit.isst.icare.model.Patient;


public class ISST_iCare_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ISST_iCare_Servlet() {}
	
	@Override
	public void init() throws ServletException {
	ObjectifyService.register(Patient.class);	
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login" ;
		String user = "" ;
		ICareDao dao = ICareDaoImpl.getInstancia();
		Patient patient = null;
		ArrayList<Patient> patients = new ArrayList<>();
		
		if ( req.getUserPrincipal () != null ){
			user = req.getUserPrincipal().getName();
			url = userService.createLogoutURL(req.getRequestURI());	
			patient = dao.readPatient(user);
			patients = (ArrayList<Patient>) dao.read();
			
			urlLinktext = "Logout" ;
		}
		req.getSession().setAttribute( "user" , user);
		req.getSession().setAttribute( "url" , url );
		req.getSession().setAttribute( "urlLinktext" , urlLinktext );
		req.getSession().setAttribute( "patient" , patient);
		req.getSession().setAttribute( "patients" , patients);
		RequestDispatcher view = req.getRequestDispatcher ("ICare_Vista.jsp");
		view.forward(req,resp);
	}
	
}
