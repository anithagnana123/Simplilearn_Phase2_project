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
@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.setContentType("text/html");
			
		 PrintWriter out = response.getWriter();
			
			    out.println("<form action='test' method='get'>");
				out.println("<h2>Add a Student</h2>");
				out.println("<table>");
				out.println("<tr>");
			    out.println("<td>Enter the first name</td>");
				out.println("<td> <input type='text' name='firstName'> </td>");
				out.println("</tr>");
				out.println("<tr>");
			    out.println("<td>Enter the last name</td>");
				out.println("<td> <input type='text' name='lastName'> </td>");
				out.println("</tr>");
				out.println("<td>Enter the D.O.B</td>");
				out.println("<td> <input type='text' name='dateOfBirth'> </td>");
				out.println("</tr>");
				out.println("</tr>");
				out.println("<td>Enter the Class</td>");
				out.println("<td> <input type='text' name='standard'> </td>");
				out.println("</tr>");
				out.println("</tr>");
				out.println("<td>Enter the section</td>");
				out.println("<td> <input type='text' name='class_sec'> </td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<br> <br> <input type='submit' value='submit'/>");
				out.println("<input type='hidden' name='operation' value='addstudent'/>");
			    out.println("</form>");
	
	}

}
