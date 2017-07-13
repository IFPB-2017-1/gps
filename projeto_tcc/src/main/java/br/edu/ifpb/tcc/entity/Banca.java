package br.edu.ifpb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_BANCA")
public class Banca {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NU_ID")
	private Integer id;
	
	@JoinColumn(name="ID_ORIENTADOR")
	private Docente orientador;
	
	@OneToMany
	@JoinColumn(name="ID_AVALIADOR")
	private List<Docente> avaliadores;
	
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
