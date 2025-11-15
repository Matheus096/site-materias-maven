package ifgoiano.edu.br.controles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/pegar", "/usuario/pegar"})
public class Pegar extends HttpServlet {

	private static final long serialVersionUID = -5549147777261447178L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titulo = req.getParameter("titulo");	
		req.setAttribute("titulo", titulo);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + titulo);
		req.getRequestDispatcher("listagem").forward(req, resp);
	}

}
