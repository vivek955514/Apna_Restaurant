package tech.vkrestro.dao;

import java.util.ArrayList;
import java.util.List;

import tech.vkrestro.model.ContactPogo;

public interface ContactDao {
    
	  public String saveContact(String name, String email, String subject, String message,String datetime);
	  
	  public List<ContactPogo> readContact();
	  public boolean deleteContact(String email);
}
