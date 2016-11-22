package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
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

@ManagedBean
@SessionScoped
public class PredioMB extends AbstractCrudMB<Predio>{

	public static final String FORM_PAGE = "/predio/form.xhtml";
	public static final String LIST_PAGE = "/predio/list.xhtml";	
	
	private Predio predio;
	
	@Inject
	private PredioDAO predioDAO;
	
	private List<Predio> listaPredios;
	
	
	public PredioMB() {
		predio = new Predio();
		listaPredios = new ArrayList<Predio>(); 
	}
	
	public List<SelectItem> selectItems(){
		List<SelectItem> itemsPredio = new ArrayList<>();
		List<Predio> predios = predioDAO.findAll();
		
		predios.forEach(predio -> itemsPredio.add(new SelectItem(predio,predio.getNome())));
		
		return itemsPredio;
	}
	
	@Override
	public String cadastrar() {
		
		if(predio.getId() == 0){
			predioDAO.salvar(predio);
		}
		else {
			predioDAO.atualizar(predio);
		}
		/*Predio p = predioDAO.buscarPredioNome(predio.getNome());
		if (p == null){
			predioDAO.salvar(predio);
		}
		else {
			predioDAO.atualizar(predio);
		}*/
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
		setListaPredios(predioDAO.listar());
		return LIST_PAGE;
	}

	@Override
	public String cancelar() {
		resetMB();
		return LIST_PAGE;
	}

	@Override
	public String deletar(int id) {
		Predio p = predioDAO.buscarPredioId(id);
		if(p !=null){
			predioDAO.remover(p);
		}
		return LIST_PAGE;
	}

	@Override
	public String editar(int id) {
		if(id != 0) {
			predioDAO.atualizar(predio);
		}
		return abrirListagem();
	}

	@Override
	public boolean validaObj() {
		// TODO Auto-generated method stub
		return false;
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
	
<<<<<<< HEAD
=======
	@Override
	public String cadastrar() {
		Predio p = predioDAO.buscarPredioNome(predio.getNome());
		if (p == null){
			predioDAO.salvar(predio);
		}
		else {
			predioDAO.atualizar(predio);
		}
		return "urlPagina";
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

	@Override
	public void resetMB() {
		// TODO Auto-generated method stub
		
	}
	
	
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
}
