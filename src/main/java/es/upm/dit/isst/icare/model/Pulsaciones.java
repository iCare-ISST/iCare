package es.upm.dit.isst.icare.model;

import java.io.Serializable;
import java.util.Date;

public class Pulsaciones implements Serializable, Comparable<Pulsaciones> {

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
	
	public Pulsaciones(double pulsaciones, Date date) {
		this.pulsaciones = pulsaciones;
		this.date = date;
	}
	
	public double getPulsaciones() {
		return this.pulsaciones;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public long getDateLong() {
		return this.date.getTime();
	}

	public void setPulsaciones(double pulsaciones) {
		this.pulsaciones = pulsaciones;
	}

	@Override
	public int compareTo(Pulsaciones p) {
		if (p.getDate().getTime() > this.getDate().getTime()) {
			return -1;
		} else if (p.getDate().getTime() < this.getDate().getTime()) {
			return 1;
		}
		return 0;
	}
}
