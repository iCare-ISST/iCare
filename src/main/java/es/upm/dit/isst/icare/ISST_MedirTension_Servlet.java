package es.upm.dit.isst.icare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
	
	private static int i = 0;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ICareDao dao = ICareDaoImpl.getInstancia();
		ArrayList<Patient> patients = new ArrayList<>();
		patients.addAll(dao.readPatients());
		for(Patient patient: patients) {
			Date now = new Date();
			Date date = new Date(now.getTime() + i * 24 * 60 * 60 * 1000);
			Tension tension = new Tension(
					Math.random() * (11 - 20) + 20,
					Math.random() * (5 - 11) + 11,
					date
			);
			patient.setTension(tension);
			dao.updatePatient(patient);
			i++;
		}
	}
}
