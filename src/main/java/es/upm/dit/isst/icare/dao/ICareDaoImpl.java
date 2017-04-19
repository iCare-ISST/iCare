package es.upm.dit.isst.icare.dao;

import java.util.List;

import com.googlecode.objectify.Key;

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

	@Override
	public Patient create(String email, String patientname, String lastname, String mobilephone, String address) {
		Patient patient = new Patient(email, patientname, lastname, mobilephone, address);
		ofy().save().entity(patient).now();
		return patient;
	}

	@Override
	public Patient readPatient(String patientname) {
		Patient patient = ofy().load().type(Patient.class).filterKey(Key.create(Patient.class, patientname)).first().now();
		return patient;
	}

	@Override
	public List<Patient> read() {
		List<Patient> patients = ofy().load().type(Patient.class).list();
		return patients;
	}

	@Override
	public void update(Patient patient) {
		ofy().save().entity(patient).now();
	}

	@Override
	public void delete(Patient patient) {
		ofy().delete().entity(patient).now();
	}

	@Override
	public void deletePatientByPatientname(String patientname) {
	}

}
