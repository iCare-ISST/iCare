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

public class ISST_form_Servlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ISST_form_Servlet() {}
	
	@Override
	public void init() throws ServletException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login" ;
		ICareDao dao = ICareDaoImpl.getInstancia();
		String patientname = req.getParameter("patientname");
		String lastname = req.getParameter("lastname");
		String mobile = req.getParameter("mobilephone");
		String address = req.getParameter("address");
		dao.create(patientname, lastname, mobile, address);
		ArrayList<Patient> patients = new ArrayList<>();
		patients.addAll(dao.read());
		Patient patient = dao.readPatient(patientname);
		req.getSession().setAttribute( "url" , url );
		req.getSession().setAttribute( "urlLinktext" , urlLinktext );
		req.getSession().setAttribute( "patients" , patients);
		req.getSession().setAttribute( "patient" , patient);
		RequestDispatcher view = req.getRequestDispatcher ("ICare_Vista.jsp");
		view.forward(req,resp);
	}
}
