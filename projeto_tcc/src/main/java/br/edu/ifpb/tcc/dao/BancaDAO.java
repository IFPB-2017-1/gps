package br.edu.ifpb.tcc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.tcc.entity.Banca;
import br.edu.ifpb.tcc.entity.Docente;

public class BancaDAO extends GenericDAO {
	private Banca banca;
	private List<Banca> bancas = new ArrayList<Banca>();

	public BancaDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public BancaDAO(EntityManager em) {
		super(em);
	}

	// Buscar Banca atraves de Id informado
	public Banca findBancaId(int id) {
		Query q = this.getEntityManager().createQuery("select b from Banca b where b.id = :id");
		q.setParameter("id", id);
		try {
			banca = (Banca) q.getSingleResult();
		} catch (Exception e) {

		}
		return banca;
	}

	// Buscar Bancas de um determinado Orientador(Docente).
	public List<Banca> findBancasOrientador(Docente orientador) {
		Query q = this.getEntityManager().createQuery("select b from Banca b where b.orientador = :orientador");
		q.setParameter("orientador",orientador);
		try {
			bancas = q.getResultList();
		} catch (Exception e) {

		}
		return bancas;
	}
}
