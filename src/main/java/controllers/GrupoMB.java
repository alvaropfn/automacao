package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import dao.GrupoDAO;
import dominio.seguranca.*;

@ManagedBean
@SessionScoped
public class GrupoMB {
	
	private Grupo grupo;
	
	@Inject
	private GrupoDAO GrupoDAO;
	
	private List<Grupo> listaGrupos;
	
	
	public GrupoMB() {
		grupo = new Grupo();
		listaGrupos = new ArrayList<Grupo>(); 
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo comodo){
		this.grupo = comodo;
	}
	
	public List<Grupo> getListaGrupo(){
		setListaGrupos(GrupoDAO.listar());
		return listaGrupos;
	}

	public void setListaGrupos(List<Grupo> listaGrupos){
		this.listaGrupos = listaGrupos;
	}
	
	public String cadastrar() {
		Grupo c = GrupoDAO.buscarGrupoNome(grupo.getNome());
		if (c == null){
			GrupoDAO.salvar(c);
		}
		else {
			GrupoDAO.atualizar(c);
		}
		return "urlPagina";
	}

}
