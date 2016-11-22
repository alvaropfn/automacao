package dao.interfaces;

import java.util.List;

import dao.primitive.GenericDao;
import dominio.Usuario;

public interface UsuarioDao<Usuario,Integer> extends GenericDao<Usuario, Integer>{

	Usuario buscarUsuarioLogin(String login);
}
