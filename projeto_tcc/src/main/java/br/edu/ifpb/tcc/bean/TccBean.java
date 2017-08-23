package br.edu.ifpb.tcc.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import br.edu.ifpb.tcc.entity.Docente;
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
    private boolean excluir;
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

	public String edit(Tcc tcc) {
		Flash flash= FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("titulo", tcc.getTitulo());
		flash.put("tipo", tcc.getTipo());
		flash.put("orientador", tcc.getOrientador());
		flash.put("proposta", tcc.getArquivoTCC());
		flash.put("id", tcc.getId());
		return"editarTcc?faces-redirect=true";
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
		return "/tcc/indexTcc?faces-redirect=true";
	}
	
	public String update() {
		Flash flash= FacesContext.getCurrentInstance().getExternalContext().getFlash();
		String id = (String) flash.get("id");
		tcc = tccDao.find(Integer.parseInt(id));
		String titulo = (String) flash.get("titulo");
		Docente orientador = (Docente) flash.get("orientador");
		tcc.setDiscente(discente);
		tcc.setOrientador(orientador);
		tcc.setTitulo(titulo);
		tccDao.beginTransaction();
		tccDao.update(tcc);
		discenteDao.update(discente);
		tccDao.commit();
		return "/tcc/indexTcc?faces-redirect=true";
	}
	
//	private Map<Integer, Boolean> checked = new HashMap<>(); 
//
//	public void delete(){
//			List<Tcc> tccs = new ArrayList<Tcc>();
//	        for (Tcc tcc : tccs) {
//	            Boolean itemChecked = checked.get(tcc.getId());
//	            if (itemChecked !=null && itemChecked) {
//	            	tccDao.delete(tcc);
//	            }
//	        }
//	        if (!checked.isEmpty()) {
//	        	infoMessage = "Tcc(s) removido com sucesso.";
//	        }
//	    checked.clear();
//	}

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

	public boolean isExcluir() {
		return excluir;
	}

	public void setExcluir(boolean excluir) {
		this.excluir = excluir;
	}
	
}
