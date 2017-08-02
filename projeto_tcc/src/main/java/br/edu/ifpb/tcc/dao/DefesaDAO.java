package br.edu.ifpb.tcc.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.tcc.entity.Defesa;

public class DefesaDAO extends GenericDAO<Defesa, Integer> {
	
	public DefesaDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public DefesaDAO(EntityManager em) {
		super(em);
	}
	
}
