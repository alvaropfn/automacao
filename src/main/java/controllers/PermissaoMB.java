package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import controllers.primitive.AbstractCrudMB;
import dominio.Dispositivo;
import dominio.Permissao;
import dominio.Usuario;

@ManagedBean
public class PermissaoMB extends AbstractCrudMB<Permissao> {

	public static final String FORM_PAGE = "/permissao/form.xhtml";
	public static final String LIST_PAGE = "/permissao/list.xhtml";

	private List<Dispositivo> dispositivosSelecionados;

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

	@Override
	public void resetMB() {
		setObj(new Permissao());
		getObj().setUsuario(new Usuario());
		getObj().setDispositivos(new ArrayList<Dispositivo>());

	}

	public List<Dispositivo> getDispositivosSelecionados() {
		return dispositivosSelecionados;
	}

	public void setDispositivosSelecionados(List<Dispositivo> dispositivosSelecionados) {
		this.dispositivosSelecionados = dispositivosSelecionados;
	}

}
