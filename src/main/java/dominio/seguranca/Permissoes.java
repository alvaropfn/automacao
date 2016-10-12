package dominio.seguranca;

import javax.persistence.Entity;
import javax.persistence.Table;

import dominio.dispositivos.Dispositivo;

@Entity
@Table(name="Permissoes")
public class Permissoes {
	private int id;
	private Grupo grupo;
	private Dispositivo dispositivo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	
	
}
