package org.coursera.desenvagil.test;

import org.coursera.desenvagil.controller.ComentarioController;
import org.coursera.desenvagil.model.Comentario;
import org.coursera.desenvagil.model.Topico;

public class Teste {
	public static void main(String[] args) {
		Topico topico = new Topico();
		topico.setId(2);
		if (ComentarioController.listar(topico) == null)
			System.out.println("nulo");
		for (Comentario c : ComentarioController.listar(topico)) {
			System.out.println(c.getComentario());
		}
	}
}
