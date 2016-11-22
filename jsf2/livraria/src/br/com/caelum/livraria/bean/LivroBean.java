package br.com.caelum.livraria.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.LivroDataModel;

@ManagedBean
@ViewScoped
public class LivroBean {

	private Livro livro = new Livro();
	private Integer autorId;
	private List<Livro> livros;
	private LivroDataModel livroDataModel = new LivroDataModel();
	private List<String> generos = Arrays.asList("Romance", "Drama", "Ação");

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
		DAO<Livro> dao = new DAO<Livro>(Livro.class);
		if (livros == null) livros = dao.listaTodos(); 
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
		livros = dao.listaTodos();
		
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
