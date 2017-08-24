package br.edu.ifpb.tcc.facade;

import br.edu.ifpb.tcc.dao.UsuarioDAO;
import br.edu.ifpb.tcc.entity.Usuario;
import br.edu.ifpb.tcc.util.PasswordUtil;



public class LoginController {

public Usuario isValido(String usuario, String senha) {
		
		UsuarioDAO udao = new UsuarioDAO();
		Usuario user = udao.findByLogin(usuario);
		if (user == null  
				|| !PasswordUtil.encryptMD5(senha).equals(user.getSenha())) {
			user = null;
		}
		
		return user;
	}
}