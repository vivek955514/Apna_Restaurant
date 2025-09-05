package tech.vkrestro.service;

import java.time.LocalDateTime;
import java.util.List;

import tech.vkrestro.dao.BookingTableDaoImpl;
import tech.vkrestro.dao.ContactDaoImpl;
import tech.vkrestro.model.BookingPojo;
import tech.vkrestro.model.ContactPogo;
import tech.vkrestro.validation.BookingTableValidationImpl;

public class BookingTableServiceImp implements BookingTableService {
	 private String result;
	@Override
	public String bookingTableService1(String name, String email, int people, String message) {
	

	     try {
	    	 
	          BookingTableValidationImpl      bookingTableValidationImpl = new  BookingTableValidationImpl();
	    	
	           result  =   bookingTableValidationImpl.bookingTableValidation(name, email, people, message);
	     }
	     catch(Exception e){
	    	 
	    	   result ="SERVICE ERROR";
	    	  
	    	   e.printStackTrace();
	     }
	     return result;
	}
	@Override
	public String bookingTableService2(String name, String email, String datetime, int people, String message) {
		
		
		 try {
	    	 
	    	 
	   BookingTableDaoImpl    bookingTableDaoImpl   = new BookingTableDaoImpl();
	   
	    result =    bookingTableDaoImpl.saveBooking(name, email, datetime, people, message);
	          
	            
	         
	          System.out.println("saved");
	    
   }
   catch(Exception e){
  	 
  	   result ="SERVICE ERROR";
  	  
  	   e.printStackTrace();
   }
   return result;

		 
		
	}
	@Override
	public List<BookingPojo> ViewAllBooking() {
		
		List<BookingPojo>  l =null;
		   try {
		    	 
		  BookingTableDaoImpl   bookingTableDaoImpl  =  new BookingTableDaoImpl();
		  
	            
	             l =  bookingTableDaoImpl.viewAllBooking();
	             
	      }
  catch(Exception e){
 	 
 	 
      e.printStackTrace();
 	   return null;
  }
		   return  l;
	}

}
