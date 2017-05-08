package es.upm.dit.isst.icare.model;

import java.io.Serializable;
import java.util.Date;


public class Monoxido implements Serializable, Comparable<Monoxido> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	// ppm: partes por millon
	private double ppm;
	
	public Monoxido() {}
	
	public Monoxido(double ppm) {
		this.ppm = ppm;
		this.date = new Date();
	}
	
	public Monoxido(double ppm, Date date) {
		this.ppm = ppm;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPpm() {
		return ppm;
	}

	public void setPpm(double ppm) {
		this.ppm = ppm;
	}

	@Override
	public int compareTo(Monoxido monoxido) {
		if (monoxido.getDate().getTime() > this.getDate().getTime()) {
			return -1;
		} else if (monoxido.getDate().getTime() < this.getDate().getTime()) {
			return 1;
		}
		return 0;
	}

}

