package es.upm.dit.isst.icare.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long Id;
	@Index
	private  String patientname;
	private  String lastname;
	private  String birthdate;
	private  String mobilephone;
	private  String landlinephone;
	private  String address;
	private  String location;
	private  String province;
	
	public Patient() {}

	public Patient(String patientname, String lastname,
			String mobilephone, String address) {
		super();
		this.patientname = patientname;
		this.lastname = lastname;	
		this.mobilephone = mobilephone;	
		this.address = address;
	}

	public Long getId() {
		return Id;
	}

	private void setId(Long id) {
		Id = id;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getLandlinephone() {
		return landlinephone;
	}

	public void setLandlinephone(String landlinephone) {
		this.landlinephone = landlinephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
