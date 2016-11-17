package br.com.caelum.livraria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

public class UsuarioDAO extends DAO<Usuario> {

	public UsuarioDAO() {
		super(Usuario.class);
	}

	public boolean existe(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		
        TypedQuery<Usuario> query = em
            .createQuery("select u from Usuario u where u.email = :pEmail and u.senha = :pSenha", Usuario.class)
            .setParameter("pEmail", usuario.getEmail())
        	.setParameter("pSenha", usuario.getSenha());
        List<Usuario> resultList = query.getResultList();
        
        em.close();

        return !resultList.isEmpty();
	}

}
