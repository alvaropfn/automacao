package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.interfaces.UsuarioDao;
import dominio.Usuario;



@SuppressWarnings("unused")
@Stateless
public class UsuarioDaoImpl{
	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see dao.UsuarioDao#salvar(dominio.Usuario)
	 */

	public void add(Usuario u) {
		//System.out.println("Salvando G");
		em.persist(u);
		//System.out.println("G salvo");
	}
	
	/* (non-Javadoc)
	 * @see dao.UsuarioDao#atualizar(dominio.Usuario)
	 */
	
	public void update(Usuario u) {
		em.merge(u);
	}
	
	/* (non-Javadoc)
	 * @see dao.UsuarioDao#remover(dominio.Usuario)
	 */
	
	public void remove(Usuario u) {
		u = em.find(Usuario.class, u.getId());
		em.remove(u);
	}
	
	/* (non-Javadoc)
	 * @see dao.UsuarioDao#listar()
	 */

	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		String qs = "select u from Usuario u";
		Query q = em.createQuery(qs);
		return (List<Usuario>) q.getResultList();
	}
	
	/* (non-Javadoc)
	 * @see dao.UsuarioDao#buscarUsuarioLogin(java.lang.String)
	 */

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

	public void add(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public void saveOrUpdate(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public void remove(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public Object find(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
