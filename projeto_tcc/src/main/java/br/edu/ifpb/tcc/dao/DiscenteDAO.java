package br.edu.ifpb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.entity.Discente;
import br.edu.ifpb.entity.Docente;

public class DiscenteDAO extends GenericDAO {
	private Discente discente;
	private List<Discente> discentes = new ArrayList<Discente>();

	public DiscenteDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public DiscenteDAO(EntityManager em) {
		super(em);
	}

	// Busca discente pelo Id
	public Discente findId(int id) {
		Query q = this.getEntityManager().createQuery("select d from Discente d where d.id = :id");
		q.setParameter("id", id);
		try {
			discente = (Discente) q.getSingleResult();
		} catch (Exception e) {

		}
		return discente;
	}

	// Buscar a lista de discente de um determinado curso
	public List<Discente> findDiscentesCurso(String curso) {
		Query q = this.getEntityManager().createQuery("select d from Discente d where d.curso = :curso");
		q.setParameter("curso", curso);

		try {
			discentes = q.getResultList();
		} catch (Exception e) {

		}
		return discentes;
	}

	// Buscar a lista de Discentes de determinado curso e determinado periodo
	public List<Discente> findDiscentesCursoPeriodo(String curso, int periodo) {
		Query q = this.getEntityManager()
				.createQuery("select d from Discente d " + "where d.curso = :curso AND d.periodo = :periodo");
		q.setParameter("curso", curso);
		q.setParameter("periodo", periodo);

		try {
			discentes = q.getResultList();
		} catch (Exception e) {

		}
		return discentes;
	}

	// Buscar um docente pelo nome
	public Discente findDiscente(String nome) {
		Query q = this.getEntityManager().createQuery("select d from Discente d where d.nome = :nome");
		q.setParameter("nome", nome);
		try {
			discente = (Discente) q.getSingleResult();
		} catch (Exception e) {

		}
		return discente;
	}
}
