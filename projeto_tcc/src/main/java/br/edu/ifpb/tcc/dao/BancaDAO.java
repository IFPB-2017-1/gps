package br.edu.ifpb.tcc.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.tcc.entity.Banca;

public class BancaDAO extends GenericDAO<Banca, Integer> {
	
	public BancaDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public BancaDAO(EntityManager em) {
		super(em);
	}
	
}
