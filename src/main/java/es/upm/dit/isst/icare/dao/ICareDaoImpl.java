package es.upm.dit.isst.icare.dao;

import java.util.List;

import com.googlecode.objectify.Key;

import es.upm.dit.isst.icare.model.Aviso;
import es.upm.dit.isst.icare.model.Patient;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class ICareDaoImpl implements ICareDao {

	private static ICareDaoImpl instancia;
	
	private ICareDaoImpl () {}
	
	public static ICareDaoImpl getInstancia () {
		if ( instancia == null)
			instancia = new ICareDaoImpl ();
		return instancia;
	}
	
	// Patients

	@Override
	public Patient createPatient(String email, String patientname, String lastname, String birthdate,
			String mobilephone, String landlinephone, String address, String location, String province) {
		Patient patient = new Patient(email, patientname, lastname, birthdate, mobilephone, landlinephone, address, location, province);
		ofy().save().entity(patient).now();
		return patient;
	}

	@Override
	public Patient readPatient(String email) {
		Patient patient = ofy().load().type(Patient.class).filterKey(Key.create(Patient.class, email)).first().now();
		return patient;
	}

	@Override
	public List<Patient> readPatients() {
		List<Patient> patients = ofy().load().type(Patient.class).list();
		return patients;
	}

	@Override
	public void updatePatient(Patient patient) {
		ofy().save().entity(patient).now();
	}

	@Override
	public void deletePatient(Patient patient) {
		ofy().delete().entity(patient).now();
	}
	
	@Override
	public void deletePatientByPatientname(String email) {
		Patient patient = this.readPatient(email);
		this.deletePatient(patient);
	}
	
	// Avisos
	
	@Override
	public Aviso createAviso (String criticidad, String patientEmail, String description) {
		Aviso aviso = new Aviso(criticidad, patientEmail, description);
		ofy().save().entity(aviso).now();
		return aviso;
	}
	
	@Override
	public Aviso readAviso (Long id) {
		Aviso aviso = ofy().load().type(Aviso.class).filterKey(Key.create(Aviso.class, id)).first().now();
		return aviso;
	}
	
	@Override
	public List<Aviso> readAvisos () {
		List<Aviso> avisos = ofy().load().type(Aviso.class).list();
		return avisos;
	}
	
	@Override
	public void updateAviso (Aviso aviso) {
		ofy().save().entity(aviso).now();
	}
	
	@Override
	public void deleteAviso (Aviso aviso) {
		ofy().delete().entity(aviso).now();
	}
	
	@Override
	public void deleteAvisoById (Long id) {
		Aviso aviso = this.readAviso(id);
		this.deleteAviso(aviso);
	}

}
