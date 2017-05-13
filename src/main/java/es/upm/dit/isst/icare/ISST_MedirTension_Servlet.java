package es.upm.dit.isst.icare;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.icare.dao.ICareDao;
import es.upm.dit.isst.icare.dao.ICareDaoImpl;
import es.upm.dit.isst.icare.model.Patient;
import es.upm.dit.isst.icare.model.Tension;

public class ISST_MedirTension_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String patientEmail = req.getParameter("patient");
		ICareDao dao = ICareDaoImpl.getInstancia();
		Patient patient = dao.readPatient(patientEmail);
		
		String criticidad = "";
		String description ="";		
	
		// Medidas de Tensión - Sensores Biométricos
		double tensionMax = Math.random() * (8 - 18) + 18;
		double tensionMin = Math.random() * (5 - 12) + 12;
		while ((tensionMax - tensionMin) < 3 || (tensionMax - tensionMin) > 6.5) {
			tensionMin = Math.random() * (5 - 12) + 12;
			tensionMax = Math.random() * (8 - 18) + 18;
		}
		Tension tension = new Tension(tensionMax, tensionMin);
		if (tensionMax > 16 && tensionMin > 9){
			criticidad="Media";
			description="Indicios de Hipertensión, la presión sistólica supera los 16 cm de Hg y la diástolica los 9 cm de Hg.";
			dao.createAviso(criticidad, patientEmail, description);
		} else if (tensionMax < 11 && tensionMin < 7){
			criticidad="Media";
			description="Indicios de Hipotensión, la presión sistólica se encuentra por debajo de los 11 cm de Hg y la diástolica de los 7 cm de Hg.";
			dao.createAviso(criticidad, patientEmail, description);
		}
		
		patient.setTension(tension);
		dao.updatePatient(patient);
		
		resp.sendRedirect("/verPaciente?email=" + patientEmail);
		
	}

}
