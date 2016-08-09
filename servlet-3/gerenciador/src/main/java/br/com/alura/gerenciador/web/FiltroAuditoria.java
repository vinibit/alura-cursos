package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class FiltroAuditoria implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();
		
		String usuario = "[deslogado]";
		Cookie usuarioLogado = new Cookies(httpRequest.getCookies()).getUsuarioLogado();
		if (usuarioLogado != null) {
			usuario = usuarioLogado.getValue();
			usuarioLogado.setMaxAge(10 * 60);
			((HttpServletResponse) response).addCookie(usuarioLogado);
		}
		System.out.println("Usuário " + usuario  + " acessando a URI " + uri );
		
		chain.doFilter(httpRequest, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void destroy() {
	}
	
}
