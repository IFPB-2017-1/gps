import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;

import br.edu.ifpb.tcc.dao.PersistenceUtil;
import br.edu.ifpb.tcc.dao.TccDAO;
import br.edu.ifpb.tcc.entity.Tcc;

public class TccDaoTest {
	
	//Supoe que esses serao os campos listados na tela dos tccs
	@Test(expected = RuntimeException.class)
	public static void listarTccs(TccDAO dao){
		List<Tcc> resultList = dao.findAll();
		for (Tcc tcc : resultList) {
			System.out.println("Matrícula: " + tcc.getDiscente().getUsuario().getMatricula());
			System.out.println("Nome do Aluno: " + tcc.getDiscente().getUsuario().getNome());
			System.out.println("Título do Tcc: " + tcc.getTitulo());
			System.out.println("Orientador: " + tcc.getOrientador().getUsuario().getNome());
			System.out.println("Data: " + tcc.getDefesas().get(0).getData());
		}
	}
	
	//Campos que serao mostrados na tela de edicao de cada tcc
	@Test(expected = RuntimeException.class)
	public static void mostrarTcc(TccDAO dao, int id) {
		Tcc tcc = dao.find(id);
		System.out.println("Matrícula: " + tcc.getDiscente().getUsuario().getMatricula());
		System.out.println("Nome do Aluno: " + tcc.getDiscente().getUsuario().getNome());
		System.out.println("Título do Tcc: " + tcc.getTitulo());
		System.out.println("Orientador: " + tcc.getOrientador().getUsuario().getNome());
		System.out.println("Data: " + tcc.getDefesas().get(0).getData());
		System.out.println("Tipo: " + tcc.getArquivoTCC());
		System.out.println("Documento (Link/PDF): " + tcc.getArquivoTCC());
	}
	
	//Edicao do TCC
	@Test(expected = RuntimeException.class)
	public static void editarTcc(TccDAO dao, int id) {
		Tcc tcc = dao.find(id);
		dao.beginTransaction();
		tcc.setTitulo("GLOCAL ARTS - Marketplace de Artes Plásticas");
		dao.update(tcc);
		dao.commit();
		System.out.println("Alterado.");
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory("agendamentotcc");
    	EntityManager em = emf.createEntityManager();
		TccDAO dao = new TccDAO(em);
		
//		System.out.println("Listagem de todos os TCCs:");
//		listarTccs(dao);
//		System.out.println("TCC Individual:");
//		mostrarTcc(dao, 2);
//		System.out.println("Edicao do TCC:");
//		editarTcc(dao, 2);
	}

}
