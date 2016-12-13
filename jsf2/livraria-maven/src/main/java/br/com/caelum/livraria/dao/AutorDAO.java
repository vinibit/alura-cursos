package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Autor;

public class AutorDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager manager;
	private DAO<Autor> dao;
	
	@PostConstruct
	private void init() {
		dao = new DAO<>(Autor.class, manager);
	}

	public void adiciona(Autor t) {
		dao.adiciona(t);
	}

	public void atualiza(Autor t) {
		dao.atualiza(t);
	}
	
	public void remove(Autor t) {
		dao.remove(t);
	}

	public List<Autor> listaTodos() {
		return dao.listaTodos();
	}

	public Autor buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}

	public int contaTodos() {
		return dao.contaTodos();
	}

	public List<Autor> listaTodosPaginada(int firstResult, int maxResults) {
		return dao.listaTodosPaginada(firstResult, maxResults);
	}

	public List<Autor> listaTodosPaginada(int firstResult, int maxResults, String coluna, String valor) {
		return dao.listaTodosPaginada(firstResult, maxResults, coluna, valor);
	}

	public List<Autor> listaTodosPaginada(int firstResult, int maxResults, Map<String, Object> filters) {
		return dao.listaTodosPaginada(firstResult, maxResults, filters);
	}

	public int quantidadeDeElementos() {
		return dao.quantidadeDeElementos();
	}
	
}
