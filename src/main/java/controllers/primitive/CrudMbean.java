package controllers.primitive;

public interface CrudMbean {
	
	public abstract String abrirCadastro();
	public abstract String abrirEditar(int id);
	public abstract String abrirListagem();
	public abstract String cadastrar();
	public abstract String cancelar();
	public abstract String deletar(int id);
	public abstract String editar(int id);

}
