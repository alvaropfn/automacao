package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ComodoDAO;
import dominio.Comodo;

@Stateless
public class ComodoService{

	@Inject
	private ComodoDAO comodoDao;

	public void salvar(Comodo comodo) {
		if (comodo.getId() == 0) {
			comodoDao.salvar(comodo);
		} else {
			comodoDao.atualizar(comodo);
		}
	}

	public void deletar(Comodo comodo) {
		Comodo c = comodoDao.buscarComodoId(comodo.getId());
		if (c != null) {
			comodoDao.remover(c);
		}
	}

	public List<Comodo> listar() {
		return comodoDao.listar();
	}

	public void deletar(int id) {
		Comodo c = comodoDao.buscarComodoId(id);
		if (c != null) {
			comodoDao.remover(c);
		}
	}

	public Comodo buscaPorId(int id) {
		return comodoDao.buscarComodoId(id);
	}

}
