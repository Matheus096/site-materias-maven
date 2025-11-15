package ifgoiano.edu.br.controles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ifgoiano.edu.br.entidades.Materias;
import ifgoiano.edu.br.entidades.Usuario;
import ifgoiano.edu.br.repositorio.Repositorio;

@WebServlet(urlPatterns = {"/editarUsuario", "/usuario/editarUsuario"})
public class EditarUsuario extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2938649978200464069L;

	//metodo que recebe formulario e altera no banco
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		Repositorio repo = new Repositorio();
		
		repo.atualizar(usuario);
		
		HttpSession session = req.getSession();
		req.setAttribute("materias", repo.pegarMPorUsuario((int) session.getAttribute("id")));
		req.getRequestDispatcher("usuario/listagem.jsp").forward(req, resp);
	}
	
	//metodo que mostra o html do formulario editar
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		
		Repositorio repo = new Repositorio();
		Usuario usuario = repo.pegarPorNome(nome);
		
		req.setAttribute("usuario", usuario);
		req.getRequestDispatcher("usuario/editarUsuario.jsp").forward(req, resp);
	}
}
