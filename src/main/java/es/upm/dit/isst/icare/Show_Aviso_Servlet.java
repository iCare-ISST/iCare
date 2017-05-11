package es.upm.dit.isst.icare;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.ICareDao;
import es.upm.dit.isst.icare.dao.ICareDaoImpl;
import es.upm.dit.isst.icare.model.Aviso;
import es.upm.dit.isst.icare.model.Patient;
import es.upm.dit.isst.icare.model.Relative;

public class Show_Aviso_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Relative.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("avisoid"));
		ICareDao dao = ICareDaoImpl.getInstancia();
		Aviso aviso = dao.readAviso(id);
		String email = aviso.getPatientEmail();
		Patient patient = dao.readPatient(email);
		Relative relative = dao.readRelative(email);
		
		req.getSession().setAttribute("aviso", aviso);
		req.getSession().setAttribute("patient", patient);
		req.getSession().setAttribute("relative", relative);
		
		RequestDispatcher view = req.getRequestDispatcher ("show_aviso.jsp");
		view.forward(req,resp);
	}
}
