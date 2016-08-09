package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {
	
	private Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public Cookie getUsuarioLogado() {
		Cookie usuarioLogado = null;
		for (Cookie	cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				usuarioLogado = cookie;
			}
		}
		return usuarioLogado;
	}
	
}
