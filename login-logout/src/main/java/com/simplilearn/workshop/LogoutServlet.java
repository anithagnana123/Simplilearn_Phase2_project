package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
	    System.out.println("session before invalidate: "+ request.getSession(false));
	    request.getSession(false).invalidate();
	    System.out.println("session after invalidate: "+ request.getSession(false));
		 
	    out.println("<h2>Thank you! You have successfully logged out</h2> ");
	    
	    out.close();
	    
	}
}
