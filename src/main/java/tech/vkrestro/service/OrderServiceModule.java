package tech.vkrestro.service;

import java.util.List;


import tech.vkrestro.model.OrderPojo;

public interface OrderServiceModule {
	
	
	public String addService(int menuId, String email, int quentity, double total);
    
	 public List<OrderPojo> ViewAllOrder(); 

	
	


}
