package br.edu.ifpb.tcc.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.tcc.entity.Discente;

public class DiscenteDAO extends GenericDAO<Discente, Integer> {
	
	public DiscenteDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public DiscenteDAO(EntityManager em) {
		super(em);
	}
	
}
