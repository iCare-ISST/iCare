package es.upm.dit.isst.icare;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.icare.dao.ICareDao;
import es.upm.dit.isst.icare.dao.ICareDaoImpl;

public class ISST_NuevoAviso_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String patientEmail = req.getParameter("patient");
		req.getSession().setAttribute("patientEmail" , patientEmail);
		
		RequestDispatcher view = req.getRequestDispatcher ("Form_Aviso.jsp");
		view.forward(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String patientEmail = req.getParameter("patientemail");
		String criticidad = req.getParameter("criticidad");
		String description = req.getParameter("description");
		
		ICareDao dao = ICareDaoImpl.getInstancia();
		dao.createAviso(criticidad, patientEmail, description);
		
		resp.sendRedirect("/verPaciente?email=" + patientEmail);
		
	}

}
