package es.upm.dit.isst.icare;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.icare.dao.ICareDao;
import es.upm.dit.isst.icare.dao.ICareDaoImpl;
import es.upm.dit.isst.icare.model.Aviso;
import es.upm.dit.isst.icare.model.Patient;

public class Show_Aviso_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("avisoid"));
		ICareDao dao = ICareDaoImpl.getInstancia();
		Aviso aviso = dao.readAviso(id);
		String email = aviso.getPatientEmail();
		Patient patient = dao.readPatient(email);
		
		req.getSession().setAttribute("aviso", aviso);
		req.getSession().setAttribute("patient", patient);
		
		RequestDispatcher view = req.getRequestDispatcher ("show_aviso.jsp");
		view.forward(req,resp);
	}
}
