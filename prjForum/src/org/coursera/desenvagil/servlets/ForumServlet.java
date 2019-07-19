package org.coursera.desenvagil.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.coursera.desenvagil.controller.TopicoController;
import org.coursera.desenvagil.model.Topico;

@WebServlet("/forum/")
public class ForumServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Topico> topicos = TopicoController.listar();
		request.setAttribute("topicos", topicos);
		request.setAttribute("mensagem", "Nenhum tópico criado ainda.");
		request.getRequestDispatcher("/forum/index.jsp").forward(request, response);
	}
}
