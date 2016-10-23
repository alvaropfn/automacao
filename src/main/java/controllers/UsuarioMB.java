package controllers;

import javax.inject.Inject;

import controllers.primitive.AbstractMB;
import dao.UsuarioDAO;
import dominio.Usuario;

public class UsuarioMB extends AbstractMB<Usuario> {
	
	@Inject
	private UsuarioDAO usuarioDao;
	
	public UsuarioMB() {
		resetMB();
	}		
	
	@Override
	public void resetMB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validaObj() {			
		
		return false;		
	}	
	
	/*
	 * Métodos que retornam view
	 * 
	 * Implementam a interface CrudMBean
	 */

	@Override
	public String cadastrar() {
		
		if(validaObj()){
			
		}
	
		return null;
	}

	@Override
	public String listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}



}
