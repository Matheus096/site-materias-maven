package ifgoiano.edu.br.controles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ifgoiano.edu.br.repositorio.Repositorio;

@WebServlet(urlPatterns = "/listagem")
public class ListagemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6581892271843389281L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Repositorio repo = new Repositorio();
		
		if(session.getAttribute("id") == null) {
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("materias", repo.pegarMPorUsuario((int) session.getAttribute("id")));
			req.getRequestDispatcher("usuario/listagem.jsp").forward(req, resp);
		
		}
	}
}
