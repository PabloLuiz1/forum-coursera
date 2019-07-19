package org.coursera.desenvagil.controller;

import java.util.List;

import org.coursera.desenvagil.dao.ComentarioDAO;
import org.coursera.desenvagil.model.AcaoDoUsuarioEnum;
import org.coursera.desenvagil.model.Comentario;
import org.coursera.desenvagil.model.Topico;


public class ComentarioController {
	public static String validarComentario (Comentario comentario) {
		return validarTexto(comentario);
	}
	
	private static String validarTexto(Comentario comentario) {
		if (comentario.getComentario().length() == 0 || comentario.getComentario().length() > 1000) {
			return "O comentário deve ter até 1000 caracteres.";
		}
		return "";
	}
	
	public static String inserir(Comentario comentario) {
		if (validarComentario(comentario).length() == 0) {
			try {
				ComentarioDAO dao = new ComentarioDAO();
				dao.inserir(comentario);
				UsuarioController.atualizarPontos(comentario.getUsuario(), AcaoDoUsuarioEnum.NOVOCOMENTARIO);
			} catch (Exception e) {
				return "Erro ao tentar postar um comentário." + e.getMessage();
			}
			return "";
		}
		return validarComentario(comentario);
	}
	
	public static List<Comentario> listar(Topico topico){
		ComentarioDAO dao = new ComentarioDAO();
		List<Comentario> comentarios = null;
		try {
			comentarios = dao.listar(topico);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comentarios;
	}
}
