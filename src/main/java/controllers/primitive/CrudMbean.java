package controllers.primitive;

public interface CrudMbean {
	
	public abstract String cadastrar();
	public abstract String listar();
	public abstract String editar(int id);
	public abstract String deletar(int id);

}
