package es.upm.dit.isst.icare;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.ICareDao;
import es.upm.dit.isst.icare.dao.ICareDaoImpl;
import es.upm.dit.isst.icare.model.Aviso;
import es.upm.dit.isst.icare.model.MedicalData;
import es.upm.dit.isst.icare.model.Patient;
import es.upm.dit.isst.icare.model.Relative;

public class Show_Aviso_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Patient.class);
		ObjectifyService.register(Relative.class);
		ObjectifyService.register(MedicalData.class);
		ObjectifyService.register(Aviso.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("avisoid"));
		ICareDao dao = ICareDaoImpl.getInstancia();
		Aviso aviso = dao.readAviso(id);
		String email = aviso.getPatientEmail();
		Patient patient = dao.readPatient(email);
		Relative relative = dao.readRelative(email);
		MedicalData medicaldata = dao.readMedicalData(email);
		ArrayList<Aviso> avisos = new ArrayList<>(dao.readAvisoByPatient(email));
		
		req.getSession().setAttribute("aviso", aviso);
		req.getSession().setAttribute("patient", patient);
		req.getSession().setAttribute("relative", relative);
		req.getSession().setAttribute( "medicaldata" , medicaldata);
		req.getSession().setAttribute("avisos", avisos);
		
		
		RequestDispatcher view = req.getRequestDispatcher ("show_aviso.jsp");
		view.forward(req,resp);
	}
}
