package br.edu.ifpb.tcc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_DEFESA")
public class Defesa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="DS_LOCAL")
	private String local;
	
	@Column(name="DT_DATA_HORA")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="ID_ORIENTADOR")
	private Docente orientador;
	
	@ManyToOne
	@JoinColumn(name="ID_BANCA")
	private Banca banca;
	
	@ManyToMany
	@JoinColumn
	private List<Docente> avaliadores;
	
	@Column(name="DS_NOTA")
	private double nota;
	
	@Column(name="BO_ATIVO")
	private boolean ativo;
	
	public Defesa(){}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	public Banca getBanca() {
		return banca;
	}
	public void setBanca(Banca banca) {
		this.banca = banca;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Docente> getAvaliadores() {
		return avaliadores;
	}

	public void setAvaliadores(List<Docente> avaliadores) {
		this.avaliadores = avaliadores;
	}
	
}