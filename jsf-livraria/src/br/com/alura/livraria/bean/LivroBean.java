package br.com.alura.livraria.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LivroBean {
	private Livro livro = new Livro();

	public Livro getLivro() {
		return livro;
	}
	
	public void grava() {
		System.out.println("Gravando livro " + livro.getTitulo() +"!");
	}
	
}
