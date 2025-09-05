package tech.vkrestro.service;

import java.time.LocalDateTime;
import java.util.List;

import tech.vkrestro.dao.ContactDaoImpl;
import tech.vkrestro.model.ContactPogo;
import tech.vkrestro.validation.ContactValidationImpl;

public class ContactServiceImpl implements ContactService {
    
	 private String result;
	@Override
	public String contactService1(String name, String email, String subject, String message) {
		    
		
		     try {
		    	 
		    	   ContactValidationImpl    contactValidationImpl    =   new   ContactValidationImpl();
		    	
		           result  = contactValidationImpl.contactValidation(name, email, subject, message);
		     }
		     catch(Exception e){
		    	 
		    	   result ="SERVICE ERROR";
		    	  
		    	   e.printStackTrace();
		     }
		     return result;
	}
	@Override
	public String contactService2(String name, String email, String subject, String message) {
		   
		     try {
		    	 
		    	 
		           String datetime = LocalDateTime.now().toString();
		           ContactDaoImpl  conDao =  new ContactDaoImpl();
		            
		          result =    conDao.saveContact(name, email, subject, message, datetime);
		          System.out.println("saved");
		    
	     }
	     catch(Exception e){
	    	 
	    	   result ="SERVICE ERROR";
	    	  
	    	   e.printStackTrace();
	     }
	     return result;

	}
	@Override
	public List<ContactPogo> readContactService() {
		List<ContactPogo>  l =null;
		   try {
		    	 
		    	 
	            ContactDaoImpl  conDao =  new ContactDaoImpl();
	            
	             l =  conDao.readContact();
	      }
     catch(Exception e){
    	 
    	 
         e.printStackTrace();
    	   return null;
     }
		   return  l;
	}
	
	@Override
	public boolean  deleteService(String email) {
		
		boolean result=false ;
		
	 try {
			  
			  ContactDaoImpl   contactDao=  new ContactDaoImpl();
			 
			  
			 result=   contactDao.deleteContact(email);
			
			 
		   
    }
    catch(Exception e){
   	 
   	  
   	  
   	   e.printStackTrace();
    }
    return result ;
	}

}
