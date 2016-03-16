package Interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import Controles.ControlExtraccion;

public class InterfazConsulta extends HttpServlet {
	// HttpServletResponse thisResponse;
	// HttpServletRequest thisRequest;
	// PrintWriter out;
	// ControlExtraccion ce;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setAttribute("isPost", false);
		request.getRequestDispatcher("consulta.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("isPost", true);
		int cuenta = Integer.parseInt(request.getParameter("cuenta").trim());
		// Validate that the account exists
		ControlExtraccion ce = new ControlExtraccion();
		boolean exists = ce.validarCuenta(cuenta);

		if(exists){
			float saldo = ce.consultaSaldo(cuenta);
			request.setAttribute("saldo", saldo);
		}
		request.setAttribute("exists", exists);
		request.setAttribute("cuenta", cuenta);
		request.getRequestDispatcher("consulta.jsp").forward(request, response);
	}

}
