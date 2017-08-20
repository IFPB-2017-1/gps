package br.edu.ifpb.tcc.bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

import br.edu.ifpb.tcc.dao.BancaDAO;
import br.edu.ifpb.tcc.dao.DefesaDAO;
import br.edu.ifpb.tcc.dao.DocenteDAO;
import br.edu.ifpb.tcc.dao.HorarioDAO;
import br.edu.ifpb.tcc.dao.TccDAO;
import br.edu.ifpb.tcc.entity.Banca;
import br.edu.ifpb.tcc.entity.Defesa;
import br.edu.ifpb.tcc.entity.Docente;
import br.edu.ifpb.tcc.entity.Horario;
import br.edu.ifpb.tcc.entity.HorarioEnum;
import br.edu.ifpb.tcc.entity.Tcc;

@ManagedBean
@ViewScoped
public class IncluirEditarDefesaBean extends GenericBean{
	
	private Banca banca;
	private Defesa defesa;
	private Tcc tcc;


		
	private TccDAO tccDao = new TccDAO();
	private BancaDAO bancaDao = new BancaDAO();
	private DefesaDAO defesaDao = new DefesaDAO();
	
	
	@PostConstruct
	public void init(){
		
		tcc = (Tcc) this.getFlash("tcc");
	}
	public void carregaTcc(Tcc tcc){
		this.setFlash("tcc", tcc);
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

	
	
	
}
