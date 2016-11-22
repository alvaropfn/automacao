package controllers.primitive;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
import java.util.List;


public abstract class AbstractCrudMB<T> extends AbstractMB<T> implements CrudMbean{

	private List<T> list;

	public AbstractCrudMB() {
		setViewName("");
	}	
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
