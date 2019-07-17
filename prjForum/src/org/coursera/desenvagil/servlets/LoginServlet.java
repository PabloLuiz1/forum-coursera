package org.coursera.desenvagil.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.coursera.desenvagil.controller.UsuarioController;
import org.coursera.desenvagil.dao.LoginUsuarioDAO;
import org.coursera.desenvagil.model.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginUsuarioDAO dao = new LoginUsuarioDAO();
		Usuario u = new Usuario();
		u.setLogin(request.getParameter("login"));
		u.setSenha(request.getParameter("senha"));
		Usuario usuario = UsuarioController.logar(u);
		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			session.setMaxInactiveInterval(30*60);
			response.sendRedirect("forum/");
		}
		else {
			request.setAttribute("erro", "Login e/ou senha inválidos.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
