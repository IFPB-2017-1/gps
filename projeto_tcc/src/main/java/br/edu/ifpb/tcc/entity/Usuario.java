package br.edu.ifpb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO")
public class Usuario{
	@Id
	@Column(name="NU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="DS_NOME")
	private String nome;
	
	@Column(name="DS_ENDERECO")
	private String endereco;
	
	@Column(name="DS_FONE")
	private String telefone;
	
	@Column(name="DS_EMAIL")
	private String email;
	
	@Column(name="DS_SENHA")
	private String senha;
	
	@Column(name="DS_PERFIL")
	private String perfil;
	
	@Column(name="DS_MATRICULA")
	private int matricula;
	
	public Usuario(){}
	public Usuario(String nome, String endereco, String fone, String email, String senha, String perfil, int matricula){
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = fone;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		this.matricula = matricula;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", email="
				+ email + ", senha=" + senha + ", perfil=" + perfil + ", matricula=" + matricula + "]";
	}
}
