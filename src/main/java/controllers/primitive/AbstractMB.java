package controllers.primitive;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public abstract class AbstractMB<T>{

	private T obj;
	
	private String viewName;

	public abstract void resetMB();
	
	public abstract boolean validaObj();

	private void addGenericMessage(String index,String mensagem,Severity severity){
		FacesMessage msg = new FacesMessage(mensagem);
		msg.setSeverity(severity);
		FacesContext.getCurrentInstance().addMessage(index, msg);
	}
	
	public void addMensagem(String mensagem){
		addGenericMessage("",mensagem,FacesMessage.SEVERITY_INFO);
	} 
	
	public void addMensagemAlerta(String mensagem){
		addGenericMessage("",mensagem,FacesMessage.SEVERITY_WARN);
	}
		
	public void addMensagemErro(String mensagem){
		addGenericMessage("",mensagem,FacesMessage.SEVERITY_ERROR);
	}	

	public String redirect(String url){
		return url+"?faces-redirect=true";
	}
	
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}	
	
	
}
