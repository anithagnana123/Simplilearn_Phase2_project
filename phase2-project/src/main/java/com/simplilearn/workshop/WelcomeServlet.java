package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		processRequest(request,response);
		
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("name");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<h2>Hello Admin</h2>");
	    out.println("<h3> Welcome to Learner's academy </h3>");
	   
	    out.println("<hr color='blue' size ='5'/>");
	    out.println("<a href = \"teacher.html\">Click here for Teacher Information</a>");
	    out.println("<br> <br>");
	    out.println("<a href = \"theclass.html\">Click here for Class Information</a>");
	    out.println("<br> <br>");
	    out.println("<a href = \"subject.html\">Click here for Subject Information</a>");
	    out.println("<br> <br>");
	    out.println("<a href = \"student.html\">Click here for Student Information</a>");
	    out.println("<br> <br>");
	    out.println("<a href = \"classsub.html\">Click here for Class Subject Information</a>");
	    out.println("<br> <br>");
	    out.println("<a href = \"classsubteach.html\">Click here for Class Subject Teacher Information</a>");
	   
	    
	    out.println("&nbsp;");
	    out.println("<form action='logout' method='get'>");
	    out.println("<br> <input type='submit' value='logout'/>");
	    out.println("</form>");
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		processRequest(request,response);
		
	}

	
}
