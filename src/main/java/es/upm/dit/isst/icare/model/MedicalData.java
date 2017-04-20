package es.upm.dit.isst.icare.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class MedicalData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private  String email;
	@Index
	private  String alergias;
	private  String cardiopatias;
	private  String cardiovasculares;
	private  String mentales;
	private  String gruposanguineo;
	private  String medicacion;
	private  String invalidez;
	private  String otrasafecciones;
	private  String sobrepeso;
	
	public MedicalData() {}
	
	public MedicalData(String email, String alergias, String cardiopatias, String cardiovasculares, String mentales,
			String gruposanguineo, String medicacion, String invalidez, String otrasafecciones, String sobrepeso) {
		super();
		this.email = email;
		this.alergias = alergias;
		this.cardiopatias = cardiopatias;
		this.cardiovasculares = cardiovasculares;
		this.mentales = mentales;
		this.gruposanguineo = gruposanguineo;
		this.medicacion = medicacion;
		this.invalidez = invalidez;
		this.otrasafecciones = otrasafecciones;
		this.sobrepeso = sobrepeso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getCardiopatias() {
		return cardiopatias;
	}

	public void setCardiopatias(String cardiopatias) {
		this.cardiopatias = cardiopatias;
	}

	public String getCardiovasculares() {
		return cardiovasculares;
	}

	public void setCardiovasculares(String cardiovasculares) {
		this.cardiovasculares = cardiovasculares;
	}

	public String getMentales() {
		return mentales;
	}

	public void setMentales(String mentales) {
		this.mentales = mentales;
	}

	public String getGruposanguineo() {
		return gruposanguineo;
	}

	public void setGruposanguineo(String gruposanguineo) {
		this.gruposanguineo = gruposanguineo;
	}

	public String getMedicacion() {
		return medicacion;
	}

	public void setMedicacion(String medicacion) {
		this.medicacion = medicacion;
	}

	public String getInvalidez() {
		return invalidez;
	}

	public void setInvalidez(String invalidez) {
		this.invalidez = invalidez;
	}

	public String getOtrasafecciones() {
		return otrasafecciones;
	}

	public void setOtrasafecciones(String otrasafecciones) {
		this.otrasafecciones = otrasafecciones;
	}

	public String getSobrepeso() {
		return sobrepeso;
	}

	public void setSobrepeso(String sobrepeso) {
		this.sobrepeso = sobrepeso;
	}


}
