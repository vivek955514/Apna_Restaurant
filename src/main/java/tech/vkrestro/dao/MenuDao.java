package tech.vkrestro.dao;

import java.util.List;

import tech.vkrestro.model.MenuPojo;
import tech.vkrestro.model.ServiceModulePojo;

public interface MenuDao {
	
	public String saveMenu(String name, String description, double price,String  category, String imageUrl);
	public  List<MenuPojo> readAllMenu(); 
	
	public  MenuPojo readmenuById(int id); 
	
	 public boolean deleteMenuById(int id);
	 
	 public String updatemenuById(String name, String description, double price, String category, int idmenu);
	      
}
