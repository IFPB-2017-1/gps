package br.edu.ifpb.tcc.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_HORARIO")
public class Horario {
	
	@Id
	@Column(name="NU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ID_DOCENTE")
	private Docente docente;
	
	@Column(name="DS_LOCALIZACAO")
	private String localizacao;
	
	@Column (name="DS_DIA_SEMANA")
	private String diaSemana;
	
	@Column(name="COD_HORARIO")
	private String codigoHorario;
	
	@Column(name="TURMA")
	private String turma;
	
	@Column(name="PERIODO")
	private String periodo;
	
	@Column(name="DS_DISCIPLINA")
	private String disciplina;
	
	@Column(name="DS_CURSO")
	private String curso;


		

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getCodigoHorario() {
		return codigoHorario;
	}

	public void setCodigoHorario(HorarioEnum codigoHorario) {
		this.codigoHorario = codigoHorario.toString();
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	
	

	
	
	
	
}
