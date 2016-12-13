package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DAO<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final Class<T> classe;
	private EntityManager em;

	public DAO(Class<T> classe, EntityManager em) {
		this.classe = classe;
		this.em = em;
	}

	public void adiciona(T t) {
		em.persist(t);
	}

	public void remove(T t) {
		em.remove(em.merge(t));
	}

	public void atualiza(T t) {
		em.merge(t);
 	}

	public List<T> listaTodos() {
		CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(classe);
		return em.createQuery(cq.select(cq.from(classe)))
				.getResultList();
	}

	public T buscaPorId(Integer id) {
		T instancia = em.find(classe, id);
		return instancia;
	}

	public int contaTodos() {
		long result = (Long) em
				.createQuery("select count(n) from livro n")
				.getSingleResult();
		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		return lista;
	}
	
	public List<T> listaTodosPaginada(int firstResult, int maxResults, String coluna, String valor) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		Root<T> root = query.from(classe);
		
		if (valor != null)
			query = query.where(em.getCriteriaBuilder().like(root.<String>get(coluna), valor + "%"));
		
		List<T> list = em.createQuery(query)
			.setFirstResult(firstResult)
			.setMaxResults(maxResults)
			.getResultList();
		
		return list; 
	}
	
	public List<T> listaTodosPaginada(int firstResult, int maxResults, Map<String, Object> filters) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		Root<T> root = query.from(classe);
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		List<Predicate> predicates = new ArrayList<>();
		if (filters.get("titulo") != null)
			predicates.add(builder.like(root.<String>get("titulo"), filters.get("titulo") + "%"));
		if (filters.get("genero") != null)
			predicates.add(builder.like(root.<String>get("genero"), filters.get("genero") + "%"));
		if (filters.get("preco") != null)
			predicates.add(builder.le(root.<Double>get("preco"), Double.valueOf((filters.get("preco").toString()))));
		
		query.where(predicates.toArray(new Predicate[]{}));
		List<T> list = em.createQuery(query)
				.setFirstResult(firstResult)
				.setMaxResults(maxResults)
				.getResultList();
			
		
		return list;
	}
	
	public int quantidadeDeElementos() {
        long result = (Long) em
        		.createQuery("select count(n) from " + classe.getSimpleName() + " n")
                .getSingleResult();
        return (int) result;
	}

}
