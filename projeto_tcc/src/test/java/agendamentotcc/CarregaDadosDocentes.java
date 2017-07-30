package agendamentotcc;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;

import br.edu.ifpb.tcc.dao.DocenteDAO;
import br.edu.ifpb.tcc.dao.ManagedEMContext;
import br.edu.ifpb.tcc.dao.PersistenceUtil;
import br.edu.ifpb.tcc.dao.UsuarioDAO;
import br.edu.ifpb.tcc.entity.Docente;
import br.edu.ifpb.tcc.entity.Horario;
import br.edu.ifpb.tcc.entity.HorarioEnum;
import br.edu.ifpb.tcc.entity.Usuario;
import br.edu.ifpb.tcc.util.PasswordUtil;

public class CarregaDadosDocentes {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void main(String[] args) {
		PersistenceUtil.createEntityManagerFactory("agendamentotcc");
    	emf = PersistenceUtil.getEntityManagerFactory();
    	em = emf.createEntityManager();
    	ManagedEMContext.bind(emf, emf.createEntityManager());
    	
//    	cadastraUsuarios();
//    	cadastraDocentes();
//    	cadastraDocentesHorarios();
    	
    	System.exit(0);
	}
	
	private static void cadastraDocentesHorarios() {
		
		Usuario usuario;
		Docente docente;
		DocenteDAO docenteDao = new DocenteDAO(em);
		UsuarioDAO usuarioDao = new UsuarioDAO(em);
		Scanner arq = null;
		String linha;
		String[] colunas;
		String local=null;
		
		try {
			arq = new Scanner(new File("horario.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("arquivo inexistente");
			System.out.println(e.getMessage());
			System.exit(0); // sai do programa
		}
		while (arq.hasNextLine()){
			
			linha = arq.nextLine();
			colunas = linha.split(";");
			// esse if foi usado prar tratar casos em que a linha tinha apenas 10 colunas.
			if(colunas.length==10)
				local = colunas[9];
			else if(colunas.length==11)
				local = colunas[10];
			
			usuario = usuarioDao.findByName(colunas[0]);
			
			if (usuario != null ){
				
				docente = docenteDao.findDocente(usuario);
				
				if(docente == null){
					docente = new Docente();
					docente.setUsuario(usuario);
				}
				
				Horario horario = new Horario();
				horario.setCurso(colunas[1]);
				horario.setPeriodo(colunas[2]);
				horario.setDisciplina(colunas[3]);
				horario.setTurma(colunas[4]);
				horario.setCodigoHorario(HorarioEnum.valueOf(colunas[5]));
				
				horario.setDiaSemana(colunas[8]);
				horario.setLocalizacao(local);
				
				horario.setDocente(docente);
				docente.addHorario(horario);
				 
				docenteDao.beginTransaction();
				docenteDao.insert(docente);
				docenteDao.commit();
								
			}
				
		}
		arq.close();
		System.out.println("fim da leitura do arquivo. Inclusão da lista de Horários dos Docentes.");
	}
	
	private static void cadastraDocentes() {
		
		Usuario usuario;
		Docente docente;
		DocenteDAO docenteDao = new DocenteDAO(em);
		UsuarioDAO usuarioDao = new UsuarioDAO(em);
		Scanner arq = null;
		String linha;
		String[] colunas;
		String local=null;

		try {
			arq = new Scanner(new File("horario.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("arquivo inexistente");
			System.out.println(e.getMessage());
			System.exit(0); // sai do programa
		}
		while (arq.hasNextLine()){
			linha = arq.nextLine();
			colunas = linha.split(";");
			
			usuario = usuarioDao.findByName(colunas[0]);
			
			if (usuario != null ){
				
				docente = docenteDao.findDocente(usuario);
				
				if(docente == null){
					docente = new Docente();
					docente.setUsuario(usuario);
				}
				
				docenteDao.beginTransaction();
				docenteDao.insert(docente);
				docenteDao.commit();
			}
		}
		arq.close();
		System.out.println("fim da leitura do arquivo. Inclusão dos Docentes.");
	}

	private static void cadastraUsuarios() {
		
		Usuario usuario;
		UsuarioDAO usuarioDao = new UsuarioDAO(em);
//		DocenteDAO docenteDao = new DocenteDAO();
		Scanner arq = null;
		String linha;
		String[] colunas;
		LocalDate periodoInicio = LocalDate.of(2017, Month.APRIL, 24);
		LocalDate periodoFim = LocalDate.of(2017, Month.SEPTEMBER, 17);
		
		try {
			arq = new Scanner(new File("horario.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("arquivo inexistente");
			System.out.println(e.getMessage());
			System.exit(0); // sai do programa
		}
		while (arq.hasNextLine()){
			linha = arq.nextLine();
			colunas = linha.split(";");
			
			
			usuario = usuarioDao.findByName(colunas[0]);
			
			if (usuario == null){
				usuario = new Usuario();
				
				usuario.setAtivo(true);
				usuario.setNome(colunas[0]);
				usuario.setEmail(colunas[0].replaceAll(" ", "").toLowerCase());
				usuario.setSenha(PasswordUtil.encryptMD5("123"));
					
				usuarioDao.beginTransaction();
				usuarioDao.insert(usuario);
				usuarioDao.commit();
			}
			
		}
		arq.close();
		System.out.println("fim da leitura do arquivo. Inclusão dos Usuários.");
	}

}
