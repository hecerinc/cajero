package Interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import Controles.ControlExtraccion;

public class InterfazTransferencia extends HttpServlet {
	// HttpServletResponse thisResponse;
	// HttpServletRequest thisRequest;
	// PrintWriter out;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		// This is where we keep writing
		request.setAttribute("isPost", false);
		request.getRequestDispatcher("transferencia.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setAttribute("isPost", true);

		int origen = Integer.parseInt(request.getParameter("origen").trim());
		int destino = Integer.parseInt(request.getParameter("destino").trim());
		float monto = Float.valueOf(request.getParameter("monto").trim()).floatValue();

		// Validate that the account exists
		ControlExtraccion ce = new ControlExtraccion();
		boolean originExists = ce.validarCuenta(origen);
		boolean destinationExists = ce.validarCuenta(destino);
		boolean error = false;
		if(originExists && destinationExists){
			// Proceed with operation
			if(ce.extraerEfectivo(origen, monto)){
				// Deposita a destino
				ce.depositar(destino, monto);
			}
			else{
				error = true;
			}

		}
		else
			error = true;

		request.setAttribute("error", error);
		request.getRequestDispatcher("transferencia.jsp").forward(request, response);
	}
}
