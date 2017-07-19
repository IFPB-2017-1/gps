package br.edu.ifpb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.entity.Discente;
import br.edu.ifpb.entity.Docente;
import br.edu.ifpb.entity.Tcc;

public class TccDAO extends GenericDAO{
	private Tcc tcc;
	private List<Tcc> tccs = new ArrayList<Tcc>();
	
	public TccDAO(){
		this(PersistenceUtil.getCurrentEntityManager());
	}
	public TccDAO(EntityManager em){
		super(em);
	}
	
	//Buscar Tcc pelo titulo
	public List<Tcc> findTccsTitulo(String titulo){
		Query q = this.getEntityManager().createQuery("select t from Tcc t where LOWER(t.titulo) LIKE :titulo");
		q.setParameter("titulo", "%" + titulo + "%");
		try{
			tccs = q.getResultList();
		}catch(Exception e){
			
		}
		return tccs;
	}
	
	//Buscar Tcc pelo id 
	public Tcc findTccId(int id){
		Query q = this.getEntityManager().createQuery("select t from Tcc t where t.id = :id");
		q.setParameter("id", id);
		try{
			tcc = (Tcc) q.getSingleResult();
		}catch(Exception e){
			
		}
		return tcc;
	}
	
	//Buscar Tcc pelo Discente
	public Tcc findTccDiscente(Discente discente){
		Query q = this.getEntityManager().createQuery("select t from Tcc t where t.discente = :discente");
		q.setParameter("discente", discente);
		try{
			tcc = (Tcc) q.getSingleResult();
		}catch(Exception e){
			
		}
		return tcc;
	}
	
	//Buscar Tcc pelo Docente
	public Tcc findTccDocente(Docente docente){
		Query q = this.getEntityManager().createQuery("select t from Tcc t where t.docente = :docente");
		q.setParameter("docente", docente);
		try{
			tcc = (Tcc) q.getSingleResult();
		}catch(Exception e){
			
		}
		return tcc;
	}
}
