package br.edu.ifpb.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.tcc.entity.Tcc;
import br.edu.ifpb.tcc.entity.Usuario;

public class TccDAO extends GenericDAO<Tcc, Integer> {
	
	public TccDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public TccDAO(EntityManager em) {
		super(em);
	}
	public List<Tcc> findTccsDicente(int id) {
		Query q = this.getEntityManager().createQuery("select t from Tcc t where t.dicente.id = :id");
		q.setParameter("id", id);
		List<Tcc> tccs = null;
		try {
			tccs = (List<Tcc>) q.getResultList();
		} catch (NoResultException e) {
		}
		return tccs;
	}
	
}
