package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		
		Cookie usuarioLogado = new Cookies(request.getCookies()).getUsuarioLogado();
		if (usuarioLogado == null) {
			writer.println("Não há usuário logado.");
			return;
		}
		
		HttpSession session = request.getSession();
		session.removeAttribute("usuario.logado");
		
		writer.println("Logout efetuado.");
		writer.println("</body></html>");
	}

}
