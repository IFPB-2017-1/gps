package br.edu.ifpb.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TB_DEFESA")
public class Defesa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="DS_LOCAL")
	private String local;
	
	@Column(name="DS_DATA")
	private String data;
	
	@Column(name="DS_HORA")
	private String hora;
	
	@JoinColumn(name="ID_LOCAL")
	private Banca banca;
	
	@Column(name="DS_NOTA")
	private double nota;
	
	public Defesa(){}
	public Defesa(String local, Banca banca){
		super();
		this.local = local;
		this.banca = banca;
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		String dataString = format.format(date);
		String[] array = new String[2];
		array = dataString.split(" ");
		this.data = array[0];
		this.hora = array[1];
	}
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
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
	@Override
	public String toString() {
		return "Defesa [id=" + id + ", local=" + local + ", data=" + data + ", hora=" + hora + ", banca=" + banca
				+ ", nota=" + nota + "]";
	}
	
}
