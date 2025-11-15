package ifgoiano.edu.br.controles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ifgoiano.edu.br.entidades.Materias;
import ifgoiano.edu.br.repositorio.Repositorio;

@WebServlet(urlPatterns = "/materias")
public class MateriasServlet extends HttpServlet{
	
	private static final long serialVersionUID = -2844281960054691040L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("index.jsp");

	}
	
}
