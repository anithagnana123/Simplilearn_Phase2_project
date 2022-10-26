package simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplilearn.utils.DatabaseConnection;

@WebServlet("/stored-procedure")
public class StoredProcedure extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            
            CallableStatement statement = connection.prepareCall("{call get_students()}");
            
            
            ResultSet resultSet = statement.executeQuery();
            
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>simplilearn</title>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th> id </th>");
            out.println("<th> First Name </th>");
            out.println("<th> Last Name </th>");
            out.println("<th> Age </th>");
            out.println("</tr>");
        
            while ( resultSet.next() ) {
                out.println("<tr>");
                out.println("<td> "+ resultSet.getInt("id") +"</td>");
                out.println("<td> "+ resultSet.getString("first_name") +"</td>");
                out.println("<td> "+ resultSet.getString("last_name") +"</td>");
                out.println("<td> "+ resultSet.getInt("age") +"</td>");
                out.println("</tr>");
            }
            
            out.println("</body>");
            out.println("</html>");
            
            resultSet.close();
            statement.close();
            connection.close();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
