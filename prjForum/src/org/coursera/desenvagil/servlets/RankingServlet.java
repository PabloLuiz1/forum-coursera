package org.coursera.desenvagil.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.coursera.desenvagil.controller.UsuarioController;

@WebServlet("/forum/ranking")
public class RankingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ranking", UsuarioController.listar());
		request.getRequestDispatcher("/forum/ranking.jsp").forward(request, response);
	}
}
