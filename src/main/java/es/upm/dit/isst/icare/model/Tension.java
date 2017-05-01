package es.upm.dit.isst.icare.model;

import java.util.Date;

public class Tension {

	private Date date;
	private double tensionMax;
	private double tensionMin;
	
	public Tension(double tensionMax, double tensionMin) {
		this.tensionMax = tensionMax;
		this.tensionMin = tensionMin;
		this.date = new Date();
	}
	
	public double[] getTension() {
		double[] tension = {this.tensionMax, this.tensionMin};
		return tension;
	}
	
	public Date getDate() {
		return this.date;
	}
}
