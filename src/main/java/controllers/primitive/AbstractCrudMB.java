package controllers.primitive;

import java.util.ArrayList;
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
