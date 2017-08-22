package br.edu.ifpb.tcc.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.edu.ifpb.tcc.dao.DiscenteDAO;
import br.edu.ifpb.tcc.dao.DocenteDAO;
import br.edu.ifpb.tcc.dao.TccDAO;
import br.edu.ifpb.tcc.entity.Discente;
import br.edu.ifpb.tcc.entity.Tcc;
import br.edu.ifpb.tcc.entity.Tipo;
import br.edu.ifpb.tcc.entity.Usuario;

@ManagedBean
@RequestScoped
public class TccBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean login;
	private List<Tcc> tccs;
	private Tcc tcc;
	private Usuario orientador;
	private String titulo;
	private Discente discente;
	private TccDAO tccDao = new TccDAO();
	private DiscenteDAO discenteDao = new DiscenteDAO();
	private DocenteDAO docenteDao = new DocenteDAO();
	
	@PostConstruct
	public void init(){
		tccs = tccDao.findAll();
		tcc = new Tcc();
		orientador = new Usuario();
		discente = discenteDao.findDiscente(login.getUsuarioLogado());
	}

	public String edit() {
		Flash flash= FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("nome", titulo);
		return"edit_tcc?faces-redirect=true";
	}
	
	public String add() {
		Tcc novo = new Tcc();
		novo.setDiscente(discente);
		novo.setOrientador(docenteDao.findDocente(this.tcc.getOrientador().getUsuario()));
		novo.setTipo(tcc.getTipo());
		novo.setTitulo(tcc.getTitulo());
		tccDao.beginTransaction();
		tccDao.insert(novo);
		discenteDao.update(discente);
		tccDao.commit();
		return "index_tcc";
	}
	
	public Tipo[] getTipos(){
        return Tipo.values();
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

	public Usuario getOrientador() {
		return orientador;
	}

	public void setOrientador(Usuario orientador) {
		this.orientador = orientador;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public Discente getDiscente() {
		return discente;
	}

	public void setDiscente(Discente discente) {
		this.discente = discente;
	}
	
}
