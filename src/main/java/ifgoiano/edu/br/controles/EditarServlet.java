package ifgoiano.edu.br.controles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ifgoiano.edu.br.entidades.Materias;
import ifgoiano.edu.br.entidades.Usuario;
import ifgoiano.edu.br.negocios.UsuarioNegocio;
import ifgoiano.edu.br.repositorio.Repositorio;

@WebServlet(urlPatterns = {"/editar", "/usuario/editar"})
public class EditarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3735326044183871201L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		
		String titulo = req.getParameter("titulo");
		String descricao = req.getParameter("descricao");
	    Integer id = (Integer) req.getSession().getAttribute("id_materia");
		
		Materias materia = new Materias();
		materia.setTitulo(titulo);
		materia.setDescricao(descricao);
		materia.setId(id);
		
		Repositorio repo = new Repositorio();
		repo.editarMateriaID(materia);
		
		req.setAttribute("materias", repo.pegarMPorUsuario((int) session.getAttribute("id")));
		req.getRequestDispatcher("usuario/listagem.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		Repositorio repo = new Repositorio();
		Materias matTitulo = repo.pegarPorID(id);
		
		session.setAttribute("id_materia", id);
		
		req.setAttribute("materia", matTitulo);
		req.getRequestDispatcher("usuario/editarMateria.jsp").forward(req, resp);
	}
}
