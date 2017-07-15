package br.edu.ifpb.tcc.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_BANCA")
public class Banca {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NU_ID")
	private Integer id;
  
	@ManyToOne
	@JoinColumn(name="ID_ORIENTADOR")
	private Docente orientador;
	
	@OneToMany
	@JoinColumn(name="ID_AVALIADOR")
	private List<Docente> avaliadores;
	
	@OneToMany(mappedBy="banca", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=false)
	private List<Defesa> defesas;

  public Banca(){}
	public Banca(Docente orientador){
		super();
		this.orientador = orientador;
		this.avaliadores = new ArrayList<Docente>();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Docente getOrientador() {
		return orientador;
	}
	public void setOrientador(Docente orientador) {
		this.orientador = orientador;
	}
	public List<Docente> getAvaliadores() {
		return avaliadores;
	}
	public void setAvaliadores(List<Docente> avaliadores) {
		this.avaliadores = avaliadores;
	}
	@Override
	public String toString() {
		return "Banca [id=" + id + ", orientador=" + orientador + ", avaliadores=" + avaliadores + "]";
	}

}
