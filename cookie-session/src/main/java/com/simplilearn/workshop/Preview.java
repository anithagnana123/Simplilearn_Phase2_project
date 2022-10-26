package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Preview
 */
@WebServlet("/preview")
public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		//read cookie from browser
		Cookie[] userData = request.getCookies();
		String guestName  = userData[0].getValue();

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
		out.println("<head>");
		out.println("<title>preview</title>");
		out.println("</head>");	
		out.println("<body>");
		out.println("<h3> Please confirm your information </h3>");
		out.println("<p> Guest Name: " + guestName + "</p>" );
		out.println("<p> Email Id: " + email + "</p>");
		
		Cookie saveEmailData = new Cookie("email", email);
		response.addCookie(saveEmailData);
		out.println("<form action='savedata' method='post'>");
		out.println("<p> <input type='submit' value ='save data'/></p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
        
	
	
	}

}
