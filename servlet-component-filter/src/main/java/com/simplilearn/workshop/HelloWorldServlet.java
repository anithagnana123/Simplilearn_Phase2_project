package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
	
@Override	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        System.out.println("Hello World --- > Servlet");
	        
	        response.setContentType("text/html"); //MIME type
	        
	        PrintWriter out = response.getWriter();
	        
	        Date today = new Date();
	   
	        out.println("<!DOCTYPE html");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>");
	        out.println("Hello World - - -> Servlet");
	   	    out.println("</h1>");
	   	    out.println("<h2>");
	        out.println("Today's date is " + today);
	   	    out.println("</h2>");
	        out.println("</body>");
	        out.println("</html>");
	        
	        
	    }

}
