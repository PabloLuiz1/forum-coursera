package org.coursera.desenvagil.controller;

import java.util.List;

import org.coursera.desenvagil.dao.TopicoDAO;
import org.coursera.desenvagil.dao.UsuarioDAO;
import org.coursera.desenvagil.model.AcaoDoUsuarioEnum;
import org.coursera.desenvagil.model.Topico;
import org.coursera.desenvagil.model.Usuario;

public class TopicoController {
	public static String validarTopico(Topico t, Usuario usuario) {
		return validarTitulo(t).concat(validarConteudo(t)).concat(UsuarioController.validarUsuario(usuario));
	}

	private static String validarTitulo(Topico t) {
		if (t.getTitulo().length() < 2 || t.getTitulo().length() > 80) {
			return "O título do tópico deve ter entre 2 e 80 caracteres.";
		}
		return "";
	}

	private static String validarConteudo(Topico t) {
		if (t.getConteudo().length() < 2 || t.getConteudo().length() > 80) {
			return "O conteúdo do tópico deve ter entre 2 e 1000 caracteres.";
		}
		return "";
	}

	public static String inserir(Topico t, Usuario u) {
		if (validarTopico(t, u).length() == 0) {
			TopicoDAO dao = new TopicoDAO();
			try {
				dao.inserir(t);
				UsuarioController.atualizarPontos(u, AcaoDoUsuarioEnum.NOVOTOPICO);
			} catch (Exception e) {
				return "Erro ao tentar criar um tópico. " + e.getMessage();
			}
			return "";
		}
		return validarTopico(t, u);
	}

	public static Topico consultar(Topico t) {
		Topico topico = null;
		try {
			TopicoDAO dao = new TopicoDAO();
			topico = dao.consultar(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topico;
	}
	
	public static List<Topico> listar(){
		List<Topico> topicos = null;
		try {
			TopicoDAO dao = new TopicoDAO();
			topicos = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicos;
	}
}
