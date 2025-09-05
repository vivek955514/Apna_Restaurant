package tech.vkrestro.service;

import java.util.List;

import tech.vkrestro.model.MenuPojo;
import tech.vkrestro.model.ServiceModulePojo;

public interface MenuModuleService {
	
	public String validateMenu(String name, String description, String category);
	
	public String addMenu( String name, String description , double price ,String category,String image_url );
	
	public List<MenuPojo> readMenu();
	
	public MenuPojo readMenuById(int id);
	
	public boolean  deleteMenu(int id);
	


public 	String updateMenu(String name, String description, double price, String category, int idmenu);
	
	

}
