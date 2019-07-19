package org.coursera.desenvagil.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.coursera.desenvagil.controller.ComentarioController;
import org.coursera.desenvagil.controller.TopicoController;
import org.coursera.desenvagil.model.Comentario;
import org.coursera.desenvagil.model.Topico;
import org.coursera.desenvagil.model.Usuario;

@WebServlet("/forum/ver-topico")
public class VerTopicoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (request.getParameter("topico").isEmpty() || request.getParameter("topico") == null) {
				response.sendRedirect("../forum");
			}

			else {
				Topico topicoParametro = new Topico();
				Topico topico = null;
				try {
					topicoParametro.setId(Long.parseLong(request.getParameter("topico")));
					topico = TopicoController.consultar(topicoParametro);
					if (topico != null) {
						List<Comentario> comentarios = ComentarioController.listar(topico);
						request.setAttribute("comentarios", comentarios);
					}
					request.setAttribute("mensagem", "Seja o primeiro a comentar.");
				} catch (Exception e) {
					request.setAttribute("erro", "Tópico inválido.");
					request.getRequestDispatcher("/forum/ver-topico.jsp").forward(request, response);
				}
				if (topico == null) {
					request.setAttribute("erro", "Tópico inválido.");
					request.getRequestDispatcher("/forum/ver-topico.jsp").forward(request, response);
				} else {
					request.setAttribute("topico", topico);
					request.getRequestDispatcher("/forum/ver-topico.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			response.sendRedirect("../forum");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Comentario comentario = new Comentario();
		Topico topico = new Topico();
		topico.setId(Long.parseLong(request.getParameter("topico")));
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		comentario.setComentario(request.getParameter("comentario"));
		comentario.setTopico(topico);
		comentario.setUsuario(usuario);
		if (ComentarioController.inserir(comentario).length() != 0) {
			request.setAttribute("erro", ComentarioController.inserir(comentario));
		}
		response.sendRedirect("ver-topico?topico=" + topico.getId());
	}
}
