package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/deletestudent")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.setContentType("text/html");
			
		 PrintWriter out = response.getWriter();
			
			    out.println("<form action='test' method='get'>");
				out.println("<h2>Delete a Student</h2>");
				out.println("<table>");
				out.println("<tr>");
			    out.println("<td>Enter the student id</td>");
				out.println("<td> <input type='text' name='student_id'> </td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<br> <br> <input type='submit' value='submit'/>");
				out.println("<input type='hidden' name='operation' value='deletestudent'/>");
			    out.println("</form>");
	
	}

}
