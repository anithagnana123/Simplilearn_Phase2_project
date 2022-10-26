package simplilearn.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplilearn.utils.DatabaseConnection;

/**
 * Servlet implementation class DLLOperations
 */
@WebServlet("/dll")
public class DLLOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try { 
		
		Connection connection = DatabaseConnection.getConnection();
		
//		String sql = "create table department (eid int(5), deptno char(20), deptname varchar(20))";

		String sql = "alter table department add depthead varchar(45)";
		Statement statement = connection.createStatement();
		statement.execute(sql);

		
		statement.close();
		connection.close();
		
	}catch(Exception e) {
	 
	 e.printStackTrace();	
	}
	
  }

	
}
