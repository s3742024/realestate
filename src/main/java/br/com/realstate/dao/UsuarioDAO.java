package br.com.realstate.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

import br.com.realstate.models.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario>{
	
	public Usuario getUser(String usuario, String senha) {
		EntityManager em = getEM();
		Session session = em.unwrap(Session.class);
		Query query = session.createQuery("from Usuario where email = :pLogin and senha = :pSenha");
		query.setParameter("pLogin", usuario);
		query.setParameter("pSenha", senha);
		return (Usuario) query.getSingleResult();
	}
}
