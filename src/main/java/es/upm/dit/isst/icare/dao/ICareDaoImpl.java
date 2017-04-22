package es.upm.dit.isst.icare.dao;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Key;

import es.upm.dit.isst.icare.model.Aviso;
import es.upm.dit.isst.icare.model.MedicalData;
import es.upm.dit.isst.icare.model.Patient;
import es.upm.dit.isst.icare.model.Relative;

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
	public List<Aviso> readAvisoByCriticidad (String criticidad) {
		return ofy().load().type(Aviso.class).filter("criticidad", criticidad).list();
	}
	
	@Override
	public List<Aviso> readAvisoByPatient (String patient) {
		return ofy().load().type(Aviso.class).filter("patientEmail", patient).list();
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
		if (aviso != null)
			this.deleteAviso(aviso);
	}
	
	@Override
	public void deleteAvisoByPatient (String patient) {
		List<Aviso> avisosAux = this.readAvisoByPatient(patient);
		ArrayList<Aviso> avisos = new ArrayList<>(avisosAux);
		for (Aviso aviso: avisos) {
			this.deleteAviso(aviso);
		}
	}

	//MedicalData
	
	@Override
	public MedicalData createMedicalData(String email, String alergias, String cardiopatias, String cardiovasculares,
			String mentales, String gruposanguineo, String medicacion, String invalidez, String otrasafecciones,
			String sobrepeso) {
	
		MedicalData medicaldata = new MedicalData(email,alergias, cardiopatias, cardiovasculares,
				mentales, gruposanguineo, medicacion,invalidez, otrasafecciones, sobrepeso);
		ofy().save().entity(medicaldata).now();
		return medicaldata;
	}

	@Override
	public MedicalData readMedicalData(String email) {
		MedicalData medicaldata = ofy().load().type(MedicalData.class).filterKey(Key.create(MedicalData.class, email)).first().now();
		return medicaldata;
	}

	@Override
	public void updateMedicalData(MedicalData medicaldata) {
		ofy().save().entity(medicaldata).now();
		
	}

	@Override
	public void deleteMedicalData(MedicalData medicaldata) {
		ofy().delete().entity(medicaldata).now();
		
	}

	@Override
	public void deleteMedicalDataByEmail(String email) {
		MedicalData medicaldata = this.readMedicalData(email);
		if (medicaldata != null)
			this.deleteMedicalData(medicaldata);		
	}
	
	// Relatives

	@Override
	public Relative createRelative(String patientemail, String relativename, String lastname, String mobilephone,
			String landlinephone, String address, String location, String province) {
		
		Relative relative = new Relative(patientemail, relativename, lastname, mobilephone, landlinephone, address, location, province);
		ofy().save().entity(relative).now();
		return relative;
	}

	@Override
	public Relative readRelative(String patientemail) {
		Relative relative = ofy().load().type(Relative.class).filterKey(Key.create(Relative.class, patientemail)).first().now();
		return relative;
	}

	@Override
	public List<Relative> readRelatives() {
		List<Relative> relatives = ofy().load().type(Relative.class).list();
		return relatives;
	}

	@Override
	public void updateRelative(Relative relative) {
		ofy().save().entity(relative).now();		
	}

	@Override
	public void deleteRelative(Relative relative) {
		ofy().delete().entity(relative).now();
	}

	@Override
	public void deleteRelativeByPatientEmail(String patientemail) {
		Relative relative = this.readRelative(patientemail);
		if (relative != null)
			this.deleteRelative(relative);
	}

}
