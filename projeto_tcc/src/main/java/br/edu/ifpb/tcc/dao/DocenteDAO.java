package br.edu.ifpb.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.tcc.entity.Docente;
import br.edu.ifpb.tcc.entity.Usuario;

public class DocenteDAO extends GenericDAO<Docente, Integer> {

	public DocenteDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public DocenteDAO(EntityManager em) {
		super(em);
	}


	// Buscar um docente pelo nome
	public Docente findDocente(Usuario usuario) {
		Docente docente = null;
		Query q = this.getEntityManager().createQuery("select d from Docente d where d.usuario = :usuario");
		q.setParameter("usuario", usuario);
		try {
			docente = (Docente) q.getSingleResult();
		} catch (Exception e) {
			
		}
		return docente;
	}
	
	//Buscar docentes com horário no dia da semana
	@SuppressWarnings("unchecked")
	public List<Docente> pesquisarDiaSemana (String dia){
		Query q = this.getEntityManager().createQuery("select distinct h.docente from Horario h where h.diaSemana != 'SEGUNDA' and h.curso='SISTEMAS PARA INTERNET'" );
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Docente> pesquisarTSI(){
		Query q = this.getEntityManager().createQuery("select distinct h.docente from Horario h where h.curso='SISTEMAS PARA INTERNET'" );
		return q.getResultList();
	}

}