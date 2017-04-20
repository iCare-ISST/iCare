package es.upm.dit.isst.icare.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Relative implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private  String email;
	@Index
	private  String relativename;
	private  String lastname;
	private  String mobilephone;
	private  String landlinephone;
	private  String address;
	private  String location;
	private  String province;
	
	public Relative() {}
	
	public Relative(String email, String relativename, String lastname,
			String mobilephone, String landlinephone, String address, String location, String province) {
		super();
		this.email = email;
		this.relativename = relativename;
		this.lastname = lastname;
		this.mobilephone = mobilephone;	
		this.landlinephone = landlinephone;
		this.address = address;
		this.location = location;
		this.province = province;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRelativename() {
		return relativename;
	}

	public void setRelativename(String relativename) {
		this.relativename = relativename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
