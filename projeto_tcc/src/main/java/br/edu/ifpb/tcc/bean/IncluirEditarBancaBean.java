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
public class IncluirEditarBancaBean {
	
	private Banca banca;
	private Defesa defesa;
	private Tcc tcc;
	private Date dataSelecionada;
	private LocalDate ld;
	private String horaInicio, horaFim;
	private DualListModel<Docente> docentes;
	private DualListModel<Horario> horarios;

	private List<Docente> docentesSource;
	private List<Docente> docentesTarget;
	private List<Horario> horariosSource;
	private List<Horario> horariosTarget;
	
	private TccDAO tccDao = new TccDAO();
	private BancaDAO bancaDao = new BancaDAO();
	private DefesaDAO defesaDao = new DefesaDAO();
	private DocenteDAO docenteDao = new DocenteDAO();
	private HorarioDAO horarioDao = new HorarioDAO();
	
	
	
	@PostConstruct
	public void init(){
		
		tcc = tccDao.find(1);
		banca = new Banca();
		defesa = new Defesa();
//		docentes = docenteDao.findAll();
		docentesSource = docenteDao.findAll();
        docentesTarget = new ArrayList<>();
//        horariosSource = new ArrayList<>();
        horariosTarget = new ArrayList<>();
         
        docentes =  new DualListModel<Docente>(docentesSource, docentesTarget);
        horarios =  new DualListModel<Horario>(horariosSource, horariosTarget);
	}
	
	public void pesquisar(){
		if(dataSelecionada!=null){
			Calendar c = Calendar.getInstance();
			c.setTime(dataSelecionada);
			ld = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH));
			String dia = ld.getDayOfWeek().getDisplayName(TextStyle.FULL,new Locale("pt", "BR")).split("-")[0].toUpperCase();
			
			
			LocalTime ltHoraInicio = LocalTime.parse(horaInicio);
			LocalTime ltHoraFim = LocalTime.parse(horaFim);
			
			List<HorarioEnum> horariosUtilizadosDefesa = new ArrayList<>();
			Set<Docente> listaDocentesFiltrada = new HashSet<>();
			List<Horario> horariosTemp = horarioDao.pesquisarTSI();
			List<Docente> docentesTemp = docenteDao.pesquisarTSI();
			
			for(HorarioEnum h : HorarioEnum.values()){
				if(h.getInicio().isBefore(ltHoraFim) && h.getFim().isAfter(ltHoraInicio) ){
					horariosUtilizadosDefesa.add(h);
				}
			}
			
			for (Horario h : horariosTemp){
				if(h.getDiaSemana().equals(dia)){
					if(horariosUtilizadosDefesa.contains(HorarioEnum.valueOf(h.getCodigoHorario()))){
						
						listaDocentesFiltrada.add(h.getDocente());
					}
				}
			}
			
			docentesSource = new ArrayList<>();
			for(Docente d : docentesTemp){
				if(!listaDocentesFiltrada.contains(d)){
					docentesSource.add(d);
				}
			}			
//			horariosSource
			
			docentes =  new DualListModel<Docente>(docentesSource, docentesTarget);
			horarios = new DualListModel<Horario>(horariosSource,horariosTarget);
			
			
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



	public DualListModel<Docente> getDocentes() {
		return docentes;
	}



	public void setDocentes(DualListModel<Docente> docentes) {
		this.docentes = docentes;
	}
	
	
	public DualListModel<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(DualListModel<Horario> horarios) {
		this.horarios = horarios;
	}

	public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Docente) item).getUsuario().getNome()).append("<br />");
        }
         
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
 
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 

}
