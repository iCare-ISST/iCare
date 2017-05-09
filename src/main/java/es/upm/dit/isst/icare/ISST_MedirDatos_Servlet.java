package es.upm.dit.isst.icare;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.ICareDao;
import es.upm.dit.isst.icare.dao.ICareDaoImpl;
import es.upm.dit.isst.icare.model.Patient;
import es.upm.dit.isst.icare.model.Pulsaciones;
import es.upm.dit.isst.icare.model.Tension;
import es.upm.dit.isst.icare.model.Monoxido;

public class ISST_MedirDatos_Servlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Patient.class);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ICareDao dao = ICareDaoImpl.getInstancia();
		ArrayList<Patient> patients = new ArrayList<>();
		patients.addAll(dao.readPatients());
		for(Patient patient: patients) {
			String patientEmail = patient.getEmail();
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
			if (tension.getTensionMax() > 16 && tension.getTensionMin() > 9){
				criticidad="Media";
				description="Indicios de Hipertensión, la presión sistólica supera los 16 cm de Hg y la diástolica los 9 cm de Hg.";
				dao.createAviso(criticidad, patientEmail, description);
			} else if (tension.getTensionMax() < 11 && tension.getTensionMin() < 7){
				criticidad="Media";
				description="Indicios de Hipotensión, la presión sistólica se encuentra por debajo de los 11 cm de Hg y la diástolica de los 7 cm de Hg.";
				dao.createAviso(criticidad, patientEmail, description);
			}
			
			//Medidas de Pulsaciones - Sensores Biométricos
			double pulsaciones_0_1 = Math.random();
			Pulsaciones pulsaciones;
			if (pulsaciones_0_1 < 0.7) {
				pulsaciones = new Pulsaciones(Math.random() * (60 - 100) + 100);
			} else if (pulsaciones_0_1 < 0.9) {
				pulsaciones = new Pulsaciones(Math.random() * (50 - 150) + 150);
				if (pulsaciones.getPulsaciones() < 60){
					criticidad="Media";
					description="Posible indicio de Bradicardia, las pulsaciones se encuentran entre 50 y 60 pulsaciones por minuto.";
					dao.createAviso(criticidad, patientEmail, description);
				} else if (pulsaciones.getPulsaciones() > 100 && pulsaciones.getPulsaciones() < 131){
					criticidad="Baja";
					description="Posible indicio de Taquicardia, las pulsaciones se encuentran entre 100 y 130 pulsaciones por minuto.";
					dao.createAviso(criticidad, patientEmail, description);
				} else if (pulsaciones.getPulsaciones() > 130 && pulsaciones.getPulsaciones() < 150){
					criticidad="Media";
					description="Posible indicio de Taquicardia, las pulsaciones se encuentran entre 130 y 150 pulsaciones por minuto.";
					dao.createAviso(criticidad, patientEmail, description);
				}  
			} else {
				pulsaciones = new Pulsaciones(Math.random() * (40 - 200) + 200);
				if (pulsaciones.getPulsaciones() < 50){
					criticidad="Alta";
					description="Bradicardia, las pulsaciones se encuentran por debajo de 50 pulsaciones por minuto.";
					dao.createAviso(criticidad, patientEmail, description);
				} else if (pulsaciones.getPulsaciones() < 60){
					criticidad="Media";
					description="Posible indicio de Bradicardia, las pulsaciones se encuentran entre 50 y 60 pulsaciones por minuto.";
					dao.createAviso(criticidad, patientEmail, description);
				} else if (pulsaciones.getPulsaciones() > 100 && pulsaciones.getPulsaciones() < 131){
					criticidad="Baja";
					description="Posible indicio de Taquicardia, las pulsaciones se encuentran entre 100 y 130 pulsaciones por minuto.";
					dao.createAviso(criticidad, patientEmail, description);
				} else if (pulsaciones.getPulsaciones() > 130 && pulsaciones.getPulsaciones() < 150){
					criticidad="Media";
					description="Posible indicio de Taquicardia, las pulsaciones se encuentran entre 130 y 150 pulsaciones por minuto.";
					dao.createAviso(criticidad, patientEmail, description);
				} else if (pulsaciones.getPulsaciones() > 150){
					criticidad="Alta";
					description="Taquicardia, las pulsaciones se encuentran por encima de 150 pulsaciones por minuto.";
					dao.createAviso(criticidad, patientEmail, description);
				} 
			}
			
			// Medidas de nivel de monóxido de carbono - Sensores de Entorno
			double rnd = Math.random();
			Monoxido monoxido;
			if (rnd < 0.7){
				monoxido = new Monoxido(Math.random() * (0 - 35) + 35);
			} else if (rnd <0.8){
				monoxido = new Monoxido(Math.random() * (35 - 200) + 200);
				if (monoxido.getPpm() > 120){
					criticidad="Baja";
					description="El nivel de monóxido de carbono empieza a ser no saludable. Entre 120 y 200 partes por millón";
					dao.createAviso(criticidad, patientEmail, description);
				}
			} else if (rnd <0.9){
				monoxido = new Monoxido(Math.random() * (200 - 400) + 400);
				criticidad="Media";
				description="El nivel de monóxido de carbono es elevado. Entre 200 y 400 partes por millón";
				dao.createAviso(criticidad, patientEmail, description);
			} else {
				monoxido = new Monoxido(Math.random() * (400 - 2000) + 2000);
				criticidad="Alta";
				description="El nivel de monóxido de carbono es crítico. Por encima de 400 partes por millón";
				dao.createAviso(criticidad, patientEmail, description);
			}
			patient.setTension(tension);
			patient.setPulsaciones(pulsaciones);
			patient.setMonoxido(monoxido);
			dao.updatePatient(patient);
		}
	}
}
