package ifgoiano.edu.br.controles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifgoiano.edu.br.entidades.Materias;
import ifgoiano.edu.br.entidades.Usuario;
import ifgoiano.edu.br.repositorio.Repositorio;

@WebServlet(urlPatterns = "/deletar")
public class DeletarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -658215089693583994L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titulo = req.getParameter("titulo");
		Repositorio repo = new Repositorio();
		repo.deletarMateria(titulo);
		List<Materias> materias = repo.pegarMPorUsuario((Integer) req.getSession().getAttribute("id"));
		req.setAttribute("materias", materias);
		req.getRequestDispatcher("usuario/listagem.jsp").forward(req, resp);
	}
}
