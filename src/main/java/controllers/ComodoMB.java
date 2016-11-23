package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import controllers.primitive.AbstractCrudMB;
import dominio.Comodo;
import dominio.Predio;
import service.ComodoService;

@ManagedBean
@RequestScoped
public class ComodoMB extends AbstractCrudMB<Comodo> {
	
	public static final String FORM_PAGE = "/comodo/form.xhtml";
	public static final String LIST_PAGE = "/comodo/list.xhtml";	
	
	private Comodo comodo;
	
	@EJB
	private ComodoService service;
	
	
	private List<Comodo> listaComodos;
	
	
	public ComodoMB() {
		comodo = new Comodo();
		comodo.setPredio(new Predio());
		listaComodos = new ArrayList<Comodo>(); 
	}
	
	public Comodo getComodo() {
		return comodo;
	}
	
	public void setComodo(Comodo comodo){
		this.comodo = comodo;
	}
	
	public List<Comodo> getListaComodos(){
		setListaComodos(service.listar());
		return listaComodos;
	}

	public void setListaComodos(List<Comodo> listaComodos){
		this.listaComodos = listaComodos;
	}
	
	@Override
	public String cadastrar() {
		service.salvar(comodo);
		resetMB();
		return LIST_PAGE;
	}

	public List<SelectItem> selectItems(){
		List<SelectItem> itemsComodo = new ArrayList<>();
		List<Comodo> comodos =	service.listar();
		
		comodos.forEach(comodo -> itemsComodo.add(new SelectItem(comodo,comodo.getNome())));
		
		return itemsComodo;
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
		setListaComodos(service.listar());
		return LIST_PAGE;
	}

	@Override
	public String cancelar() {
		resetMB();
		return null;
	}

	@Override
	public String deletar(int id) {
		service.deletar(id);
		return LIST_PAGE;
	}

	///CADASTRAR JÁ FAZ EDIÇÃO, MAS ARRUMEI O MÉTODO
	@Override
	public String editar(int id) {		
		service.salvar(service.buscaPorId(id));		
		return LIST_PAGE;		
	}

	@Override
	public boolean validaObj() {
		resetMB();
		return false;
	}

	@Override
	public void resetMB() {
		setObj(new Comodo());
		setComodo(new Comodo());
		setListaComodos(new ArrayList<>());		
	}
	
}
