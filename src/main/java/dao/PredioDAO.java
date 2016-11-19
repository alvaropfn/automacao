package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.*;;

@Stateless
public class PredioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Predio p) {
		em.persist(p);
	}
	
	public void atualizar(Predio p) {
		em.merge(p);
	}
	
	public void remover(Predio p) {
		p = em.find(Predio.class, p.getId());
		em.remove(p);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Predio> findAll() {
		String qs = "select p from Predio p";
		Query q = em.createQuery(qs);
		return (List<Predio>) q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Predio> listar() {
		String qs = "select p from Predio p";
		Query q = em.createQuery(qs);
		return (List<Predio>) q.getResultList();
	}
	
	public Predio buscarPredioNome(String nome) {
		String qs = "select p from Predio p where p.nome = :nome";
		Query q = em.createQuery(qs);
		q.setParameter("nome", nome);
		try {
			return (Predio) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Predio buscarPredioId(int id) {
		String qs = "select p from Predio p where p.id = :id";
		Query q = em.createQuery(qs);
		q.setParameter("id", id);
		try {
			return (Predio) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
