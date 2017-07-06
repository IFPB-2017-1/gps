package br.edu.ifpb.tcc.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.tcc.entity.Tcc;

public class TccDAO extends GenericDAO<Tcc, Integer> {
	
	public TccDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public TccDAO(EntityManager em) {
		super(em);
	}
	
}
