package es.upm.dit.isst.icare.dao;

import java.util.List;

import es.upm.dit.isst.icare.model.Aviso;
import es.upm.dit.isst.icare.model.Patient;

public interface ICareDao {
	// Pacientes
	public Patient createPatient (String email, String patientname, String lastname, String mobilephone, String address);
	public Patient readPatient (String email);
	public List<Patient> readPatients ();
	public void updatePatient (Patient patient);
	public void deletePatient (Patient patient);
	public void deletePatientByPatientname (String email);
	
	// Avisos
	public Aviso createAviso (String criticidad, String patientEmail, String description);
	public Aviso readAviso (Long id);
	public List<Aviso> readAvisos ();
	public void updateAviso (Aviso aviso);
	public void deleteAviso (Aviso aviso);
	public void deleteAvisoById (Long id);
}
