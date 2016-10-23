package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import controllers.primitive.AbstractCrudMB;
import dao.UsuarioDaoImpl;
import dominio.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB extends AbstractCrudMB<Usuario>{
	
	public static final String FORM_PAGE = "/usuario/form.xhtml";
	public static final String LIST_PAGE = "/usuario/list.xhtml";	
	
	@Inject
	private UsuarioDaoImpl usuarioDao;
	
	public UsuarioMB() {
		super();
		resetMB();
	}		
	
	@Override
	public void resetMB() {		
		setObj(new Usuario());
	}

	@Override
	public boolean validaObj() {	
		
		return true;		
	}
	
	
	/*
	 * Métodos que retornam view
	 * 
	 * Implementam a interface CrudMBean
	 */
	
	@Override
	public String abrirCadastro() {	
		setViewName("Cadastrar Usuários");
		return FORM_PAGE;
	}
 
	@Override
	public String abrirEditar(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String abrirListagem() {
		// TODO Auto-generated method stub
		
		List<Usuario> list = new ArrayList<>();
		
		for(int i=0; i< 10; i++){
			Usuario usuario = new Usuario();
			usuario.setId(i+1);
			usuario.setNomeusuario("Usuario"+i);
			usuario.setDataCadastro(new Date());
			list.add(usuario);
		}
		
		setList(list);
		getList();
		
		return redirect(LIST_PAGE);
	}
	
	@Override
	public String cancelar() {		
		resetMB();
		
		return "";
	} 

	@Override
	public String cadastrar() {		
		if(validaObj()){
			usuarioDao.add(getObj());
		}
	
		return "";
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
	
	public UsuarioDaoImpl getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDaoImpl usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
		

}
