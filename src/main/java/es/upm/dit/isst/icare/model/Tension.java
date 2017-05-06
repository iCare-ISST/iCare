package es.upm.dit.isst.icare.model;

import java.io.Serializable;
import java.util.Date;

public class Tension implements Serializable, Comparable<Tension>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private double tensionMax;
	private double tensionMin;
	
	public Tension() {};
	
	public Tension(double tensionMax, double tensionMin) {
		this.tensionMax = tensionMax;
		this.tensionMin = tensionMin;
		this.date = new Date();
	}
	
	public Tension(double tensionMax, double tensionMin, Date date) {
		this.tensionMax = tensionMax;
		this.tensionMin = tensionMin;
		this.date = date;
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
	
	public long getDateLong() {
		return this.date.getTime();
	}

	public void setTension(double tensionMax, double tensionMin) {
		this.tensionMax = tensionMax;
		this.tensionMin = tensionMin;
	}
	
	@Override
	public int compareTo(Tension t) {
		if (t.getDate().getTime() > this.getDate().getTime()) {
			return -1;
		} else if (t.getDate().getTime() < this.getDate().getTime()) {
			return 1;
		}
		return 0;
	}
}
