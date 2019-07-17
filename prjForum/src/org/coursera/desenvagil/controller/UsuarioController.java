package org.coursera.desenvagil.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.coursera.desenvagil.dao.GenericDAO;
import org.coursera.desenvagil.dao.LoginUsuarioDAO;
import org.coursera.desenvagil.model.Usuario;

public class UsuarioController {
	
	public static String validarUsuario(Usuario u) {
		return validarNome(u).concat(validarLogin(u).concat(validarEmail(u)).concat(validarSenha(u)));
	}
	
	private static String validarLogin(Usuario u) {
		if (u.getLogin().length() < 4 || u.getLogin().length() > 15) {
			return "O login precisa ter entre 4 e 15 caracteres.<br>";
		}
		return "";
	}
	
	private static String validarEmail(Usuario u) {
		if (u.getEmail().length() < 6 || u.getEmail().length() > 50) {
			return "O e-mail precisa ter entre 6 e 50 caracteres.<br>";
		}
		return "";
	}
	
	private static String validarSenha(Usuario u) {
		if (u.getSenha().length() < 5 || u.getSenha().length() > 20) {
			return "A senha precisa ter entre 5 e 20 caracteres.<br>";
		}
		return "";
	}
	
	private static String validarNome(Usuario u) {
		if (u.getNome().length() < 5 || u.getNome().length() > 200) {
			return "O nome precisa ter no mínimo 5 caracteres. <br>";
		}
		return "";
	}
	
	public static Usuario logar(Usuario u) {
		Usuario usuario = null;
		LoginUsuarioDAO dao = new LoginUsuarioDAO();
		if (validarLogin(u).length() == 0 && validarSenha(u).length() == 0)
			usuario = dao.logar(u);
		return usuario;
	}
}
