package service;

import java.util.List;

public interface CrudService<T> {
	public abstract void salvar(T t);
	public abstract void deletar(T t);	
	public void deletar(int id);	
	public T buscaPorId(int id);
	public abstract List<T> listar();
}
