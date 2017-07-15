import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.edu.ifpb.tcc.dao.DiscenteDAO;
import br.edu.ifpb.tcc.dao.PersistenceUtil;
import br.edu.ifpb.tcc.dao.TccDAO;
import br.edu.ifpb.tcc.dao.UsuarioDAO;
import br.edu.ifpb.tcc.entity.Discente;
import br.edu.ifpb.tcc.entity.Tcc;
import br.edu.ifpb.tcc.entity.Usuario;

public class Teste {

    public static void main(String[] args) {
    	
    	EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory("agendamentotcc");
    	EntityManager em = emf.createEntityManager();
    	
//    	UsuarioDAO usuario = new UsuarioDAO(em);
//    	DiscenteDAO discente = new DiscenteDAO(em);
    	TccDAO tcc = new TccDAO(em);
//    	usuario.beginTransaction();
//
//    	Usuario u = new Usuario("nome", "endereco", "fone", "email", "senha", "perfil", 123);
//    	Discente dis = new Discente(u, "curso", 1);
//    	Tcc carga = new Tcc("titulo", dis, "tipo");
//
//        usuario.insert(u);
//        discente.insert(dis);
//        tcc.insert(carga);
//        tcc.commit();
    	List<Tcc> resultList = tcc.findAll();
    	for (Tcc tcc2 : resultList) {
			System.out.println(tcc2.getId());
		}

    }

}
