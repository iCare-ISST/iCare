package es.upm.dit.isst.icare.model;

import java.io.Serializable;
import java.util.Date;

public class Tension implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private double tensionMax;
	private double tensionMin;
	
	public Tension() {};
	
	public Tension(double tensionMax, double tensionMin, Date date) {
		this.tensionMax = tensionMax;
		this.tensionMin = tensionMin;
		this.date = date;//new Date();
	}
	
	public double getTensionMax() {
		return tensionMax;
	}
	
	public double getTensionMin() {
		return tensionMin;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	@SuppressWarnings("deprecation")
	public int getYear() {
		return this.date.getYear() + 1900;
	}
	
	@SuppressWarnings("deprecation")
	public int getMonth() {
		return this.date.getMonth();
	}
	
	@SuppressWarnings("deprecation")
	public int getDay() {
		return this.date.getDay();
	}
}
