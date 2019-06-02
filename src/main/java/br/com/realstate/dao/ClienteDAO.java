package br.com.realstate.dao;

import br.com.realstate.models.Cliente;
import br.com.realstate.models.Usuario;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClienteDAO extends GenericDAO<Cliente>{

    public Cliente getCliente(String nome) {
        EntityManager em = getEM();
        Session session = em.unwrap(Session.class);
        Query query = session.createQuery("from Cliente where nome = :pNome");
        query.setParameter("pNome", nome);
        return (Cliente) query.getSingleResult();
    }
}
