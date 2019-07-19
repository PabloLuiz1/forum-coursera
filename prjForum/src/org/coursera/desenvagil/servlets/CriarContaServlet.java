package org.coursera.desenvagil.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.coursera.desenvagil.controller.UsuarioController;
import org.coursera.desenvagil.dao.UsuarioDAO;
import org.coursera.desenvagil.model.Usuario;

@WebServlet("/criar-conta")
public class CriarContaServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("criar-conta.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		u.setNome(request.getParameter("nome"));
		u.setLogin(request.getParameter("login"));
		u.setEmail(request.getParameter("email"));
		u.setSenha(request.getParameter("senha"));
		if (UsuarioController.inserir(u).length() == 0) {
			request.setAttribute("sucesso", "Conta criada com sucesso. <a href='login'>Clique aqui para fazer login.</a>");
			request.getRequestDispatcher("criar-conta.jsp").forward(request, response);
		}
		else {
			request.setAttribute("erro", UsuarioController.inserir(u));
			request.getRequestDispatcher("criar-conta.jsp").forward(request, response);
		}
	}
}
