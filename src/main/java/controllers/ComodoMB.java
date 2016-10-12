package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import dao.ComodoDAO;
import dominio.residencia.Comodo;

@ManagedBean
@SessionScoped
public class ComodoMB {
	
private Comodo comodo;
	
	@Inject
	private ComodoDAO ComodoDAO;
	
	private List<Comodo> listaComodos;
	
	
	public ComodoMB() {
		comodo = new Comodo();
		listaComodos = new ArrayList<Comodo>(); 
	}
	
	public Comodo getComodo() {
		return comodo;
	}
	
	public void setComodo(Comodo comodo){
		this.comodo = comodo;
	}
	
	public List<Comodo> getListaComodo(){
		setListaComodos(ComodoDAO.listar());
		return listaComodos;
	}

	public void setListaComodos(List<Comodo> listaComodos){
		this.listaComodos = listaComodos;
	}
	
	public String cadastrar() {
		Comodo c = ComodoDAO.buscarComodoNome(comodo.getNome());
		if (c == null){
			ComodoDAO.salvar(c);
		}
		else {
			ComodoDAO.atualizar(c);
		}
		return "urlPagina";
	}

}
