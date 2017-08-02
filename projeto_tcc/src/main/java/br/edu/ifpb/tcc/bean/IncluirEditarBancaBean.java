package br.edu.ifpb.tcc.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.print.attribute.standard.DateTimeAtCompleted;

import br.edu.ifpb.tcc.dao.BancaDAO;
import br.edu.ifpb.tcc.dao.DefesaDAO;
import br.edu.ifpb.tcc.dao.DocenteDAO;
import br.edu.ifpb.tcc.dao.TccDAO;
import br.edu.ifpb.tcc.entity.Banca;
import br.edu.ifpb.tcc.entity.Defesa;
import br.edu.ifpb.tcc.entity.Tcc;
import br.edu.ifpb.tcc.entity.Docente;

@ManagedBean
@ViewScoped
public class IncluirEditarBancaBean {
	
	private Banca banca;
	private Defesa defesa;
	private Tcc tcc;
	private Date dataSelecionada;
	private LocalDate ld;
	private String horaInicio, horaFim;
	private List<Docente> docentes;
	
	private TccDAO tccDao = new TccDAO();
	private BancaDAO bancaDao = new BancaDAO();
	private DefesaDAO defesaDao = new DefesaDAO();
	private DocenteDAO docenteDao = new DocenteDAO();
	
	
	
	@PostConstruct
	public void init(){
		
		tcc = tccDao.find(1);
		banca = new Banca();
		defesa = new Defesa();
		docentes = docenteDao.findAll();
	}
	
	public void pesquisar(){
		if(dataSelecionada!=null){
			Calendar c = Calendar.getInstance();
			c.setTime(dataSelecionada);
			ld = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH));
			System.out.println(ld.getDayOfWeek().getDisplayName(TextStyle.FULL,new Locale("pt", "BR")));
		}
	}


	public Banca getBanca() {
		return banca;	
	}



	public void setBanca(Banca banca) {
		this.banca = banca;
	}



	public Defesa getDefesa() {
		return defesa;
	}



	public void setDefesa(Defesa defesa) {
		this.defesa = defesa;
	}



	public Tcc getTcc() {
		return tcc;
	}



	public void setTcc(Tcc tcc) {
		this.tcc = tcc;
	}



	public Date getDataSelecionada() {
		return dataSelecionada;
	}



	public void setDataSelecionada(Date dataSelecionada) {
		this.dataSelecionada = dataSelecionada;
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



	public List<Docente> getDocentes() {
		return docentes;
	}



	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

}
