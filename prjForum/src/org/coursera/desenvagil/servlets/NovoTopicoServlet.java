package org.coursera.desenvagil.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.coursera.desenvagil.controller.TopicoController;
import org.coursera.desenvagil.model.Topico;
import org.coursera.desenvagil.model.Usuario;

@WebServlet("/forum/novo-topico")
public class NovoTopicoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("novo-topico.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Topico t = new Topico();
		t.setTitulo(request.getParameter("titulo"));
		t.setConteudo(request.getParameter("conteudo"));
		t.setUsuario((Usuario) request.getSession().getAttribute("usuario"));
		if (TopicoController.inserir(t, usuario).length() == 0) {
			response.sendRedirect("novo-topico");
		}
		else {
			request.setAttribute("erro", TopicoController.inserir(t, usuario));
			request.getRequestDispatcher("novo-topico.jsp").forward(request, response);
		}
	}

}
