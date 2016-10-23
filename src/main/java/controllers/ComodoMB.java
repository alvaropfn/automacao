package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import controllers.primitive.AbstractCrudMB;
import dao.ComodoDAO;
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
	
	public List<Comodo> getListaComodo(){
		setListaComodos(comodoDAO.listar());
		return listaComodos;
	}

	public void setListaComodos(List<Comodo> listaComodos){
		this.listaComodos = listaComodos;
	}
	
	@Override
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

	public List<SelectItem> selectItems(){
		List<SelectItem> itemsComodo = new ArrayList<>();
		
		comodoDAO.listar().forEach(comodo -> itemsComodo.add(new SelectItem(comodo,comodo.getNome())));
		
		return itemsComodo;
	}

	@Override
	public String abrirCadastro() {
		// TODO Auto-generated method stub
		return FORM_PAGE;
	}

	@Override
	public String abrirEditar(int id) {
		// TODO Auto-generated method stub
		return LIST_PAGE;
	}

	@Override
	public String abrirListagem() {
		// TODO Auto-generated method stub
		return LIST_PAGE;
	}

	@Override
	public String cancelar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validaObj() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
