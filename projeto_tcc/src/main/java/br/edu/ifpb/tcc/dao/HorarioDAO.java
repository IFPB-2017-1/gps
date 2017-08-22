package br.edu.ifpb.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.tcc.entity.Horario;

public class HorarioDAO extends GenericDAO<Horario, Integer> {

	public HorarioDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public HorarioDAO(EntityManager em) {
		super(em);
	}


	//Buscar horário no dia da semana
	@SuppressWarnings("unchecked")
	public List<Horario> pesquisarTSI(){
		Query q = this.getEntityManager().createQuery("select h from Horario h where h.curso='SISTEMAS PARA INTERNET'" );
		return q.getResultList();
	}

}