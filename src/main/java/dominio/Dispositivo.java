package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Dispositivos")
public class Dispositivo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDispositivo;
	
	private String nome;

	@ManyToOne
	private Comodo comodo;
	
	public int getId() {
		return idDispositivo;
	}

	public void setId(int id) {
		this.idDispositivo = id;
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
