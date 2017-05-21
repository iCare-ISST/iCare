package es.upm.dit.isst.icare;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.icare.dao.ICareDao;
import es.upm.dit.isst.icare.dao.ICareDaoImpl;
import es.upm.dit.isst.icare.model.Monoxido;
import es.upm.dit.isst.icare.model.Patient;

public class ISST_MedirMonoxido_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ICareDao dao = ICareDaoImpl.getInstancia();
		String patientEmail = req.getParameter("patient");
		boolean enCasa = Boolean.parseBoolean(req.getParameter("enCasa"));
		int monoxidoPPM = Integer.parseInt(req.getParameter("monoxido"));
		String criticidad="";
		String description="";
		Monoxido monoxido = new Monoxido(monoxidoPPM);
		Patient patient = dao.readPatient(patientEmail);
		patient.setMonoxido(monoxido);
		patient.setIsAtHome(enCasa);
		
		if (monoxidoPPM >= 120 && monoxidoPPM < 200 && enCasa){
			criticidad = "Baja";
			description = "El nivel de monóxido de carbono empieza a ser no saludable. Entre 120 y 200 partes por millón";
			dao.createAviso(criticidad, patientEmail, description);
		} else if (monoxidoPPM >= 200 && monoxidoPPM < 400 && enCasa) {
			criticidad="Media";
			description="El nivel de monóxido de carbono es elevado. Entre 200 y 400 partes por millón";
			dao.createAviso(criticidad, patientEmail, description);
		} else if (monoxidoPPM >= 400 && enCasa) {
			criticidad="Alta";
			description="El nivel de monóxido de carbono es crítico. Por encima de 400 partes por millón";
			dao.createAviso(criticidad, patientEmail, description);
		}
		dao.updatePatient(patient);
	}

}
