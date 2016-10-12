package dominio.dispositivos;

import javax.persistence.ManyToOne;

import dominio.residencia.Comodo;

public class Dispositivo {
	
	private int id;
	
	private String nome;

	@ManyToOne
	private Comodo comodo;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Comodo getComodo() {
		return comodo;
	}

	public void setComodo(Comodo comodo) {
		this.comodo = comodo;
	}
	
}
