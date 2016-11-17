package br.com.caelum.livraria.bean;

public class FowardView {
	private String viewName;
	
	public FowardView(String viewName) {
		this.viewName = viewName;
	}
	
	@Override
	public String toString() {
		return viewName;
	}
}
