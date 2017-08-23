package br.edu.ifpb.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.edu.ifpb.tcc.dao.DiscenteDAO;
import br.edu.ifpb.tcc.dao.PersistenceUtil;
import br.edu.ifpb.tcc.dao.UsuarioDAO;
import br.edu.ifpb.tcc.entity.Discente;
import br.edu.ifpb.tcc.entity.Usuario;
import br.edu.ifpb.tcc.util.PasswordUtil;

@ManagedBean
@RequestScoped
public class BeanDiscente {
	private Discente discente;
	private Usuario usuario;
	private String id;
	private String nome;
	private String email;
	private String senha;
	private String confirmeSenha;
	private String endereco;
	private String matricula;
	private String telefone;
	private String curso;
	private String periodo;
	private List<Discente> listaDiscentes;

	@PostConstruct
	public void init() {
		this.listaDiscentes = new ArrayList<Discente>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Discente> getListaDiscentes() {
		return listaDiscentes;
	}

	public void setListaDiscentes(List<Discente> listaDiscentes) {
		this.listaDiscentes = listaDiscentes;
	}

	public Discente getDiscente() {
		return discente;
	}

	public void setDiscente(Discente discente) {
		this.discente = discente;
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
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

	// cadastrar discente
	public String cadastrar() {

		if (confirmarSenha()) {
			int mat = Integer.parseInt(matricula);
			String senhaMD5 = PasswordUtil.encryptMD5(senha);
			usuario = new Usuario(nome, endereco, telefone, email, senhaMD5, "discente", mat);

			UsuarioDAO daoUsuario = new UsuarioDAO(PersistenceUtil.getCurrentEntityManager());
			daoUsuario.beginTransaction();
			daoUsuario.insert(usuario);
			daoUsuario.commit();

			int per = Integer.parseInt(periodo);
			discente = new Discente(usuario, curso, per);

			DiscenteDAO daoDiscente = new DiscenteDAO(PersistenceUtil.getCurrentEntityManager());
			daoDiscente.beginTransaction();
			daoDiscente.insert(discente);
			daoDiscente.commit();

			// this.listaDiscentes.add(discente);

			addMessagem("Usu�rio cadastrado com sucesso!", "info");

		} else {
			addMessagem("Senha e confirme senha para cadastro n�o conferem!", "error");
		}

		return "/discente/listarDiscentes?faces-redirect=true";
	}

	public void listarDiscentes() {
		DiscenteDAO dao = new DiscenteDAO();
		this.listaDiscentes = dao.findAll();
	}

	public String editarDiscente() {
		DiscenteDAO dao = new DiscenteDAO();
		int intId;

		if (this.id != null) {
			intId = Integer.parseInt(this.id);
			this.discente = dao.find(intId);

			if (this.discente != null) {
				this.nome = discente.getUsuario().getNome();
				this.email = discente.getUsuario().getEmail();
				this.endereco = discente.getUsuario().getEndereco();
				this.matricula = discente.getUsuario().getMatricula() + "";
				this.telefone = discente.getUsuario().getTelefone();
				this.curso = discente.getCurso();
				this.periodo = discente.getPeriodo() + "";

				Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
				flash.put("id", this.id);
				flash.put("nome", this.nome);
				flash.put("email", this.email);
				flash.put("endereco", this.endereco);
				flash.put("matricula", this.matricula);
				flash.put("telefone", this.telefone);
				flash.put("curso", this.curso);
				flash.put("periodo", this.periodo);

				return "editarDiscente?faces-redirect=true";
			}

		}
		return "editarDiscente?faces-redirect=true";
	}

	public String atualizar() {
		DiscenteDAO dao = new DiscenteDAO();
		int intId;

		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		this.setId((String) flash.get("id"));
		this.setNome((String) flash.get("nome"));
		this.setEmail((String) flash.get("email"));
		this.setEndereco((String) flash.get("endereco"));
		this.setMatricula((String) flash.get("matricula"));
		this.setTelefone((String) flash.get("telefone"));
		this.setCurso((String) flash.get("curso"));
		this.setPeriodo((String) flash.get("periodo"));

		if (this.id != null) {
			intId = Integer.parseInt(this.id);
			this.discente = dao.find(intId);
			this.discente.getUsuario().setNome(this.nome);
			this.discente.getUsuario().setEmail(this.email);
			this.discente.getUsuario().setEndereco(this.endereco);
			this.discente.getUsuario().setMatricula(Integer.parseInt(this.matricula));
			this.discente.getUsuario().setTelefone(this.telefone);
			this.discente.setCurso(this.curso);
			this.discente.setPeriodo(Integer.parseInt(this.periodo));

			dao.beginTransaction();
			dao.update(discente);
			dao.commit();
		}

		return "/discente/listarDiscentes?faces-redirect=true";
	}

	public String excluir(){
		DiscenteDAO dao = new DiscenteDAO();
		int intId = Integer.parseInt(this.id);
		this.discente = dao.find(intId);
		
		System.out.println("Id de discente para exclusao: "+this.id);
		
		dao.beginTransaction();
		dao.delete(discente);
		dao.commit();

		//this.listaDiscentes.remove(this.discente);
		return null;
	}

}
