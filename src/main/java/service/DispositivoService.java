package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.DispositivoDAO;
import dominio.Dispositivo;

@Stateless
public class DispositivoService{

	@Inject
	private DispositivoDAO dispositivoDao;
	
	
	public void salvar(Dispositivo dispositivo) {
		if(dispositivo.getId() == 0){
			dispositivoDao.salvar(dispositivo);
		}
		else {
			dispositivoDao.atualizar(dispositivo);
		}		
	}

	
	public void deletar(Dispositivo dispositivo) {
		if (dispositivo != null){
			dispositivoDao.remover(dispositivo);	
		}		
	}

	
	public List<Dispositivo> listar() {
		return dispositivoDao.listar();
	}

	
	public void deletar(int id) {
		dispositivoDao.remover(buscaPorId(id));		
	}

	
	public Dispositivo buscaPorId(int id) {		
		return dispositivoDao.buscarDispositivoId(id);
	}

}
