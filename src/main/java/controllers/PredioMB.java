package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import dao.PredioDAO;
import dominio.residencia.*;

@ManagedBean
@SessionScoped
public class PredioMB {

	private Predio predio;
	
	@Inject
	private PredioDAO predioDAO;
	
	private List<Predio> listaPredios;
	
	
	public PredioMB() {
		predio = new Predio();
		listaPredios = new ArrayList<Predio>(); 
	}
	
	public Predio getPredio() {
		return predio;
	}
	
	public void setPredio(Predio predio){
		this.predio = predio;
	}
	
	public List<Predio> getListaPredio(){
		setListaPredios(predioDAO.listar());
		return listaPredios;
	}

	public void setListaPredios(List<Predio> listaPredios){
		this.listaPredios = listaPredios;
	}
	
	public String cadastrar() {
		Predio p = predioDAO.buscarPredioNome(predio.getNome());
		if (p == null){
			predioDAO.salvar(p);
		}
		else {
			predioDAO.atualizar(p);
		}
		return "urlPagina";
	}
	
	
}
