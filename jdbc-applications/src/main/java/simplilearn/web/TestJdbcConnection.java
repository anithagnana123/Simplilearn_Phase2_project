package simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplilearn.utils.DatabaseConnection;

/**
 * Servlet implementation class TestJdbcConnection
 */
@WebServlet("/test-connection")
public class TestJdbcConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			Connection connection = DatabaseConnection.getConnection();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<h1>Established Connection</h1>");
			out.close();
		} catch(Exception e ) {
			System.out.println(e.getMessage());
		}
		
	}

}
