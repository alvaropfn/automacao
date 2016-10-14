package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Usuario;

@Stateless
public class UsuarioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Usuario u) {
		//System.out.println("Salvando G");
		em.persist(u);
		//System.out.println("G salvo");
	}
	
	public void atualizar(Usuario u) {
		em.merge(u);
	}
	
	public void remover(Usuario u) {
		u = em.find(Usuario.class, u.getId());
		em.remove(u);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		String qs = "select u from Usuario u";
		Query q = em.createQuery(qs);
		return (List<Usuario>) q.getResultList();
	}
	
	public Usuario buscarUsuarioLogin(String login) {
		String qs = "select u from Usuario u where u.login = :login";
		Query q = em.createQuery(qs);
		q.setParameter("nome", login);
		try {
			return (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
}
