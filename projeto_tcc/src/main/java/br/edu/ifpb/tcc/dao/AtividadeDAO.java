package br.edu.ifpb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.entity.Atividade;
import br.edu.ifpb.entity.Docente;

public class AtividadeDAO extends GenericDAO {
	private Atividade atividade;
	private List<Atividade> atividades = new ArrayList<Atividade>();

	public AtividadeDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public AtividadeDAO(EntityManager em) {
		super(em);
	}

	// Buscar as atividades da agenda de um determinado Docente.
	public List<Atividade> findAtividades(int id) {
		// Query q = this.getEntityManager().createQuery("select a from
		// Atividade a"
		// + " where docente = :docente");
		//
		Query q = this.getEntityManager().createQuery(
				"select ativs from Docente d " + "JOIN d.agenda ag JOIN ag.atividades ativs where d.id = :id");
		q.setParameter("id", id);
		try {
			atividades = q.getResultList();
		} catch (Exception e) {

		}
		return atividades;
	}

	// Buscar atividade de um id informado
	public Atividade findAtividade(int id) {
		Query q = this.getEntityManager().createQuery("select a from Atividade a where a.id = :id");
		q.setParameter("id", id);
		try {
			atividade = (Atividade) q.getSingleResult();
		} catch (Exception e) {

		}
		return atividade;
	}

	// Buscar atividades por uma descrição informada
	public List<Atividade> findAtividadesDescricao(String descricao) {
		Query q = this.getEntityManager().createQuery("select a from Atividade a where a.descricao = :descricao");
		q.setParameter("descricao", descricao);
		try {
			atividades = q.getResultList();
		} catch (Exception e) {

		}
		return atividades;
	}

	// Buscar atividades por uma data informada
	public List<Atividade> findAtividadesData(String data) {
		Query q = this.getEntityManager().createQuery("select a from Atividade a where a.data = :data");
		q.setParameter("data", data);
		try {
			atividades = q.getResultList();
		} catch (Exception e) {

		}
		return atividades;
	}
}
