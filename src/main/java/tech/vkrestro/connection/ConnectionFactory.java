package tech.vkrestro.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {
	
	
	public static Connection getUserConnection() {
		
		  try {
		    	   Driver driver = new Driver();
		    	   
			    	DriverManager.registerDriver(driver);
			    	
			    	String url = "jdbc:mysql://localhost:3306/restro";
			    	String user= "root";
			    	String pass = "root";
			    	return DriverManager.getConnection(url, user, pass);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				return null;
			}
	}

}   
