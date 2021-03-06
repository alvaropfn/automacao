package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import controllers.primitive.AbstractCrudMB;
import dao.ComodoDAO;
import dao.DispositivoDAO;
import dominio.Comodo;

@ManagedBean
@SessionScoped
public class ComodoMB extends AbstractCrudMB<Comodo> {
	
	public static final String FORM_PAGE = "/comodo/form.xhtml";
	public static final String LIST_PAGE = "/comodo/list.xhtml";	
	
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
	
	public List<Comodo> getListaComodos(){
		setListaComodos(comodoDAO.listar());
		return listaComodos;
	}

	public void setListaComodos(List<Comodo> listaComodos){
		this.listaComodos = listaComodos;
	}
	
	@Override
	public String cadastrar() {
		if (comodo.getId() == 0){
			comodoDAO.salvar(comodo);
		}
		else {
			comodoDAO.atualizar(comodo);
		}
		resetMB();
		return LIST_PAGE;
	}

	public List<SelectItem> selectItems(){
		List<SelectItem> itemsComodo = new ArrayList<>();
		List<Comodo> comodos =	comodoDAO.listar();
		
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
		setListaComodos(comodoDAO.listar());
		return LIST_PAGE;
	}

	@Override
	public String cancelar() {
		resetMB();
		return null;
	}

<<<<<<< HEAD
	@Override
	public String deletar(int id) {
		Comodo c = comodoDAO.buscarComodoId(id);
		if(c!=null){
			comodoDAO.remover(c);
		}
		
		return LIST_PAGE;
	}

	///CADASTRAR J� FAZ EDI��O, MAS ARRUMEI O M�TODO
	@Override
	public String editar(int id) {
		if (id != 0){
			Comodo c = comodoDAO.buscarComodoId(id);
			if (c!=null){
				comodoDAO.atualizar(c);
			}
			return LIST_PAGE;	
		}
		else {
			return LIST_PAGE;
		}
=======
	public List<SelectItem> selectItems(){
		List<SelectItem> itemsComodo = new ArrayList<>();
		List<Comodo> comodos =	comodoDAO.listar();
		
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
		return LIST_PAGE;
	}

	@Override
	public String cancelar() {
		resetMB();
		return null;
	}

	@Override
	public String deletar(int id) {
		resetMB();
		return null;
	}

	@Override
	public String editar(int id) {
		resetMB();
		return null;
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
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
