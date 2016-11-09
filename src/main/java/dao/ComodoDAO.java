package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Comodo;

@Stateless
public class ComodoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Comodo c) {
		em.persist(c);
	}
	
	public void atualizar(Comodo c) {
		em.merge(c);
	}
	
	public void remover(Comodo c) {
		c = em.find(Comodo.class, c.getId());
		em.remove(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<Comodo> listar() {
		String qs = "select p from Comodo c";
		Query q = em.createQuery(qs);
		return (List<Comodo>) q.getResultList();
	}
	
	public Comodo buscarComodoNome(String nome) {
		String qs = "select p from Comodo c where p.nome = :nome";
		Query q = em.createQuery(qs);
		q.setParameter("nome", nome);
		try {
			return (Comodo) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public Comodo buscarComodoId(int id) {
		String qs = "select p from Comodo c where p.id = :id";
		Query q = em.createQuery(qs);
		q.setParameter("id", id);
		try {
			return (Comodo) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
