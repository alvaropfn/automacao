package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import controllers.primitive.AbstractCrudMB;
import dao.GrupoDAO;
import dominio.Grupo;
import dominio.Usuario;

@ManagedBean
@SessionScoped
public class GrupoMB extends AbstractCrudMB<Grupo>{	
	
	public static final String FORM_PAGE = "/grupo/form.xhtml";
	public static final String LIST_PAGE = "/grupo/list.xhtml";
	
	private Grupo grupo;
	
	@Inject
	private GrupoDAO grupoDAO;
	
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
		setList(grupoDAO.listar());
		return LIST_PAGE;
	}

	@Override
	public String cadastrar() {	
		Grupo g = grupoDAO.buscarGrupoNome(grupo.getNome());
		
		if (g == null){
			System.out.println("g é nulo");
			grupoDAO.salvar(grupo);
			System.out.println("g deveria ser salvo");
		}
		else {
			//System.out.println("g não é nulo");
			grupoDAO.atualizar(grupo);
		}
		grupo = new Grupo();
		
		// TODO Auto-generated method stub
		return abrirListagem();
	}

	@Override
	public String cancelar() {
		resetMB();
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
