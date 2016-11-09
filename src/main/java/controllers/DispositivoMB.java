package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import controllers.primitive.AbstractCrudMB;
import dao.DispositivoDAO;
import dominio.Comodo;
import dominio.Dispositivo;

@ManagedBean
public class DispositivoMB extends AbstractCrudMB<Dispositivo> {

	public static final String FORM_PAGE = "/dispositivo/form.xhtml";
	public static final String LIST_PAGE = "/dispositivo/list.xhtml";
	
	
	private Dispositivo dispositivo;

	@Inject
	private DispositivoDAO dispositivoDao;

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
		Dispositivo d = dispositivoDao.buscarDispositivoNome(dispositivo.getNome());
		if(d == null){
			dispositivoDao.salvar(d);
		}
		else {
			dispositivoDao.atualizar(d);
		}
		return LIST_PAGE;
	}

	@Override
	public String cancelar() {
		resetMB();
		return null;
	}

	@Override
	public String deletar(int id) {
		Dispositivo d = dispositivoDao.buscarDispositivoId(id);
		if (d != null){
			dispositivoDao.remover(d);	
		}
		return LIST_PAGE;
	}

	@Override
	public String editar(int id) {
		Dispositivo d = dispositivoDao.buscarDispositivoId(id);
		if(d != null){
			dispositivoDao.atualizar(d);
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
		setObj(new Dispositivo());
	}

	public List<SelectItem> selectItems() {
		List<SelectItem> itemsDispositivo = new ArrayList<>();
		List<Dispositivo> dispositivos = dispositivoDao.listar();

		dispositivos.forEach(dispositivo -> itemsDispositivo.add(new SelectItem(dispositivo, dispositivo.getNome())));

		return itemsDispositivo;
	}

}
