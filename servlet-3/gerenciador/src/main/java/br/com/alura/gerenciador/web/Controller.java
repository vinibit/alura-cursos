package br.com.alura.gerenciador.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.tarefa.Tarefa;

/**
 * Servlet implementation class FazTudo
 */
@WebServlet("/executa")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeTarefa = request.getParameter("tarefa");
		if (nomeTarefa == null) 
			throw new IllegalArgumentException("Tarefa não informada");
		
		try {
			String nomeClasse = "br.com.alura.gerenciador.tarefa." + nomeTarefa;
			Class<?> type = Class.forName(nomeClasse);
			Tarefa tarefa = (Tarefa) type.newInstance();
			
			String pagina = tarefa.executa(request, response);
			
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
	}
}
