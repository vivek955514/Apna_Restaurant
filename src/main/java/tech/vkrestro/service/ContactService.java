package tech.vkrestro.service;

import java.util.List;

import tech.vkrestro.model.ContactPogo;

public interface ContactService {
	
	public String contactService1(String name , String email, String subject,String message);
	public String contactService2(String name , String email,String subject,String message);
     
	  public List<ContactPogo> readContactService(); 
	  
	  public boolean deleteService(String email);
	       
}
