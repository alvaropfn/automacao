package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import controllers.primitive.AbstractCrudMB;
import dao.PermissaoDAO;
import dominio.Dispositivo;
import dominio.Permissao;
import dominio.Usuario;

@ManagedBean
public class PermissaoMB extends AbstractCrudMB<Permissao> {

	public static final String FORM_PAGE = "/permissao/form.xhtml";
	public static final String LIST_PAGE = "/permissao/list.xhtml";

	private List<Dispositivo> dispositivosSelecionados;

	private Permissao permissao;
	
	@Inject
	private PermissaoDAO permissaoDao;
	
	
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
		
		if(permissao.getId() == 0){
			permissaoDao.salvar(permissao);
		}
		else {
			permissaoDao.atualizar(permissao);
		}
		
		return abrirListagem();
		/*Permissao p = permissaoDao.buscarPermissaoNome(permissao.getNome());
		if (p == null){
			permissaoDao.salvar(p);
		}
		else {
			permissaoDao.atualizar(p);
		}
		return null;*/
	}

	@Override
	public String cancelar() {
		resetMB();
		return null;
	}

	@Override
	public String deletar(int id) {
		Permissao p = permissaoDao.buscarPermissaoId(id);
		if(p!=null){
			permissaoDao.remover(p);
		}
		return LIST_PAGE;
	}

	@Override
	public String editar(int id) {
		Permissao p = permissaoDao.buscarPermissaoId(id);
		if(p!=null){
			permissaoDao.atualizar(p);
		}
		return LIST_PAGE;
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
