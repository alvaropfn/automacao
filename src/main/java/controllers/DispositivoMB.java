package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import controllers.primitive.AbstractCrudMB;
import dominio.Dispositivo;
import service.DispositivoService;

@ManagedBean
@RequestScoped
public class DispositivoMB extends AbstractCrudMB<Dispositivo> {

	public static final String FORM_PAGE = "/dispositivo/form.xhtml";
	public static final String LIST_PAGE = "/dispositivo/list.xhtml";

	private Dispositivo dispositivo;

	@EJB
	private DispositivoService service;

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

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
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
		setListaDisp(service.listar());
		// setListaDispositivos(dispositivoDao.listar());
		return LIST_PAGE;
	}

	@Override
	public String cadastrar() {
		service.salvar(dispositivo);
		/*
		 * Dispositivo d =
		 * dispositivoDao.buscarDispositivoNome(dispositivo.getNome()); if(d ==
		 * null){ dispositivoDao.salvar(d); } else {
		 * dispositivoDao.atualizar(d); }
		 */
		return LIST_PAGE;
	}

	@Override
	public String cancelar() {
		resetMB();
		return abrirListagem();
	}

	@Override
	public String deletar(int id) {
		service.deletar(id);
		return LIST_PAGE;
	}

	@Override
	public String editar(int id) {
		service.salvar(dispositivo);
		return abrirListagem();
	}

	@Override
	public boolean validaObj() {	
		return true;
	}

	@Override
	public void resetMB() {
		setObj(new Dispositivo());

	}

	public List<SelectItem> selectItems() {
		List<SelectItem> itemsDispositivo = new ArrayList<>();
		List<Dispositivo> dispositivos = service.listar();

		dispositivos.forEach(dispositivo -> itemsDispositivo.add(new SelectItem(dispositivo, dispositivo.getNome())));

		return itemsDispositivo;
	}

}
