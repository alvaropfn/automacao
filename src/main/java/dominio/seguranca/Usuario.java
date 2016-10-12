package dominio.seguranca;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="Usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private String nomeusuario;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Date dataCadastro;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="usuario_grupo",
		joinColumns={@JoinColumn(name="usuario_id")},
		inverseJoinColumns={@JoinColumn(name="grupo_id")})
	private List<Grupo> grupos;

	public Usuario() {
		
	}
	
	public Usuario(String nomeusuario, String senha, String nome, Date dataCadastro) {
		this.nomeusuario = nomeusuario;
		this.senha = senha;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

}
