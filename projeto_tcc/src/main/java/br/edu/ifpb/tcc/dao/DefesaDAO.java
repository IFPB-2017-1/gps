package br.edu.ifpb.tcc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.tcc.entity.Banca;
import br.edu.ifpb.tcc.entity.Defesa;

public class DefesaDAO extends GenericDAO {
	private Defesa defesa;
	private List<Defesa> defesas = new ArrayList<Defesa>();

	public DefesaDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public DefesaDAO(EntityManager em) {
		super(em);
	}

	// buscar defesa pelo Id informado
	public Defesa findDefesaId(int id) {
		Query q = this.getEntityManager().createQuery("select d from Defesa d where d.id = :id");
		q.setParameter("id", id);
		try {
			defesa = (Defesa) q.getSingleResult();
		} catch (Exception e) {

		}
		return defesa;
	}

	// buscar defesas de ume determinada Data informada
	public List<Defesa> findDefesasData(String data) {
		Query q = this.getEntityManager().createQuery("select d from Defesa d where d.data = :data");
		q.setParameter("data", data);
		try {
			defesas = q.getResultList();
		} catch (Exception e) {

		}
		return defesas;
	}

	// Buscar defesa de uma Banca indormada
	public Defesa findDefesaBanca(Banca banca) {
		Query q = this.getEntityManager().createQuery("select d from Defesa d where d.banca = :banca");
		q.setParameter("banca", banca);
		try {
			defesa = (Defesa) q.getSingleResult();
		} catch (Exception e) {

		}
		return defesa;
	}
}
