package tech.vkrestro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tech.vkrestro.connection.ConnectionFactory;

public class AdminLoginDaoImpl implements AdminLoginDao {
 
	  
	 private String result;
	 Connection  con= 	ConnectionFactory.getUserConnection(); 
	@Override
	public String checkAdminLoginData(String username, String password) {
		
		
		try {
			
		   String sql = "select * from adminlogin where username=? and password=?";
	       PreparedStatement  ps = con.prepareStatement(sql);
	       ps.setString(1,username);
	       ps.setString(2,password);
	       
	       ResultSet rs =  ps.executeQuery();
	       
	       if(rs.next()) {
	    	   result= "EXIST";
	       }
	       
	       else {
	    	   result= "NOTEXIST";
	       }
	       
			
			
			
		}  catch(Exception e) {
			result= "FAILED";
			e.printStackTrace();
			
		}
		
		return result;
	}

}
