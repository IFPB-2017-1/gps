package br.edu.ifpb.tcc.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.tcc.entity.Agenda;


public class AgendaDAO extends GenericDAO<Agenda, Integer>{
	private Agenda agenda;
	
	public AgendaDAO(){
		this(PersistenceUtil.getCurrentEntityManager());
	}
	public AgendaDAO(EntityManager em){
		super(em);
	}
	
	//busca de agenda pelo id informado
	public Agenda findAgendaId(int id){
		Query q = this.getEntityManager().createQuery("select a from Agenda a where a.id = :id");
		q.setParameter("id", id);
		try{
			agenda = (Agenda) q.getSingleResult();
		}catch(Exception e){
			
		}
		return agenda;
	}
}
