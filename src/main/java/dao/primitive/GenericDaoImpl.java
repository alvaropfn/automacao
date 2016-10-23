package dao.primitive;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDaoImpl<E, K> implements GenericDao<E, K>{

	@PersistenceContext
	private EntityManager em;	

	@Override
	public void add(E entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(E entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(E entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(E entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E find(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> findAll() {
		// TODO Auto-generated method stub
		return null;
	}	

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
