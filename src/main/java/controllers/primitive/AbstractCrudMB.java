package controllers.primitive;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public abstract class AbstractCrudMB<T> extends AbstractMB<T> implements CrudMbean{

	private List<T> list;

	public AbstractCrudMB() {
		setViewName("");
	}
	
	@Override
	public void resetMB(){
		list = new ArrayList<>();
	}
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
