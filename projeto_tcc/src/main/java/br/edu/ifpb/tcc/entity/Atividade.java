package br.edu.ifpb.tcc.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_ATIVIDADE")
public class Atividade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NU_ID")
	private Integer id;
	
	@Column(name="DS_DATA")
	private String data;
	
	@Column(name="DS_HORA")
	private String hora;
	
	@Column(name="DS_DESCRICAO")
	private String Descri��o;
	
	public Atividade(){}
	public Atividade(String descricao){
		super();
		this.Descri��o = descricao;
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
	public String getDescri��o() {
		return Descri��o;
	}
	public void setDescri��o(String descri��o) {
		Descri��o = descri��o;
	}
	
	@Override
	public String toString() {
		return "Atividade [id=" + id + ", data=" + data + ", hora=" + hora + ", Descri��o=" + Descri��o + "]";
	}
	
}