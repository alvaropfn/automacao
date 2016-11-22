package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
<<<<<<< HEAD
import javax.inject.Inject;

import controllers.primitive.AbstractCrudMB;
import dao.PermissaoDAO;
=======

import controllers.primitive.AbstractCrudMB;
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
import dominio.Dispositivo;
import dominio.Permissao;
import dominio.Usuario;

@ManagedBean
public class PermissaoMB extends AbstractCrudMB<Permissao> {

	public static final String FORM_PAGE = "/permissao/form.xhtml";
	public static final String LIST_PAGE = "/permissao/list.xhtml";

	private List<Dispositivo> dispositivosSelecionados;

<<<<<<< HEAD
	private Permissao permissao;
	
	@Inject
	private PermissaoDAO permissaoDao;
	
	
=======
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
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
<<<<<<< HEAD
		
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
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
	}

	@Override
	public String cancelar() {
<<<<<<< HEAD
		resetMB();
=======
		// TODO Auto-generated method stub
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
		return null;
	}

	@Override
	public String deletar(int id) {
<<<<<<< HEAD
		Permissao p = permissaoDao.buscarPermissaoId(id);
		if(p!=null){
			permissaoDao.remover(p);
		}
		return LIST_PAGE;
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
	}

	@Override
	public String editar(int id) {
<<<<<<< HEAD
		Permissao p = permissaoDao.buscarPermissaoId(id);
		if(p!=null){
			permissaoDao.atualizar(p);
		}
		return LIST_PAGE;
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
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
