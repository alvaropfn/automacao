package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
<<<<<<< HEAD
import javax.faces.bean.SessionScoped;
=======
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import controllers.primitive.AbstractCrudMB;
import dao.DispositivoDAO;
import dominio.Comodo;
import dominio.Dispositivo;
<<<<<<< HEAD
import dominio.Permissao;
import dominio.Usuario;

@ManagedBean
@SessionScoped
=======

@ManagedBean
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
public class DispositivoMB extends AbstractCrudMB<Dispositivo> {

	public static final String FORM_PAGE = "/dispositivo/form.xhtml";
	public static final String LIST_PAGE = "/dispositivo/list.xhtml";
<<<<<<< HEAD
	
	
	private Dispositivo dispositivo;

	@Inject
	private DispositivoDAO dispositivoDao;
	
	private List<Dispositivo> listaDisp;
	
	public List<Dispositivo> getListaDisp() {
		return listaDisp;
	}

	public void setListaDisp(List<Dispositivo> listaDisp) {
		this.listaDisp = listaDisp;
	}

	public DispositivoMB() {
		dispositivo = new Dispositivo();
	}
	
	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	

	
	public void setDispositivo(Dispositivo dispositivo){
		this.dispositivo = dispositivo;
	}
=======

	@Inject
	private DispositivoDAO dispositivoDao;
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
<<<<<<< HEAD
		setListaDisp(dispositivoDao.listar());
	//	setListaDispositivos(dispositivoDao.listar());
=======
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
		return LIST_PAGE;
	}

	@Override
	public String cadastrar() {
<<<<<<< HEAD
		if(dispositivo.getId() == 0){
			dispositivoDao.salvar(dispositivo);
		}
		else {
			dispositivoDao.atualizar(dispositivo);
		}
		/*Dispositivo d = dispositivoDao.buscarDispositivoNome(dispositivo.getNome());
		if(d == null){
			dispositivoDao.salvar(d);
		}
		else {
			dispositivoDao.atualizar(d);
		}*/
		return LIST_PAGE;
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
	}

	@Override
	public String cancelar() {
<<<<<<< HEAD
		resetMB();
		return abrirListagem();
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
	}

	@Override
	public String deletar(int id) {
<<<<<<< HEAD
		Dispositivo d = dispositivoDao.buscarDispositivoId(id);
		if (d != null){
			dispositivoDao.remover(d);	
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
		if (id != 0){
			Dispositivo d = dispositivoDao.buscarDispositivoId(id);
			if (d!=null){
				dispositivoDao.atualizar(d);
			}
			return LIST_PAGE;	
		}
		else {
			return LIST_PAGE;
		}
		
/*		Dispositivo d = dispositivoDao.buscarDispositivoId(id);
		if(d != null){
			dispositivoDao.atualizar(d);
		}
		
		return LIST_PAGE;
*/	}
=======
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336

	@Override
	public boolean validaObj() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetMB() {
		setObj(new Dispositivo());
<<<<<<< HEAD
		
=======
>>>>>>> 11250ab3e15d852949690d44a2d101dd9ac8a336
	}

	public List<SelectItem> selectItems() {
		List<SelectItem> itemsDispositivo = new ArrayList<>();
		List<Dispositivo> dispositivos = dispositivoDao.listar();

		dispositivos.forEach(dispositivo -> itemsDispositivo.add(new SelectItem(dispositivo, dispositivo.getNome())));

		return itemsDispositivo;
	}

}
