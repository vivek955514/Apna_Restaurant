package tech.vkrestro.dao;

import java.util.List;

import tech.vkrestro.model.ServiceModulePojo;

public interface ServiceDao {
	
	
	public String saveService(String iconname, String title, String description, String datetime);
	
	public  List<ServiceModulePojo> readAllServices();
	public  List<ServiceModulePojo> readFourServices();
	public  ServiceModulePojo readServicesByTitle(String title);
	
	 public boolean deleteService(String Tiltename);
	 
	

	  public String updateService(String iconname, String title, String description, String datetime);

}
