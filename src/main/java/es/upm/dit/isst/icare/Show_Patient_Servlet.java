package es.upm.dit.isst.icare;

import java.io.IOException;
import java.util.Date;

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
import es.upm.dit.isst.icare.model.Tension;
import es.upm.dit.isst.icare.model.MedicalData;

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
		ObjectifyService.register(MedicalData.class);
		ObjectifyService.register(Relative.class);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Logout" ;
		ICareDao dao = ICareDaoImpl.getInstancia();
		
		String email = req.getParameter("email");
		
		Patient patient = dao.readPatient(email);
		if (patient.getTension().isEmpty()) {
			@SuppressWarnings("deprecation")
			Tension tension = new Tension(13, 7, new Date(2017, 5, 4));
			@SuppressWarnings("deprecation")
			Tension tension1 = new Tension(15, 8, new Date(2017, 5, 5));
			@SuppressWarnings("deprecation")
			Tension tension2 = new Tension(12, 7, new Date(2017, 5, 6));
			@SuppressWarnings("deprecation")
			Tension tension3 = new Tension(11, 6, new Date(2017, 5, 7));
			@SuppressWarnings("deprecation")
			Tension tension4 = new Tension(10, 5, new Date(2017, 5, 8));
			@SuppressWarnings("deprecation")
			Tension tension5 = new Tension(13, 8, new Date(2017, 5, 9));
			patient.setTension(tension);
			patient.setTension(tension1);
			patient.setTension(tension2);
			patient.setTension(tension3);
			patient.setTension(tension4);
			patient.setTension(tension5);
			dao.updatePatient(patient);
		}
		MedicalData medicaldata = dao.readMedicalData(email);
		Relative relative = dao.readRelative(email);
		
		req.getSession().setAttribute( "patient" , patient);
		req.getSession().setAttribute( "medicaldata" , medicaldata);
		req.getSession().setAttribute( "relative" , relative);
		req.getSession().setAttribute( "url" , url );
		req.getSession().setAttribute( "urlLinktext" , urlLinktext );

		RequestDispatcher view = req.getRequestDispatcher ("show_patient.jsp");
		view.forward(req,resp);
	}

}
