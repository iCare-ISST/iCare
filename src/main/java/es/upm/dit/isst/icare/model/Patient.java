package es.upm.dit.isst.icare.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ICareDao dao = ICareDaoImpl.getInstancia();
	
	//private Long Id;
	@Id
	private String email;
	@Index
	private String patientname;
	private String lastname;
	private String birthdate;
	private String mobilephone;
	private String landlinephone;
	private String address;
	private String location;
	private String province;
	private ArrayList<Tension> tension = new ArrayList<>();
	private ArrayList<Pulsaciones> pulsaciones = new ArrayList<>();
	private ArrayList<Monoxido> monoxido = new ArrayList<>();
	private Boolean isAtHome; 

	public Patient() {}

	public Patient(String email, String patientname, String lastname, String birthdate,
			String mobilephone, String landlinephone, String address, String location, String province) {
		super();
		this.email = email;
		this.patientname = patientname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.mobilephone = mobilephone;	
		this.landlinephone = landlinephone;
		this.address = address;
		this.location = location;
		this.province = province;
		this.isAtHome = true;
	}

	/*public Long getId() {
		return Id;
	}

	private void setId(Long id) {
		Id = id;
	}*/
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
		//dao.updatePatient(this);
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
		//dao.updatePatient(this);
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
		//dao.updatePatient(this);
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
		//dao.updatePatient(this);
	}

	public String getLandlinephone() {
		return landlinephone;
	}

	public void setLandlinephone(String landlinephone) {
		this.landlinephone = landlinephone;
		//dao.updatePatient(this);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		//dao.updatePatient(this);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
		//dao.updatePatient(this);
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
		//dao.updatePatient(this);
	}
	
	public ArrayList<Tension> getTension() {
		return this.tension;
	}

	public void setTension(Tension tension) {
		this.tension.add(tension);
		Collections.sort(this.tension);
		//dao.updatePatient(this);
	}
	
	public double getTensionMaxMedia() {
		Iterator<Tension> tension = this.tension.iterator();
		double suma = 0;
		while (tension.hasNext()){
            suma += tension.next().getTensionMax();
        }
		return suma/this.tension.size();
	}
	
	public double getTensionMinMedia() {
		Iterator<Tension> tension = this.tension.iterator();
		double suma = 0;
		while (tension.hasNext()){
            suma += tension.next().getTensionMin();
        }
		return suma/this.tension.size();
	}
	
	public ArrayList<Pulsaciones> getPulsaciones() {
		return this.pulsaciones;
	}

	public void setPulsaciones(Pulsaciones pulsaciones) {
		this.pulsaciones.add(pulsaciones);
		Collections.sort(this.pulsaciones);
		//dao.updatePatient(this);
	}
	
	public double getPulsacionesMedia() {
		Iterator<Pulsaciones> pulsaciones = this.pulsaciones.iterator();
		double suma = 0;
		while (pulsaciones.hasNext()){
            suma += pulsaciones.next().getPulsaciones();
        }
		return suma/this.pulsaciones.size();
	}
	public ArrayList<Monoxido> getMonoxido() {
		return this.monoxido;
	}

	public void setMonoxido(Monoxido monoxido) {
		this.monoxido.add(monoxido);
		Collections.sort(this.monoxido);
		//dao.updatePatient(this);
	}
	
	public double getMonoxidoMedia() {
		Iterator<Monoxido> monoxido = this.monoxido.iterator();
		double suma = 0;
		while (monoxido.hasNext()){
            suma += monoxido.next().getPpm();
        }
		return suma/this.monoxido.size();
	}
	
	public Boolean getIsAtHome() {
		return isAtHome;
	}

	public void setIsAtHome(Boolean isAtHome) {
		this.isAtHome = isAtHome;
	}
}
