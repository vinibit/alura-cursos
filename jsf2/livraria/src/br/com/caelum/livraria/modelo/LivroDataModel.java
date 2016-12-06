package br.com.caelum.livraria.modelo;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.livraria.dao.LivroDAO;

public class LivroDataModel extends LazyDataModel<Livro> {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LivroDAO dao;
	
	@PostConstruct
	public void init() {
		setRowCount(dao.quantidadeDeElementos());
	}
	
	@Override
	public List<Livro> load(int first, int pageSize, String sortField, SortOrder sortOrder,	Map<String, Object> filters) {
		return dao.listaTodosPaginada(first, pageSize, filters);
	}

}
