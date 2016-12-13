package br.com.caelum.livraria.util;

public class RedirectView {
	private String viewName;
	
	public RedirectView(String viewName) {
		this.viewName = viewName;
	}
	
	@Override
	public String toString() {
		return viewName + "?redirect-view=true";
	}
}
