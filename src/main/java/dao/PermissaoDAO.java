package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Permissao;

@Stateless
public class PermissaoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Permissao p)
	{
		em.persist(p);
	}
	
	public void atualizar(Permissao p)
	{
		em.merge(p);
	}
	
	public void remover(Permissao p)
	{
		p = em.find(Permissao.class, p.getId());
		em.remove(p);
	}
	
	@SuppressWarnings("uncheked")
	public List<Permissao> listar()
	{
		String qs = "SELECT p FROM Permissao P";
		Query q = em.createQuery(qs);
		return (List<Permissao>) q.getResultList();
	}
	
	public Permissao buscarPermissaoNome(String nome){
		String qs = "SELECT p FROM Permissao P WHERE P.nome = :nome";
		Query q = em.createQuery(qs);
		q.setParameter("nome", nome);
		try{
			return (Permissao) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public Permissao buscarPermissaoId(int id){
		String qs = "SELECT p FROM Permissao P WHERE p.id = :id";
		Query q = em.createQuery(qs);
		q.setParameter("id", id);
		try{
			return (Permissao) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	

}
