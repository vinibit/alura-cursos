package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.tx.Transactional;
import br.com.caelum.livraria.util.RedirectView;

@Named
@ViewScoped
public class AutorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Autor autor = new Autor();
	
	@Inject
	private AutorDAO dao;

	public Autor getAutor() {
		return autor;
	}
	
	public List<Autor> getAutores() {
		return this.dao.listaTodos();
	}
	
	@Transactional
	public RedirectView gravar() {
		System.out.println("Gravando autor " + autor.getNome());
		if (autor.getId() == null) {
			dao.adiciona(autor);
		} else {
			dao.atualiza(autor);
		}
		
		autor = new Autor();
		return new RedirectView("livro");
	}
	
	@Transactional
	public void remover(Autor autor) {
		this.dao.remove(autor);
	}
	
	public void alterar(Autor autor) {
		this.autor = autor;
	}
	
	public void carregarPelaId() {
		this.autor = this.dao.buscaPorId(this.autor.getId());
		if (this.autor == null) 
			this.autor = new Autor();
	}
}
