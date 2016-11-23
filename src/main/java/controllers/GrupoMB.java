package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import controllers.primitive.AbstractCrudMB;
import dao.GrupoDAO;
import dominio.Dispositivo;
import dominio.Grupo;
import dominio.Permissao;
import dominio.Usuario;
import service.GrupoService;

@ManagedBean
@SessionScoped
public class GrupoMB extends AbstractCrudMB<Grupo>{	
	
	public static final String FORM_PAGE = "/grupo/form.xhtml";
	public static final String LIST_PAGE = "/grupo/list.xhtml";
	
	private Grupo grupo;
	
	@EJB
	private GrupoService service;
	
	private List<Grupo> listaGrupos;
	
	
	public GrupoMB() {
		grupo = new Grupo();
		listaGrupos = new ArrayList<Grupo>(); 
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo){
		this.grupo = grupo;
	}
	
	public List<Grupo> getListaGrupo(){		
		return listaGrupos;
	}

	public void setListaGrupos(List<Grupo> listaGrupos){
		this.listaGrupos = listaGrupos;
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
		setList(service.listar());
		return LIST_PAGE;
	}

	@Override
	public String cadastrar() {	
		service.salvar(grupo);
		return abrirListagem();
	}

	@Override
	public String cancelar() {
		resetMB();
		return null;
	}

	@Override
	public String deletar(int id) {
		service.deletar(id);
		return LIST_PAGE;
	}

	@Override
	public String editar(int id) {
		service.salvar(grupo);		
		return abrirListagem();
	}

	@Override
	public boolean validaObj() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetMB() {
		setObj(new Grupo());		
	}
	
	public List<SelectItem> selectItems() {
		List<SelectItem> itemsgrupos = new ArrayList<>();
		List<Grupo> grupos = service.listar();

		grupos.forEach(grupo -> itemsgrupos.add(new SelectItem(grupo, grupo.getNome())));

		return itemsgrupos;
	}

}
