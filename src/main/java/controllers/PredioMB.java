package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import controllers.primitive.AbstractCrudMB;
import dao.PredioDAO;
import dominio.Comodo;
import dominio.Dispositivo;
import dominio.Permissao;
import dominio.Predio;
import dominio.Usuario;
import service.PredioService;

@ManagedBean
@RequestScoped
public class PredioMB extends AbstractCrudMB<Predio>{

	public static final String FORM_PAGE = "/predio/form.xhtml";
	public static final String LIST_PAGE = "/predio/list.xhtml";	
	
	private Predio predio;
	
	@EJB
	private PredioService service;
	
	private List<Predio> listaPredios;
	
	
	public PredioMB() {
		predio = new Predio();
		listaPredios = new ArrayList<Predio>(); 
	}
	
	public List<SelectItem> selectItems(){
		List<SelectItem> itemsPredio = new ArrayList<>();
		List<Predio> predios = service.listar();
		
		predios.forEach(predio -> itemsPredio.add(new SelectItem(predio,predio.getNome())));
		
		return itemsPredio;
	}
	
	@Override
	public String cadastrar() {		
		service.salvar(predio);
		return abrirListagem();
	}
	
	@Override
	public String abrirCadastro() {
		resetMB();
		return FORM_PAGE;
	}

	@Override
	public String abrirEditar(int id) {
		resetMB();
		return LIST_PAGE;
	}

	@Override
	public String abrirListagem() {
		resetMB();
		setListaPredios(service.listar());
		return LIST_PAGE;
	}

	@Override
	public String cancelar() {
		resetMB();
		return LIST_PAGE;
	}

	@Override
	public String deletar(int id) {
		
		return LIST_PAGE;
	}

	@Override
	public String editar(int id) {
		service.salvar(predio);
		return abrirListagem();
	}

	@Override
	public boolean validaObj() {		
		return true;
	}

	@Override
	public void resetMB() {
		setObj(new Predio());
		getObj().setComodos(new ArrayList<Comodo>());
		
	}	
	
	public Predio getPredio() {
		return predio;
	}
	
	public void setPredio(Predio predio){
		this.predio = predio;
	}
	
	public List<Predio> getListaPredios(){
		return listaPredios;
	}

	public void setListaPredios(List<Predio> listaPredios){
		this.listaPredios = listaPredios;
	}
	
}
