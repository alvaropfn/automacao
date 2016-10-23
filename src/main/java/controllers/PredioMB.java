package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import controllers.primitive.AbstractCrudMB;
import dao.PredioDAO;
import dominio.Predio;

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
	
	
}
