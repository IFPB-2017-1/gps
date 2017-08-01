package agendamentotcc;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;

import br.edu.ifpb.tcc.dao.DiscenteDAO;
import br.edu.ifpb.tcc.dao.DocenteDAO;
import br.edu.ifpb.tcc.dao.ManagedEMContext;
import br.edu.ifpb.tcc.dao.PersistenceUtil;
import br.edu.ifpb.tcc.dao.TccDAO;
import br.edu.ifpb.tcc.dao.UsuarioDAO;
import br.edu.ifpb.tcc.entity.Discente;
import br.edu.ifpb.tcc.entity.Docente;
import br.edu.ifpb.tcc.entity.Horario;
import br.edu.ifpb.tcc.entity.HorarioEnum;
import br.edu.ifpb.tcc.entity.Tcc;
import br.edu.ifpb.tcc.entity.Usuario;
import br.edu.ifpb.tcc.util.PasswordUtil;

public class CarregaDados {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void main(String[] args) {
		PersistenceUtil.createEntityManagerFactory("agendamentotcc");
    	emf = PersistenceUtil.getEntityManagerFactory();
    	em = emf.createEntityManager();
    	ManagedEMContext.bind(emf, emf.createEntityManager());
    	
//    	cadastraUsuarios();
//    	cadastraDiscentes();
    	cadastraTCC();
    	
    	System.exit(0);
	}
	
	private static void cadastraDiscentes() {
		
		Discente d = new Discente();
		DiscenteDAO discenteDao = new DiscenteDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		d.setCurso("TSI");
		d.setPeriodo(5);
		d.setUsuario(usuarioDao.findByLogin("zevatron@zevatron.com.br"));
		
		discenteDao.beginTransaction();
		discenteDao.insert(d);
		discenteDao.commit();
		
		System.out.println("Discente inserido com sucesso");
		

	}

	private static void cadastraUsuarios() {

		Usuario usuario;
		UsuarioDAO usuarioDao = new UsuarioDAO(em);

		usuario = new Usuario();

		usuario.setAtivo(true);
		usuario.setNome("José Ricardo");
		usuario.setEmail("zevatron@zevatron.com.br");
		usuario.setSenha(PasswordUtil.encryptMD5("123"));

		usuarioDao.beginTransaction();
		usuarioDao.insert(usuario);
		usuarioDao.commit();
	}
	
	private static void cadastraTCC() {

		Tcc tcc;
		TccDAO tccDao = new TccDAO();
		DiscenteDAO discenteDao = new DiscenteDAO();
		DocenteDAO docenteDao = new DocenteDAO();

		tcc = new Tcc();

		tcc.setDiscente(discenteDao.find(1));
		tcc.setOrientador(docenteDao.find(255));
		tcc.setTipo("TCC");
		tcc.setTitulo("Título da Defesa do TCC");

		tccDao.beginTransaction();
		tccDao.insert(tcc);
		tccDao.commit();
		
		System.out.println("TCC cadastrado");
	}
			

}
