package br.edu.ifpb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_DISCENTE")
public class Discente implements Serializable{
	@Id
	@Column(name="NU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name="ID_USUARIO")
	@OneToOne
	private Usuario usuario;
	
	@Column(name="DS_CURSO")
	private String curso;
	
	@Column(name="DS_PERIODO")
	private int periodo;
	
	@OneToMany(mappedBy="discente", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=false)
	private List<Tcc> tccs;
	
	@OneToMany(mappedBy="discente", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=false)
	private List<Convite> convites;

	public Discente(){}
	public Discente(Usuario usuario, String curso, int periodo){
		super();
		this.usuario = usuario;
		this.curso = curso;
		this.periodo = periodo;
		this.tccs = new ArrayList<Tcc>();
		this.convites = new ArrayList<Convite>();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public List<Tcc> getTccs() {
		return tccs;
	}
	public void setTccs(List<Tcc> tccs) {
		this.tccs = tccs;
	}
	public List<Convite> getConvites() {
		return convites;
	}
	public void setConvites(List<Convite> convites) {
		this.convites = convites;
	}
	@Override
	public String toString() {
		return "Discente [id=" + id + ", usuario=" + usuario + ", curso=" + curso + ", periodo=" + periodo + ", tccs="
				+ tccs + ", convites=" + convites + "]";
	}
}	
