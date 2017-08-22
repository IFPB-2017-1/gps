package br.edu.ifpb.tcc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
  
	@ManyToMany
	private List<Docente> avaliadores;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Defesa defesa;

  public Banca(){}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Docente> getAvaliadores() {
		return avaliadores;
	}
	public void setAvaliadores(List<Docente> avaliadores) {
		this.avaliadores = avaliadores;
	}
	
}
