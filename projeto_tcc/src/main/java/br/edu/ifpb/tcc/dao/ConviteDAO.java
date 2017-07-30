package br.edu.ifpb.tcc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.tcc.entity.Convite;
import br.edu.ifpb.tcc.entity.Discente;
import br.edu.ifpb.tcc.entity.Docente;

public class ConviteDAO extends GenericDAO<Convite, Integer> {
	private Convite convite;
	private List<Convite> convites = new ArrayList<Convite>();

	public ConviteDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}
	public ConviteDAO(EntityManager em) {
		super(em);
	}
	
	//Buscar convite por um id informado
	public Convite findConviteId(int id){
		Query q = this.getEntityManager().createQuery("select c from Convite c where c.id = :id");
		q.setParameter("id", id);
		try{
			convite = (Convite) q.getSingleResult();
		}catch(Exception e){
			
		}
		return convite;
	}
	
	//Buscar convites de um determinado Discente
	public List<Convite> findConvitesDiscente(Discente discente){
		Query q = this.getEntityManager().createQuery("select c from Convite c where c.discente = :discente");
		q.setParameter("discente", discente);
		try{
			
		}catch(Exception e){
			convites = q.getResultList();
		}
		return convites;
	}
	
	//Buscar convites de um determinado Docente
	public List<Convite> findConvitesDocente(Docente docente){
		Query q = this.getEntityManager().createQuery("select c from Convite c where c.docente = :docente");
		q.setParameter("docente", docente);
		try{
			
		}catch(Exception e){
			convites = q.getResultList();
		}
		return convites;
	}
	
	//Buscar convites de um determinado Discente e determinado Docente
	public List<Convite> findConvitesDocenteDiscente(Docente docente, Discente discente){
		Query q = this.getEntityManager().createQuery("select c from Convite c "
				+ "where c.docente = :docente AND c.discente = :discente");
		q.setParameter("docente", docente);
		q.setParameter("discente", discente);
		try{
			
		}catch(Exception e){
			convites = q.getResultList();
		}
		return convites;
	}
}
