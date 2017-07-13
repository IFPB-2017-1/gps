package br.edu.ifpb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_TCC")
public class Tcc {
	@Id
	@Column(name="NU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ID_DISCENTE")
	private Discente discente;
	
	@JoinColumn(name="ID_DOCENTE")
	private Docente orientador;
	
	@Column(name="DS_TITULO")
	private String titulo;
	
	@Column(name="DS_ARQUIVO_TCC")
	private long arquivoTCC;
	
	@Column(name="DS_APROVADO")
	private boolean aprovado;
	
	@Column(name="DS_TIPO")
	private String tipo;
	
	@OneToMany
	@JoinColumn(name="ID_DEFESA")
	private List<Defesa> defesas;
	
	public Tcc(){}
	public Tcc(String titulo, Discente discente, String tipo){
		super();
		this.titulo = titulo;
		this.discente = discente;
		this.tipo = tipo;
		this.defesas = new ArrayList<Defesa>();
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
	
	public Docente getOrientador() {
		return orientador;
	}
	public void setOrientador(Docente orientador) {
		this.orientador = orientador;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public long getArquivoTCC() {
		return arquivoTCC;
	}

	public void setArquivoTCC(long arquivoTCC) {
		this.arquivoTCC = arquivoTCC;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Defesa> getDefesas() {
		return defesas;
	}

	public void setDefesas(List<Defesa> defesas) {
		this.defesas = defesas;
	}
	
	@Override
	public String toString() {
		return "Tcc [id=" + id + ", discente=" + discente + ", orientador=" + orientador + ", titulo=" + titulo
				+ ", arquivoTCC=" + arquivoTCC + ", aprovado=" + aprovado + ", tipo=" + tipo + ", defesas=" + defesas
				+ "]";
	}
	
}
