package br.edu.ifpb.tcc.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifpb.tcc.dao.DefesaDAO;
import br.edu.ifpb.tcc.dao.TccDAO;
import br.edu.ifpb.tcc.entity.Defesa;
import br.edu.ifpb.tcc.entity.Tcc;

@ManagedBean
@ViewScoped
public class ManterDefesaBean extends GenericBean{
	
	private List<Defesa> defesas;
	private List<Tcc> tccLista;


		
	private TccDAO tccDao = new TccDAO();
	private DefesaDAO defesaDao = new DefesaDAO();
	
	
	@PostConstruct
	public void init(){
		
		tccLista = tccDao.findAll();
		defesas = defesaDao.findAll();
	}

	public List<Defesa> getDefesas() {
		return defesas;
	}

	public void setDefesas(List<Defesa> defesas) {
		this.defesas = defesas;
	}



	public List<Tcc> getTccLista() {
		return tccLista;
	}

	public void setTccLista(List<Tcc> tccLista) {
		this.tccLista = tccLista;
	}
	
	
}
