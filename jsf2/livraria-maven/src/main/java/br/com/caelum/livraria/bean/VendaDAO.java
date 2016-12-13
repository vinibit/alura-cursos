package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Venda;

public class VendaDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	private DAO<Venda> dao;
	
	@PostConstruct
	public void init() {
		dao = new DAO<>(Venda.class, manager);
	}
	
	public List<Venda> todas() {
		return dao.listaTodos();
	}
	
}
