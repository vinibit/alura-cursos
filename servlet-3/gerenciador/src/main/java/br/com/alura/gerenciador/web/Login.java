package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		String mensagem = "";
		if (usuario == null) {
			mensagem = "Usu�rio ou senha inv�lida.";
		} else {
			mensagem = "Usu�rio logado: " + email;
			
			Cookie cookie = new Cookie("usuario.logado", email);
			resp.addCookie(cookie);
		}
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>" + mensagem + "</body></html>");
	}

}
