package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import controllers.primitive.AbstractCrudMB;
import dao.UsuarioDaoImpl;
import dominio.Comodo;
import dominio.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioMB extends AbstractCrudMB<Usuario>{
	
	public static final String FORM_PAGE = "/usuario/form.xhtml";
	public static final String LIST_PAGE = "/usuario/list.xhtml";	

	private List<Usuario> usuarios = new ArrayList<>();
	
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
		resetMB();
		return null;
	}
	
	@Override
	public String abrirListagem() {		
		resetMB();
		setUsuarios(usuarioDao.findAll());
		return LIST_PAGE;
	}
	
	@Override
	public String cancelar() {		
		resetMB();
		
		return "";
	} 

	@Override
	public String cadastrar() {		
		getObj().setDataCadastro(new Date());
		if(validaObj()){
			
			usuarioDao.add(getObj());
		}
	
		return abrirListagem();
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
	
	public List<SelectItem> selectItems(){
		List<SelectItem> itemsUsuario = new ArrayList<>();
		List<Usuario> usuarios = usuarioDao.findAll();
		
		usuarios.forEach(usuario -> itemsUsuario.add(new SelectItem(usuario,usuario.getNome())));
		
		return itemsUsuario;
	}
	
	public UsuarioDaoImpl getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDaoImpl usuarioDao) {
		this.usuarioDao = usuarioDao;
	}	

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
		

}
