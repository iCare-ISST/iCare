package es.upm.dit.isst.icare.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Aviso implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static long idComun = 0;
	//ICareDao dao = ICareDaoImpl.getInstancia();
	
	@Id
	private long id;
	@Index
	private String criticidad, patientEmail, description;
	//private String patientEmail;
	//private String description;
	
	public Aviso(){
		super();
		this.id = ++idComun;
	}
	
	public Aviso(String criticidad, String description) {
		super();
		this.id = ++idComun;
		this.criticidad = criticidad;
		this.description = description;
	}
			
	public Aviso(String criticidad, String patientEmail, String description) {
		super();
		this.id = ++idComun;
		this.criticidad = criticidad;
		this.patientEmail = patientEmail;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
		//dao.updateAviso(this);
	}
	
	public String getPatientEmail() {
		return this.patientEmail;
	}
	
	public void setCriticidad(String criticidad) {
		this.criticidad = criticidad;
		//dao.updateAviso(this);
	}
	
	public String getCriticidad() {
		return this.criticidad;
	}
	
	public void setDescription(String description) {
		this.description = description;
		//dao.updateAviso(this);
	}
	
	public String getDescription() {
		return this.description;
	}
}
