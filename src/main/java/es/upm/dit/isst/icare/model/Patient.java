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
	private  Integer Id;
	private  String patientname;
	private  String lastname;
	private  String birthdate;
	private  String mobilephone;
	private  String landlinephone;
	private  String address;
	private  String location;
	private  String province;
	
	public Patient() {}

	public Patient(String patientname, String lastname, String birthdate,
			String mobilephone, String landlinephone, String address, String location, String province) {
		super();
		this.patientname = patientname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.mobilephone = mobilephone;
		this.landlinephone = landlinephone;
		this.address = address;
		this.location = location;
		this.province = province;
	}
}
