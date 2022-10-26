package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(password.equals("simplilearn")) {
			session.setAttribute("user", username);
			response.sendRedirect("welcome?name=" + username);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			out.println("<font color='red'>Password is wrong. </font>");
			rd.include(request,response);
			
			out.close();
			
			
		}
		
	}

}
