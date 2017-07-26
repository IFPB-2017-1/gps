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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_DOCENTE")
public class Docente {
	@Id
	@Column(name="NU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
		
	@OneToMany(mappedBy="docente", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=false)
	private List<Convite> convites;
	
	@ManyToOne
	@JoinColumn(name="ID_AGENDA")
	private Agenda agenda;
	
	@OneToMany 	(mappedBy="docente", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Horario> horarios;
	
	public void addHorario(Horario horario){
		horarios.add(horario);
	}
	

	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horario) {
		this.horarios = horario;
	}
	public List<Tcc> getTccs() {
		return tccs;
	}
	public void setTccs(List<Tcc> tccs) {
		this.tccs = tccs;
	}

	@OneToMany(mappedBy="orientador", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=false)
	private List<Tcc> tccs;
	
	public Docente(){
		horarios = new ArrayList<Horario>();
	}
	public Docente(Usuario usuario){
		super();
		this.usuario = usuario;
		this.agenda = new Agenda();
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

	public List<Convite> getConvites() {
		return convites;
	}

	public void setConvites(List<Convite> convites) {
		this.convites = convites;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	@Override
	public String toString() {
		return "Docente [id=" + id + ", usuario=" + usuario + ", " + ", convites=" + convites
				+ ", agenda=" + agenda + "]";
	}
	
}
