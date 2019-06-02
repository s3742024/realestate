package br.com.realstate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import br.com.realstate.models.BaseEntity;

public class GenericDAO<T extends BaseEntity> {
	
	public EntityManager getEM() {
		EntityManagerFactory ft = Persistence.createEntityManagerFactory("realstate");
		return ft.createEntityManager();
	}
	
	public T save(T t) throws Exception {
		EntityManager em = getEM();
		try {
		em.getTransaction().begin();
		//se a chave primária não existir executa insert
		if(em.find(t.getClass(), t.getId()) == null) {
			em.persist(t);
		}else {
			//verifica se o entitymanager conhece a entidade
			if(!em.contains(t)) {
				//se a chave primária da entidade não existir lança exceção
				if(em.find(t.getClass(), t.getId()) == null) {
					throw new Exception("Erro ao Atualizar!");
				}
			}
			//executa update
			t = em.merge(t);
		}
		em.getTransaction().commit();    
		}finally {
			em.close();
		}
		return t;
	}
	
	public void remove (Class<T> classe, int id) {
		EntityManager em = getEM();
		T t = em.find(classe, id);
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		}finally {
			em.close();
		}
	}
	
	public T getById(Class<T> classe, int id) {
		EntityManager em = getEM();
		T t = null;
		try {
			t = em.find(classe, id);
		}finally {
			em.close();
		}
		return t;
	}
	
	public List<T> getAll(Class<T> classe){
		EntityManager em = getEM();
		Session session = em.unwrap(Session.class);
		try {
			CriteriaQuery<T> cq = session.getCriteriaBuilder().createQuery(classe);
			cq.from(classe);
			List<T> lista = session.createQuery(cq).getResultList();
			return lista;
		}finally {
			em.close();
		}
		
	}

}
