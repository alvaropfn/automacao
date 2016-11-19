package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dao.PredioDAO;

@Entity
@Table(name="Predios")
public class Predio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String endereco;
	
	@OneToMany(mappedBy="predio")
	private List<Comodo> comodos;
		
	public Predio(){
		
	}
	
	public Predio(int id, String nome, String endereco, List<Comodo> comodos) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.comodos = comodos;
	}
	
	

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Comodo> getComodos() {
		return comodos;
	}

	public void setComodos(List<Comodo> comodos) {
		this.comodos = comodos;
	}

}
