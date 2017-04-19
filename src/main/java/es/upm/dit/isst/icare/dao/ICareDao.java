package es.upm.dit.isst.icare.dao;

import java.util.List;

import es.upm.dit.isst.icare.model.Patient;

public interface ICareDao {
 
	public Patient create (String email, String patientname, String lastname, String mobilephone, String address);

	public Patient readPatient (String patientname);
	public List<Patient> read ();
	public void update (Patient patient);
	public void delete (Patient patient);
	public void deletePatientByPatientname (String patientname);
}
