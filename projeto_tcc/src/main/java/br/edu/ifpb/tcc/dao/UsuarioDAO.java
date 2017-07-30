package br.edu.ifpb.tcc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.tcc.entity.Docente;
import br.edu.ifpb.tcc.entity.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Integer>{
	private Usuario usuario;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioDAO(){
		this(PersistenceUtil.getCurrentEntityManager());
	}
	
	public UsuarioDAO(EntityManager em){
		super(em);
	}
	
	//Busca o usuario que possue o Id informado
	public Usuario findId(int id){
		Query q = this.getEntityManager().createQuery("select u from Usuario u where u.id = :id");
		q.setParameter("id", id);
		try{
			usuario = (Usuario) q.getSingleResult();
		}catch(Exception e){
			
		}
		return usuario;
	}
	
	//Busca o usuario que possue o email informado.
	public Usuario findEmail(String email){
		Query q = this.getEntityManager().createQuery("select u from Usuario u where email = :email");
		q.setParameter("email", email);
		try{
			usuario = (Usuario) q.getSingleResult();
		}catch (Exception e){
			
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
	
	//Busca o usuario que possua a matricula informada.
	public Usuario findMatricula(int mat){
		Query q = this.getEntityManager().createQuery("select u from Usuario u where u.matricula = :mat");
		q.setParameter("mat", mat);
		try{
			usuario = (Usuario) q.getSingleResult();
		}catch(Exception e){
			
		}
		return usuario;
	}
	
	//Busca todos os usuarios que possuem a palavra informada em seu nome.
	public List<Usuario> findNomes(String nome){
		Query q = this.getEntityManager().createQuery("select u from Usuario u where LOWER(u.nome) LIKE :nome");
		q.setParameter("nome", "%" + nome + "%");
		try{
			usuarios = q.getResultList();
		}catch (Exception e){
			
		}
		return usuarios;
	}

}
