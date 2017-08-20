package br.edu.ifpb.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.edu.ifpb.tcc.dao.DocenteDAO;
import br.edu.ifpb.tcc.entity.Docente;
import br.edu.ifpb.tcc.entity.Tipo;

@ManagedBean
@ApplicationScoped
public class UtilBean {
	
	private List<Tipo> tipos;
	private List<Docente> orientadores;

	@PostConstruct
	private void init() {
		tipos = new ArrayList<Tipo>();
		Tipo[]todos_tipos = Tipo.values();
		for (Tipo tipo : todos_tipos) {
			tipos.add(tipo);
		}
		DocenteDAO oridao = new DocenteDAO();
		orientadores = oridao.findAll();
	}

	public List<Tipo> getTipos() {
		return tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}

	public List<Docente> getOrientadores() {
		return orientadores;
	}

	public void setOrientadores(List<Docente> orientadores) {
		this.orientadores = orientadores;
	}

}
