package controllers;

import javax.faces.bean.ManagedBean;

import controllers.primitive.AbstractCrudMB;
import dominio.Permissao;

@ManagedBean
public class PermissaoMB extends AbstractCrudMB<Permissao>{

	public static final String FORM_PAGE = "/permissao/form.xhtml";
	public static final String LIST_PAGE = "/permissao/list.xhtml";	
	
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
	public String cadastrar() {
		// TODO Auto-generated method stub
		return null;
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
