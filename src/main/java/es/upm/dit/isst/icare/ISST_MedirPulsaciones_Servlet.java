package es.upm.dit.isst.icare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.icare.dao.ICareDao;
import es.upm.dit.isst.icare.dao.ICareDaoImpl;
import es.upm.dit.isst.icare.model.Patient;
import es.upm.dit.isst.icare.model.Pulsaciones;

public class ISST_MedirPulsaciones_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String patientEmail = req.getParameter("patient");
		ICareDao dao = ICareDaoImpl.getInstancia();
		Patient patient = dao.readPatient(patientEmail);
		
		String criticidad = "";
		String description ="";
		
		//Medidas de Pulsaciones - Sensores Biométricos
		double pulsaciones_0_1 = Math.random();
		Pulsaciones pulsaciones;
		if (pulsaciones_0_1 < 0.7) {
			pulsaciones = new Pulsaciones(Math.random() * (60 - 100) + 100);
		} else if (pulsaciones_0_1 < 0.9) {
			pulsaciones = new Pulsaciones(Math.random() * (50 - 150) + 150);
			if (pulsaciones.getPulsaciones() < 60){
				criticidad="Media";
				description="Posible indicio de Bradicardia, las pulsaciones se encuentran entre 50 y 60 pulsaciones por minuto.";
				dao.createAviso(criticidad, patientEmail, description);
			} else if (pulsaciones.getPulsaciones() > 100 && pulsaciones.getPulsaciones() < 131){
				criticidad="Baja";
				description="Posible indicio de Taquicardia, las pulsaciones se encuentran entre 100 y 130 pulsaciones por minuto.";
				dao.createAviso(criticidad, patientEmail, description);
			} else if (pulsaciones.getPulsaciones() > 130 && pulsaciones.getPulsaciones() < 150){
				criticidad="Media";
				description="Posible indicio de Taquicardia, las pulsaciones se encuentran entre 130 y 150 pulsaciones por minuto.";
				dao.createAviso(criticidad, patientEmail, description);
			}  
		} else {
			pulsaciones = new Pulsaciones(Math.random() * (40 - 200) + 200);
			if (pulsaciones.getPulsaciones() < 50){
				criticidad="Alta";
				description="Bradicardia, las pulsaciones se encuentran por debajo de 50 pulsaciones por minuto.";
				dao.createAviso(criticidad, patientEmail, description);
			} else if (pulsaciones.getPulsaciones() < 60){
				criticidad="Media";
				description="Posible indicio de Bradicardia, las pulsaciones se encuentran entre 50 y 60 pulsaciones por minuto.";
				dao.createAviso(criticidad, patientEmail, description);
			} else if (pulsaciones.getPulsaciones() > 100 && pulsaciones.getPulsaciones() < 131){
				criticidad="Baja";
				description="Posible indicio de Taquicardia, las pulsaciones se encuentran entre 100 y 130 pulsaciones por minuto.";
				dao.createAviso(criticidad, patientEmail, description);
			} else if (pulsaciones.getPulsaciones() > 130 && pulsaciones.getPulsaciones() < 150){
				criticidad="Media";
				description="Posible indicio de Taquicardia, las pulsaciones se encuentran entre 130 y 150 pulsaciones por minuto.";
				dao.createAviso(criticidad, patientEmail, description);
			} else if (pulsaciones.getPulsaciones() > 150){
				criticidad="Alta";
				description="Taquicardia, las pulsaciones se encuentran por encima de 150 pulsaciones por minuto.";
				dao.createAviso(criticidad, patientEmail, description);
			} 
		}
		
		patient.setPulsaciones(pulsaciones);
		dao.updatePatient(patient);
		
		resp.sendRedirect("/verPaciente?email=" + patientEmail);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String patientEmail = req.getParameter("patient");
		int pulsacionesValor = Integer.parseInt(req.getParameter("pulsaciones"));
		ICareDao dao = ICareDaoImpl.getInstancia();
		Patient patient = dao.readPatient(patientEmail);
		
		String criticidad = "";
		String description ="";
		
		//Medidas de Pulsaciones - Sensores Biométricos
		Pulsaciones pulsaciones = new Pulsaciones(pulsacionesValor);		
		patient.setPulsaciones(pulsaciones);
		ArrayList<Pulsaciones> historico = patient.getPulsaciones();
		Iterator<Pulsaciones> historicoIt = historico.iterator();
		double valores[] = {0, 0, 0};
		int i = 3;
		while (historicoIt.hasNext()){
			Pulsaciones p = historicoIt.next();
			Date date = new Date();
			if (Math.abs(p.getDateLong() - date.getTime()) < 1 * 24 * 60 * 60 * 1000) {
	            valores[i % 3] = p.getPulsaciones();
	            i++;
			}
        }
	
		if (
				(valores[0] < 50 || valores[1] < 50 || valores[2] < 50) &&
				Math.abs(valores[0] - valores[1]) < 5 &&
				(Math.abs(valores[0] - valores[2]) < 5 ||
				 Math.abs(valores[1] - valores[2]) < 5)
			) {
			criticidad="Alta";
			description="Bradicardia, las pulsaciones se encuentran por debajo de 50 pulsaciones por minuto.";
			dao.createAviso(criticidad, patientEmail, description);
		} else if (
				(valores[0] < 60 || valores[1] < 60 || valores[2] < 60) &&
				Math.abs(valores[0] - valores[1]) < 5 &&
				(Math.abs(valores[0] - valores[2]) < 5 ||
				 Math.abs(valores[1] - valores[2]) < 5)
			){
			criticidad="Media";
			description="Posible indicio de Bradicardia, las pulsaciones se encuentran entre 50 y 60 pulsaciones por minuto.";
			dao.createAviso(criticidad, patientEmail, description);
		} else if (
				((valores[0] > 100 &&
				valores[0] < 131) ||
				(valores[1] > 100 &&
				valores[1] < 131) ||
				(valores[2] > 100 &&
				valores[2] < 131)) &&
				Math.abs(valores[0] - valores[1]) < 10 &&
				(Math.abs(valores[0] - valores[2]) < 10 ||
				 Math.abs(valores[1] - valores[2]) < 10)
			){
			criticidad="Baja";
			description="Posible indicio de Taquicardia, las pulsaciones se encuentran entre 100 y 130 pulsaciones por minuto.";
			dao.createAviso(criticidad, patientEmail, description);
		} else if (
				((valores[0] > 130 &&
				valores[0] < 150) ||
				(valores[1] > 130 &&
				valores[1] < 150) ||
				(valores[2] > 130 &&
				valores[2] < 150)) &&
				Math.abs(valores[0] - valores[1]) < 10 &&
				(Math.abs(valores[0] - valores[2]) < 10 ||
				 Math.abs(valores[1] - valores[2]) < 10)
			){
			criticidad="Media";
			description="Posible indicio de Taquicardia, las pulsaciones se encuentran entre 130 y 150 pulsaciones por minuto.";
			dao.createAviso(criticidad, patientEmail, description);
		} else if (
				(valores[0] >= 150 || valores[1] >= 150 || valores[2] >= 150) &&
				Math.abs(valores[0] - valores[1]) < 20 &&
				(Math.abs(valores[0] - valores[2]) < 20 ||
				 Math.abs(valores[1] - valores[2]) < 20)
			) {
			criticidad="Alta";
			description="Taquicardia, las pulsaciones se encuentran por encima de 150 pulsaciones por minuto.";
			dao.createAviso(criticidad, patientEmail, description);			
		}
		dao.updatePatient(patient);
	}
}
