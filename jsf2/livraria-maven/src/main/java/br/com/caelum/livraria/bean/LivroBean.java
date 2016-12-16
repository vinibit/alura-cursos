package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDAO;
import br.com.caelum.livraria.dao.LivroDAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.LivroDataModel;
import br.com.caelum.livraria.tx.Transactional;

@Named
@ViewScoped
public class LivroBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Livro livro = new Livro();
	private Integer autorId;
	private List<Livro> livros;
	private List<String> generos = Arrays.asList("Romance", "Drama", "Ação", "Técnico");
	
	@Inject
	private LivroDataModel livroDataModel;
	@Inject
	private AutorDAO autorDAO;
	@Inject
	private LivroDAO livroDAO;

	public Livro getLivro() {
		return livro;
	}
	
	public void alterar(Livro livro) {
		this.livro = livroDAO.buscaPorId(livro.getId());
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public List<Autor> getAutores() {
		return autorDAO.listaTodos();
	}
	
	public List<Autor> getAutoresLivro() {
		return livro.getAutores();
	}
	
	public List<Livro> getLivros() {
		if (livros == null) livros = livroDAO.listaTodos(); 
		return livros;
	}
	
	public LivroDataModel getLivroDataModel() {
		return livroDataModel;
	}
	
	public List<String> getGeneros() {
		return generos;
	}
	
	public void comecaComDigitoUm(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (!value.toString().startsWith("9"))
			throw new ValidatorException(new FacesMessage("Valor do ISBN inválido!"));
	}
	
	public void limpar() {
		livro = new Livro();
		autorId = null;
	}
	
	@Transactional
	public void gravar() {
		if (livro.getAutores().isEmpty()) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("", new FacesMessage("Livro deve ter pelo menos um Autor."));
			return;
		}
		
		if (livro.getId() == null) {
			livroDAO.adiciona(livro);
		} else {
			livroDAO.atualiza(livro);
		}
		livros = livroDAO.listaTodos();
		
		livro = new Livro();
	}

	public void gravarAutor() {
		Autor autor = autorDAO.buscaPorId(autorId);
		livro.adicionaAutor(autor);
	}
	
	@Transactional
	public void remover(Livro livro) {
		livroDAO.remove(livro);
	}
	
	public void removerAutorLivro(Autor autor) {
		livro.removerAutor(autor);
	}
	
	public void carregarPelaId() {
		this.livro = livroDAO.buscaPorId(this.livro.getId());
		if (this.livro == null)
			this.livro = new Livro();
	}
	
	public boolean precoMenor(Object valor, Object filtro, Locale locale) {
		if (filtro == null) return true;
		String texto = filtro.toString().trim();
		
		if (texto.isEmpty()) return true;
		
		if (valor == null) return false;
		
		try {
			Double precoTexto = Double.valueOf(texto);
			Double precoValor = (Double) valor;
			
			return precoValor.compareTo(precoTexto) < 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
