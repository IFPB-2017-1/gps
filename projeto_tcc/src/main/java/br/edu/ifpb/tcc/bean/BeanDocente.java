package br.edu.ifpb.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.edu.ifpb.tcc.dao.DocenteDAO;
import br.edu.ifpb.tcc.dao.PersistenceUtil;
import br.edu.ifpb.tcc.dao.UsuarioDAO;
import br.edu.ifpb.tcc.entity.Docente;
import br.edu.ifpb.tcc.entity.Usuario;
import br.edu.ifpb.tcc.util.PasswordUtil;

@ManagedBean
@RequestScoped
public class BeanDocente {
	private Docente docente;
	private Usuario usuario;
	private String id;
	private String nome;
	private String email;
	private String senha;
	private String confirmeSenha;
	private String endereco;
	private String matricula;
	private String telefone;
	private String disciplina;
	private List<Docente> listaDocentes;

	@PostConstruct
	public void init() {
		this.listaDocentes = new ArrayList<Docente>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Docente> getListaDocentes() {
		return listaDocentes;
	}

	public void setListaDocentes(List<Docente> listaDocentes) {
		this.listaDocentes = listaDocentes;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmeSenha() {
		return confirmeSenha;
	}

	public void setConfirmeSenha(String confirmeSenha) {
		this.confirmeSenha = confirmeSenha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	// Confirmar senha para cadastro
	public boolean confirmarSenha() {
		return this.senha.equals(this.confirmeSenha);
	}

	// Adcionar Mensagens
	public void addMessagem(String mensagem, String severidade) {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(mensagem);

		if (severidade.equals("info")) {
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
		} else if (severidade.equals("error")) {
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		} else if (severidade.equals("warn")) {
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
		}

		fc.addMessage(null, msg);
	}

	// cadastrar usuario
	public String cadastrar() {
		if (confirmarSenha()) {
			int mat = Integer.parseInt(matricula);
			String senhaMD5 = PasswordUtil.encryptMD5(senha);
			usuario = new Usuario(nome, endereco, telefone, email, senhaMD5, "docente", mat);

			UsuarioDAO daoUsuario = new UsuarioDAO(PersistenceUtil.getCurrentEntityManager());
			daoUsuario.beginTransaction();
			daoUsuario.insert(usuario);
			daoUsuario.commit();

			docente = new Docente(usuario);
			DocenteDAO daoDocente = new DocenteDAO(PersistenceUtil.getCurrentEntityManager());
			daoDocente.beginTransaction();
			daoDocente.insert(docente);
			daoDocente.commit();
			
			//this.listaDocentes.add(docente);

			addMessagem("Usu�rio cadastrado com sucesso!", "info");

		} else {
			addMessagem("Senha e confirme senha para cadastro n�o conferem!", "error");
		}
		return "/docente/listarDocentes?faces-redirect=true";
	}

	public void listarDocentes() {
		DocenteDAO dao = new DocenteDAO();
		this.listaDocentes = dao.findAll();
	}
	
	public String editarDocente() {
		System.out.println("Entrou para editar docente");
		DocenteDAO dao = new DocenteDAO();
		int intId;
		
			intId = Integer.parseInt(this.id);
			this.docente = dao.find(intId);
			
			if(this.docente != null){
				this.nome = docente.getUsuario().getNome();
				this.email = docente.getUsuario().getEmail();
				this.endereco = docente.getUsuario().getEndereco();
				this.matricula = docente.getUsuario().getMatricula() + "";
				this.telefone = docente.getUsuario().getTelefone();
				//this.disciplina = docente.getDisciplina();
				
				Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
				flash.put("id", this.id);
				flash.put("nome", this.nome);
				flash.put("email", this.email);
				flash.put("endereco", this.endereco);
				flash.put("matricula", this.matricula);
				flash.put("telefone", this.telefone);
				flash.put("disciplina", this.disciplina);

				return "/docente/editarDocente?faces-redirect=true";
			}
			

		return "/docente/listarDocentes?faces-redirect=true";
	}

	public String atualizar() {
		DocenteDAO dao = new DocenteDAO();
		int intId;
		
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		this.setId((String) flash.get("id"));
		this.setNome((String) flash.get("nome"));
		this.setEmail((String) flash.get("email"));
		this.setEndereco((String) flash.get("endereco"));
		this.setMatricula((String) flash.get("matricula"));
		this.setTelefone((String) flash.get("telefone"));
		this.setDisciplina((String) flash.get("disciplina"));
		
		if(this.id != null){
			intId = Integer.parseInt(this.id);
			this.docente = dao.find(intId);
			this.docente.getUsuario().setNome(this.nome);
			this.docente.getUsuario().setEmail(this.email);
			this.docente.getUsuario().setEndereco(this.endereco);
			this.docente.getUsuario().setMatricula(Integer.parseInt(this.matricula));
			this.docente.getUsuario().setTelefone(this.telefone);
			//this.docente.setDisciplina(this.disciplina);
			dao.beginTransaction();
			dao.update(docente);
			dao.commit();
		}
		
		return "/docente/listarDocentes?faces-redirect=true";
	}
	
	public String excluir(){
		System.out.println("Entrou para excluir docente");
			DocenteDAO dao = new DocenteDAO();
			int intId = Integer.parseInt(this.id);
			this.docente = dao.find(intId);
		
			if(this.docente != null){
				dao.beginTransaction();
				dao.delete(docente);
				dao.commit();
			}
		
		//this.listaDocentes.remove(this.docente);
		return null;
	}

}
