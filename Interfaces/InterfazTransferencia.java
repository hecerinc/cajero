package Interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import Controles.ControlExtraccion;

public class InterfazTransferencia extends HttpServlet {
	HttpServletResponse thisResponse;
	HttpServletRequest thisRequest;
	PrintWriter out;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		thisResponse = response;
		thisResponse.setContentType("text/html");
		out = thisResponse.getWriter();
		//Pagina Web de respuesta
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<title>Banco AMSS</title>");
		out.println("<h2>Cajero Electronico</h2>");
		out.println("<h3>Transferencia de Saldo</h3>");
		out.println("<p>Esta opción no esta disponible por el momento.</p>");
		out.println("<p></p>");
		out.println("<a href=\"menu.html\"> Regresar al menu principal </a>");
		out.println("</body>");
		out.println("</html>");
	}
}
