package br.edu.ifpb.tcc.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.tcc.entity.Discente;
import br.edu.ifpb.tcc.entity.Usuario;

public class DiscenteDAO extends GenericDAO<Discente, Integer> {
	
	public DiscenteDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public DiscenteDAO(EntityManager em) {
		super(em);
	}
	
//	public Discente findByMatricula(int matricula) {//N�o � mais utilizada
//		Query q1 = this.getEntityManager().createQuery("select u from Usuario u where u.matricula = :matricula");
//		Query q2 = this.getEntityManager().createQuery("select d from Discente d where d.usuario = :usuario");
//		q1.setParameter("matricula", matricula);
//		
//		Discente discente = null;
//		try {
//			Usuario usuario = (Usuario) q1.getSingleResult();
//			q2.setParameter("usuario", usuario);
//			discente = (Discente) q2.getSingleResult();
//		} catch (NoResultException e) {
//		}
//		return discente;
//	}
	
	// Buscar um discente pelo usuario
	public Discente findDiscente(Usuario usuario) {
		Discente discente = null;
		Query q = this.getEntityManager().createQuery("select d from Discente d where d.usuario = :usuario");
		q.setParameter("usuario", usuario);
		try {
			discente = (Discente) q.getSingleResult();
		} catch (Exception e) {
			
		}
		return discente;
	}
	
}
