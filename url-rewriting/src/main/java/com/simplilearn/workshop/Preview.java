package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Preview
 */
@WebServlet("/preview")
public class Preview extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String guestName = request.getParameter("guestName");
        String email = request.getParameter("email");
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>preview</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3> please confirm your informations </h3>");
        out.println("<p> Guest Name: " + guestName + " </p>");
        out.println("<p> Email Id: " + email + "</p>");
        
        String queryString = "guestName" + guestName + "&email=" + email;
        
        out.println("<a href='savedata?" + queryString +"'>Save Data</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
