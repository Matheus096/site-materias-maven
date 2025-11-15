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

@WebServlet(urlPatterns = "/enviar")
public class EnviarMateriasServlet extends HttpServlet {
	private static final long serialVersionUID = -2844281960054691040L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Repositorio repo = new Repositorio();
		String titulo = req.getParameter("titulo");
		String descricao = req.getParameter("descricao");
		
		Materias materia = new Materias();
		materia.setTitulo(titulo);
		materia.setDescricao(descricao);
		
		materia.setId(repo.pegarNovoId("MATERIAS"));
		HttpSession session = req.getSession();
		
		materia.setUsuario_id((Integer)session.getAttribute("id"));
		materia.setConcluido(true);
		repo.inserirMateria(materia);
		
		resp.sendRedirect("listagem");

	}

}
