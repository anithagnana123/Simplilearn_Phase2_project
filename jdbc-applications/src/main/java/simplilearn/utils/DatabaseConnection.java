package simplilearn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	//Connection is an Interface from java.sql
	public static Connection getConnection()  {
	
		Connection connection = null;
		
		String driver_class_name = "com.mysql.cj.jdbc.Driver";
		String user ="root";
		String password ="123456";
		String url = "jdbc:mysql://localhost:3306/learners_academy?allowPublicKeyRetrieval=true&useSSL=false";
		
		try {
			//step #1 : load a driver class
			Class.forName(driver_class_name);
		
			//step #2: establish  the connection
			connection = DriverManager.getConnection(url,user,password);
		} catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(SQLException e) {
        	 System.out.println(e.getMessage());
        }
		
        return connection;
    
	}
}
