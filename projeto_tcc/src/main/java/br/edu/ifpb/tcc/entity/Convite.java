package br.edu.ifpb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CONVITE")
public class Convite {
	@Id
	@Column(name="NU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ID_DISCENTE")
	private Discente discente;
	
	@ManyToOne
	@JoinColumn(name="ID_DOCENTE")
	private Docente docente;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_CONVITE")
	private Date data;
	
	@Column(name="DS_ACEITO")
	private boolean aceito;
	
	public Convite(){}
	public Convite(Discente discente, Docente docente){
		super();
		this.discente = discente;
		this.docente = docente;
		this.data = new Date();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Discente getDiscente() {
		return discente;
	}
	public void setDiscente(Discente discente) {
		this.discente = discente;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isAceito() {
		return aceito;
	}
	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}
	
	@Override
	public String toString() {
		return "Convite [id=" + id + ", discente=" + discente + ", docente=" + docente + ", data=" + data + ", aceito="
				+ aceito + "]";
	}
	
}
