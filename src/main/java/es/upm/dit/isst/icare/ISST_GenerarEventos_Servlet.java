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


public class ISST_GenerarEventos_Servlet extends HttpServlet {
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
			Boolean caida= false;
			double rnd1 = Math.random();
			
			double aguacorriente= Math.random(); //probabilidad de que el agua este abierto mas de una hora >0.7.
			double rnd3 = Math.random();
			double acelerometro = Math.random();
			double caidausuario = Math.random();
			if (rnd1 > 0.9){
				criticidad="Alta";
				description="El paciente ha pulsado el botón de auxilio.";
				dao.createAviso(criticidad, patientEmail, description);
			}
			if(aguacorriente>0.7){ //Si lleva mas de una hora
				criticidad="Media";
				description="El paciente ha podido sufrir una caida en la ducha.";
				dao.createAviso(criticidad, patientEmail, description);
				caida=true;
			}
			
			// Evento: Acelerómetro
			// Correlar con cambio en la tension/pulsaciones
				
				if( acelerometro>0.9 && caidausuario>0.9){
					criticidad="Alta";
					description="El paciente ha sufrido una caida y no ha podido pulsar el botón de auxilio.";
					dao.createAviso(criticidad, patientEmail, description);
					caida=true;
				}
				else{
					caida=false;
				}
				
			//Cambia la localización del paciente 
			if (rnd3 > 0.6){
				if(patient.getIsAtHome()){
					patient.setIsAtHome(false);
				} else {
					patient.setIsAtHome(true);
				}
			}
			dao.updatePatient(patient);
		}
	}
}

