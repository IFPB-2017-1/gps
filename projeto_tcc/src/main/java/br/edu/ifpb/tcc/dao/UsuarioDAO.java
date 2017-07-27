package br.edu.ifpb.tcc.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.tcc.entity.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Integer> {
	
	public UsuarioDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public UsuarioDAO(EntityManager em) {
		super(em);
	}

	public Usuario findByLogin(String login) {
		Query q = this.getEntityManager().createQuery("select u from Usuario u where u.email = :login");
		q.setParameter("login", login);
		Usuario usuario = null;
		try {
			usuario = (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
		}
		return usuario;
	}
	public Usuario findByName(String nome) {
		Query q = this.getEntityManager().createQuery("select u from Usuario u where u.nome = :nome");
		q.setParameter("nome", nome);
		Usuario usuario = null;
		try {
			usuario = (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
		}
		return usuario;
	}
	
}
