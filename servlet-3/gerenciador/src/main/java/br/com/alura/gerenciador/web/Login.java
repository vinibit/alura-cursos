package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		String mensagem = "";
		if (usuario == null) {
			mensagem = "Usuário ou senha inválida.";
		} else {
			mensagem = "Usuário logado: " + email;
			
			HttpSession session = request.getSession();
			session.setAttribute("usuario.logado", usuario);
		}
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>" + mensagem + "</body></html>");
	}

}
