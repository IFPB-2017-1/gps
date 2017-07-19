package br.edu.ifpb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.entity.Atividade;
import br.edu.ifpb.entity.Docente;

public class DocenteDAO extends GenericDAO{
	private Docente docente;
	private List<Docente> docentes = new ArrayList<Docente>();
	
	public DocenteDAO(){
		this(PersistenceUtil.getCurrentEntityManager());
	}
	public DocenteDAO(EntityManager em){
		super(em);
	}
	
	//Busca docente pelo Id
		public Docente findId(int id){
			Query q = this.getEntityManager().createQuery("select d from Docente d where d.id = :id");
			q.setParameter("id", id);
			try{
				docente = (Docente) q.getSingleResult();
			}catch(Exception e){
				
			}
			return docente;
		}
		
		//Buscar a lista de docentes de uma determinada disciplina
		public List<Docente> findDocentesDisciplina(String disciplina){
			Query q = this.getEntityManager().createQuery("select d from Docente d where d.disciplina = :disciplina");
			q.setParameter("disciplina", disciplina);
			
			try{
				docentes = q.getResultList();
			}catch(Exception e){
				
			}
			return docentes;
		}
		
		//Buscar um docente pelo nome
		public Docente findDocente(String nome){
			Query q = this.getEntityManager().createQuery("select d from Docente d where d.nome = :nome");
			q.setParameter("nome", nome);
			try{
				docente = (Docente) q.getSingleResult();
			}catch(Exception e){
				
			}
			return docente;
		}
		
}
