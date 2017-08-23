package br.edu.ifpb.tcc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_DEFESA")
public class Defesa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
//	@ManyToOne (cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	@JoinColumn (name="TCC_ID")
//	private Tcc tcc;
	
	@Column(name="DS_LOCAL")
	private String local;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_DATA_HORA")
	private Date data;
	
	@Column(name="HORA_INICIO")
	private String horaInicio;
	
	@Column(name="HORA_FIM")
	private String horaFim;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)  
    @JoinTable(name="DEFESA_AVALIADORES", 
              joinColumns={@JoinColumn(name="DEFESA_ID", 
               referencedColumnName="id")},  
              inverseJoinColumns={@JoinColumn(name="DOCENTE_ID", 
                referencedColumnName="NU_ID")}) 
	private List<Docente> avaliadores;
	
	@Column(name="DS_NOTA")
	private double nota;
	
	@Column(name="SITUACAO")
	@Enumerated(EnumType.STRING)
	private SituacaoEnum situacao;
	
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
	
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public List<Docente> getAvaliadores() {
		return avaliadores;
	}

	public void setAvaliadores(List<Docente> avaliadores) {
		this.avaliadores = avaliadores;
	}

	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}	
	
}