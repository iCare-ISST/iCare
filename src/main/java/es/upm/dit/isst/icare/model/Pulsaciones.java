package es.upm.dit.isst.icare.model;

import java.io.Serializable;
import java.util.Date;

public class Pulsaciones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private double pulsaciones;
	
	public Pulsaciones() {};
	
	public Pulsaciones(double pulsaciones) {
		this.pulsaciones = pulsaciones;
		this.date = new Date();
	}
	
	public double getPulsaciones() {
		return this.pulsaciones;
	}
	
	public Date getDate() {
		return this.date;
	}

	public void setPulsaciones(double pulsaciones) {
		this.pulsaciones = pulsaciones;
	}
}
