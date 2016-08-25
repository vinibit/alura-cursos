package br.com.alura.gerenciador.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		session.removeAttribute("usuarioLogado");
		
		return "/WEB-INF/paginas/logout.html";
	}

}
