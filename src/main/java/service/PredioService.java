package service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.PredioDAO;
import dominio.Predio;

@Stateless
public class PredioService{
	
	@Inject
	private PredioDAO predioDAO;	
	
	public void salvar(Predio predio) {
		if(predio.getId() == 0){
			predioDAO.salvar(predio);
		}
		else {
			predioDAO.atualizar(predio);
		}		
	}

	public void deletar(Predio p) {		
		if(p !=null){
			predioDAO.remover(p);
		}		
	}

	public List<Predio> listar() {	
		
		return predioDAO.findAll();
	}
	
	public void deletar(int id) {
		deletar(buscaPorId(id));		
	}
	
	public Predio buscaPorId(int id) {
		Predio p = predioDAO.buscarPredioId(id);
		return p;
	}

}
