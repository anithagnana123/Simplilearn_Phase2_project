package simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplilearn.utils.DatabaseConnection;

/**
 * Servlet implementation class InsertQuery
 */
@WebServlet("/insert")
public class InsertQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            
            String sql = "INSERT INTO todos (id,description) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, "4");
            statement.setString(2, "English");
            
            statement.executeUpdate();
            
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            out.println("<h1>Inserted Record<h1>");
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }

	
}
