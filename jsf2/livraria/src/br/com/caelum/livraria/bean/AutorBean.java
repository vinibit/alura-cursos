package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.util.RedirectView;

@ViewScoped 
@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}
	
	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public RedirectView gravar() {
		System.out.println("Gravando autor " + autor.getNome());
		DAO<Autor> dao = new DAO<Autor>(Autor.class);
		if (autor.getId() == null) {
			dao.adiciona(autor);
		} else {
			dao.atualiza(autor);
		}
		
		autor = new Autor();
		return new RedirectView("livro");
	}
	
	public void remover(Autor autor) {
		new DAO<Autor>(Autor.class).remove(autor);
	}
	
	public void alterar(Autor autor) {
		this.autor = autor;
	}
	
	public void carregarPelaId() {
		this.autor = new DAO<Autor>(Autor.class).buscaPorId(this.autor.getId());
		if (this.autor == null) 
			this.autor = new Autor();
	}
}
