package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@ManagedBean
@ViewScoped
public class LivroBean {

	private Livro livro = new Livro();
	private Integer autorId;

	public Livro getLivro() {
		return livro;
	}
	
	public void alterar(Livro livro) {
		System.out.println("Carregando livro " + livro.getTitulo());
		this.livro = livro;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public List<Autor> getAutoresLivro() {
		return livro.getAutores();
	}
	
	public List<Livro> getLivros() {
		return new DAO<Livro>(Livro.class).listaTodos(); 
	}
	
	public void comecaComDigitoUm(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (!value.toString().startsWith("1"))
			throw new ValidatorException(new FacesMessage("Valor do ISBN inválido!"));
	}
	 
	public void gravar() {
		if (livro.getAutores().isEmpty()) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("", new FacesMessage("Livro deve ter pelo menos um Autor."));
			return;
		}
		
		DAO<Livro> dao = new DAO<Livro>(Livro.class);
		if (livro.getId() == null) {
			dao.adiciona(livro);
		} else {
			dao.atualiza(livro);
		}
		
		livro = new Livro();
	}

	public void gravarAutor() {
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
		livro.adicionaAutor(autor);
	}
	
	public void remover(Livro livro) {
		System.out.println("Removendo livro " + livro.getTitulo());
		new DAO<Livro>(Livro.class).remove(livro);
	}
	
	public void removerAutorLivro(Autor autor) {
		livro.removerAutor(autor);
	}
	
	public void carregarPelaId() {
		this.livro = new DAO<Livro>(Livro.class).buscaPorId(this.livro.getId());
		if (this.livro == null)
			this.livro = new Livro();
	}
}
