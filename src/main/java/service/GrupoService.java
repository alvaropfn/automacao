package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.GrupoDAO;
import dominio.Grupo;

@Stateless
public class GrupoService{

	@Inject
	private GrupoDAO grupoDAO;	
	
	public void salvar(Grupo grupo) {
		if(grupo.getId() == 0){
			grupoDAO.salvar(grupo);
		}
		else {
			grupoDAO.atualizar(grupo);
		}
		
	}
	
	public void deletar(Grupo g) {
		if (g != null){
			grupoDAO.remover(g);
		}		
	}
	
	public List<Grupo> listar() {	
		return grupoDAO.listar();
	}
	
	public void deletar(int id) {
		Grupo g = buscaPorId(id);
		deletar(g);
	}
	
	public Grupo buscaPorId(int id) {
		// TODO Auto-generated method stub
		return grupoDAO.buscarGrupoId(id);
	}

}
