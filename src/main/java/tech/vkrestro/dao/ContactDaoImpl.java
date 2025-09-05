package tech.vkrestro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import tech.vkrestro.connection.ConnectionFactory;
import tech.vkrestro.model.ContactPogo;

public class ContactDaoImpl implements ContactDao {
	  
	 
	
	 Connection  con= 	ConnectionFactory.getUserConnection(); 
	@Override
	public String saveContact(String name, String email, String subject, String message, String datetime) {
		
		    
		            String  insertQuery = "insert into contact(name,email,subject,message,datetime) values (?,?,?,?,?)";
		
		         try {
		        	 
		        	if(con!=null) {
		        		 
		        		PreparedStatement  ps =   con.prepareStatement(insertQuery);
		        		ps.setString(1,name );
		        		ps.setString(2,email );
		        		ps.setString(3,subject );
		        		ps.setString(4,message);
		        		ps.setString(5,datetime );
		        		
		        		return ps.executeUpdate() > 0 ? "SAVED" : "null";
		        	
		        		   
		        	}
		        	else {
		        		
		        		System.out.println("no connection found!!!");
		        		
						return null;
		        	}
		        	 
		        	 
		         } catch(Exception e) {
		        	   
		        	     e.printStackTrace();
		        	     return null;
		        	     
		         }
	}
	@Override
	   public List<ContactPogo> readContact() {
		
		
		
		String selectUserQuery = " select * from contact";

		try {

			PreparedStatement ps = con.prepareStatement(selectUserQuery);
			List<ContactPogo> users = new ArrayList<>();
			ResultSet set = ps.executeQuery();
			while (set.next()) {
                String name = set.getString("name");
				String email = set.getString("email");
				String subject = set.getString("subject");
				String message = set.getString("message");
				String datetime = set.getString("datetime");

				 ContactPogo user =	new  ContactPogo( name ,email,subject,message,datetime);
				 users.add(user);
	          } 
			return users;
}
		catch(Exception e) {
	   
                 e.printStackTrace();
                  return null;
             }
		
}
	@Override
	public  boolean deleteContact(String email) {
		
	        String deleteQuery = "delete from contact where email = ? ";
	       

			try {

				PreparedStatement ps = con.prepareStatement(deleteQuery);

				ps.setString(1, email);
				
				int a = ps.executeUpdate();
				
		

				return a > 0;
			}
			catch (Exception e) {
				
				e.printStackTrace();
				return false;

			}

		}
	}
