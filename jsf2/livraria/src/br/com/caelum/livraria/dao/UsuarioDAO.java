package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

public class UsuarioDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	private DAO<Usuario> dao;

	@PostConstruct
	public void init() {
		this.dao = new DAO<>(Usuario.class, manager);
	}

	public boolean existe(Usuario usuario) {
        TypedQuery<Usuario> query = manager
            .createQuery("select u from Usuario u where u.email = :pEmail and u.senha = :pSenha", Usuario.class)
            .setParameter("pEmail", usuario.getEmail())
        	.setParameter("pSenha", usuario.getSenha());
        List<Usuario> resultList = query.getResultList();

        return !resultList.isEmpty();
	}

}
