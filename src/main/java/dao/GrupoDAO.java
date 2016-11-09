package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Grupo;


@Stateless
public class GrupoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Grupo g) {
		//System.out.println("Salvando G");
		em.persist(g);
		//System.out.println("G salvo");
	}
	
	public void atualizar(Grupo g) {
		em.merge(g);
	}
	
	public void remover(Grupo g) {
		g = em.find(Grupo.class, g.getId());
		em.remove(g);
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> listar() {
		String qs = "select g from Grupo g";
		Query q = em.createQuery(qs);
		return (List<Grupo>) q.getResultList();
	}
	
	public Grupo buscarGrupoNome(String nome) {
		String qs = "select g from Grupo g where g.nome = :nome";
		Query q = em.createQuery(qs);
		q.setParameter("nome", nome);
		try {
			return (Grupo) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Grupo buscarGrupoId(int id) {
		String qs = "select g from Grupo g where g.Id = :id";
		Query q = em.createQuery(qs);
		q.setParameter("id", id);
		try {
			return (Grupo) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
