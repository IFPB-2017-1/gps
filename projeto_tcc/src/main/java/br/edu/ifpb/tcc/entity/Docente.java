package br.edu.ifpb.entity;

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
import javax.persistence.Table;

@Entity
@Table(name="TB_DOCENTE")
public class Docente {
	@Id
	@Column(name="NU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	@Column(name="DS_DISCIPLINA")
	private String disciplina;
	
	@OneToMany(mappedBy="docente", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=false)
	private List<Convite> convites;
	
	@JoinColumn(name="ID_AGENDA")
	private Agenda agenda;
	
	public Docente(){}
	public Docente(Usuario usuario, String disciplina){
		super();
		this.usuario = usuario;
		this.disciplina = disciplina;
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

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
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
		return "Docente [id=" + id + ", usuario=" + usuario + ", disciplina=" + disciplina + ", convites=" + convites
				+ ", agenda=" + agenda + "]";
	}
	
}
