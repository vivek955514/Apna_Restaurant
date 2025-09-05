package tech.vkrestro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tech.vkrestro.connection.ConnectionFactory;
import tech.vkrestro.model.BookingPojo;
import tech.vkrestro.model.ContactPogo;

public class BookingTableDaoImpl implements BookingTableDao {
	 Connection  con= 	ConnectionFactory.getUserConnection(); 
	@Override
	
	public String saveBooking(String name, String email, String datetime, int people, String message) {
	
		   String  insertQuery = "insert into booking(name,email,datetime,people,special_request) values (?,?,?,?,?)";
			
	         try {
	        	 
	        	if(con!=null) {
	        		 
	        		PreparedStatement  ps =   con.prepareStatement(insertQuery);
	        		ps.setString(1,name );
	        		ps.setString(2,email );
	        		ps.setString(3,datetime );
	        		ps.setInt(4, people);
	        		ps.setString(5,message);
	        		
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
	public List<BookingPojo> viewAllBooking() {
		
		
		String selectUserQuery = "select * from booking order by datetime DESC";
		List<BookingPojo> users = new ArrayList<>();
		try {

			PreparedStatement ps = con.prepareStatement(selectUserQuery);
			
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				
				 int booking_id = set.getInt("booking_id");
                String name = set.getString("name");
				String email = set.getString("email");
				String datetime = set.getString("datetime");
				int people = set.getInt("people");
				String special_request = set.getString("special_request");

				BookingPojo  user =	new  BookingPojo(booking_id,name,email,datetime,people,special_request );
				 users.add(user);
	          } 
			
			
		
}
		catch(Exception e) {
	   
                 e.printStackTrace();
                  return null;
             }
		return users;
	
	}
	
	
	
	     
	           

}
