package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Dispositivo;

@Stateless
public class DispositivoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Dispositivo c) {
		em.persist(c);
	}
	
	public void atualizar(Dispositivo c) {
		em.merge(c);
	}
	
	public void remover(Dispositivo c) {
		c = em.find(Dispositivo.class, c.getId());
		em.remove(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dispositivo> listar() {
		String qs = "select p from Dispositivo p";
		Query q = em.createQuery(qs);
		return (List<Dispositivo>) q.getResultList();
	}
	
	public Dispositivo buscarDispositivoNome(String nome) {
		String qs = "select p from Dispositivo p where p.nome = :nome";
		Query q = em.createQuery(qs);
		q.setParameter("nome", nome);
		try {
			return (Dispositivo) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Dispositivo buscarDispositivoId(int id) {
		String qs = "select p from Dispositivo p where p.id = :id";
		Query q = em.createQuery(qs);
		q.setParameter("id", id);
		try {
			return (Dispositivo) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
