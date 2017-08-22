package br.edu.ifpb.tcc.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.tcc.dao.DiscenteDAO;
import br.edu.ifpb.tcc.dao.DocenteDAO;
import br.edu.ifpb.tcc.entity.Discente;
import br.edu.ifpb.tcc.entity.Docente;
import br.edu.ifpb.tcc.entity.Usuario;
import br.edu.ifpb.tcc.facade.LoginController;



@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends GenericBean {
	
	private String usuario;
	private String senha;
	private Usuario usuarioLogado;
	
	private DocenteDAO docenteDAO = new DocenteDAO();
	private DiscenteDAO discenteDAO = new DiscenteDAO();
	private Docente docente;
	private Discente discente;
	
	public String autenticar() {
		String proxView = null;
		LoginController ctr = new LoginController();
		if ((usuarioLogado = ctr.isValido(usuario, senha)) != null) {
			this.setValueOf("#{sessionScope.loginUser}", String.class, usuarioLogado.getEmail());
			docente = docenteDAO.findDocente(usuarioLogado);
			if(docente == null){
				discente = discenteDAO.findDiscente(usuarioLogado);
			}
			proxView = "/index.jsf?faces-redirect=true";
		} else {
			FacesMessage msg = new FacesMessage("Login inválido.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		return proxView;
	}
	
	public String logout() {
		this.invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Discente getDiscente() {
		return discente;
	}

	public void setDiscente(Discente discente) {
		this.discente = discente;
	}

}