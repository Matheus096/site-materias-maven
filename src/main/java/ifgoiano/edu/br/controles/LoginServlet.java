package ifgoiano.edu.br.controles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ifgoiano.edu.br.entidades.Usuario;
import ifgoiano.edu.br.negocios.UsuarioNegocio;
import ifgoiano.edu.br.repositorio.Repositorio;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2844281960054691040L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		boolean successLogin = new UsuarioNegocio().verificarUsuario(email, senha);
		
		Repositorio repo = new Repositorio();
		
		Usuario usuario = repo.pegarUsuario(email, senha);
		
		if(successLogin) {
			HttpSession session = req.getSession();
			session.setAttribute("usuario", usuario);
			session.setAttribute("email", email);
			session.setAttribute("id", repo.pegarIdUsuario(email));
			
			resp.sendRedirect("listagem");
		}else {
			//redirecionar para a pagina de login com mensagem de erro
			req.setAttribute("mensagem2", "E-mail ou senha não encontrados!!");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
