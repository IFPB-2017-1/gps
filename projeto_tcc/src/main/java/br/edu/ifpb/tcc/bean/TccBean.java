package br.edu.ifpb.tcc.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.edu.ifpb.tcc.dao.DiscenteDAO;
import br.edu.ifpb.tcc.dao.DocenteDAO;
import br.edu.ifpb.tcc.dao.TccDAO;
import br.edu.ifpb.tcc.entity.Tcc;
import br.edu.ifpb.tcc.entity.Tipo;

@ManagedBean
@RequestScoped
public class TccBean {
	
	public Tipo[] getTipos(){
        return Tipo.values();
    }

	private List<Tcc> tccs;
	private Tcc tcc;
	private String titulo;
	
	private TccDAO tccDao = new TccDAO();
	DiscenteDAO discenteDao = new DiscenteDAO();
	DocenteDAO docenteDao = new DocenteDAO();
	
	@PostConstruct
	public void init(){
		tccs = tccDao.findAll();
		tcc = new Tcc();
	}

	public String edit() {
		Flash flash= FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("nome", titulo);
		return"edit_tcc?faces-redirect=true";
	}
	
	public String add() {
		Tcc novo;
		novo = new Tcc();
		novo.setDiscente(discenteDao.find(1));
		novo.setOrientador(docenteDao.find(10));
		novo.setTipo(tcc.getTipo());
		novo.setTitulo(tcc.getTitulo());

		tccDao.beginTransaction();
		tccDao.insert(novo);
		tccDao.commit();
		return "index_tcc";
	}

	public List<Tcc> getTccs() {
		return tccs;
	}

	public void setTccs(List<Tcc> tccs) {
		this.tccs = tccs;
	}

	public Tcc getTcc() {
		return tcc;
	}

	public void setTcc(Tcc tcc) {
		this.tcc = tcc;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TccDAO getTccDao() {
		return tccDao;
	}

	public void setTccDao(TccDAO tccDao) {
		this.tccDao = tccDao;
	}	
	
}
