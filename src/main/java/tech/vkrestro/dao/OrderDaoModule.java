package tech.vkrestro.dao;

import java.util.List;


import tech.vkrestro.model.OrderPojo;

public interface OrderDaoModule {
	
	public String saveOrder(int menuId, String email, int quentity, double total, String datetime);
	
	 public List<OrderPojo> viewAllOrder();

}
