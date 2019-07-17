package org.coursera.desenvagil.redirects;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deslogado")
public class ErroDeSessaoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("usuario") != null) {
			response.sendRedirect("/prjForum/forum/");
		}
		else {
			request.getRequestDispatcher("deslogado.jsp").forward(request, response);
		}
	}
}
