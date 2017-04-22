package es.upm.dit.isst.icare;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.icare.dao.ICareDao;
import es.upm.dit.isst.icare.dao.ICareDaoImpl;

public class Delete_Patient_Servlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		ICareDao dao = ICareDaoImpl.getInstancia();
		dao.deletePatientByPatientname(email);
		dao.deleteMedicalDataByEmail(email);
		dao.deleteRelativeByPatientEmail(email);
		dao.deleteAvisoByPatient(email);
		
		resp.sendRedirect("/");
		
	}
}
