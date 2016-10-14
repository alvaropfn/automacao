package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;


import dao.ComodoDAO;
import dominio.Comodo;

@ManagedBean
@SessionScoped
public class ComodoMB {
	
	private Comodo comodo;
	
	@Inject
	private ComodoDAO comodoDAO;
	
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
		setListaComodos(comodoDAO.listar());
		return listaComodos;
	}

	public void setListaComodos(List<Comodo> listaComodos){
		this.listaComodos = listaComodos;
	}
	
	public String cadastrar() {
		Comodo c = comodoDAO.buscarComodoNome(comodo.getNome());
		if (c == null){
			comodoDAO.salvar(comodo);
		}
		else {
			comodoDAO.atualizar(comodo);
		}
		return "urlPagina";
	}

}
