package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import dao.GrupoDAO;
import dominio.Grupo;

@ManagedBean
@SessionScoped
public class GrupoMB {
	
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
		setListaGrupos(grupoDAO.listar());
		return listaGrupos;
	}

	public void setListaGrupos(List<Grupo> listaGrupos){
		this.listaGrupos = listaGrupos;
	}
	
	public void cadastrar() {
		
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
		//return "urlPagina";
	}

}
