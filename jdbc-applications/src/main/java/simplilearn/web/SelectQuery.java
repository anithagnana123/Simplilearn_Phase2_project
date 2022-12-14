package simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplilearn.utils.DatabaseConnection;

@WebServlet("/select")
public class SelectQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            
            String query = "Select * from todos;";


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>simplilearn</title>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th> id </th>");
      //    out.println("<th> name </th>");
            out.println("<th> description </th>");
            out.println("<th> target date </th>");
            out.println("<th> is done ? </th>");
            out.println("</tr>");

while ( resultSet.next() ) {
                out.println("<tr>");
                out.println("<td> "+ resultSet.getLong("id") +"</td>");
         //     out.println("<td> "+ resultSet.getString("name") +"</td>");
                out.println("<td> "+ resultSet.getString("description") +"</td>");
                out.println("<td> "+ resultSet.getDate("targetdate") +"</td>");
                out.println("<td> "+ resultSet.getBoolean("isdone") +"</td>");
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
