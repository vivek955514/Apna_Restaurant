package tech.vkrestro.service;

import java.util.List;

import tech.vkrestro.model.ServiceModulePojo;

public interface ServiceModuleService {
	
	public String validateService( String iconname, String title, String description);
	
	public String addService( String iconname, String title, String description);
	
	public List<ServiceModulePojo> readService();
	public List<ServiceModulePojo> readFourService();
	public ServiceModulePojo readServiceByTitle(String title);
	
	public boolean  deleteService(String Tiltename);
	
	public String updateService( String iconname, String title, String description);

}
