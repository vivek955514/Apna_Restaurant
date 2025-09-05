package tech.vkrestro.service;

import java.time.LocalDateTime;
import java.util.List;

import tech.vkrestro.dao.OrderDaoModuleImp;

import tech.vkrestro.model.OrderPojo;

public class OrderServiceModuleImp implements OrderServiceModule {
	private String result;

	@Override
	public String addService(int menuId, String email, int quentity, double total) {
		try {
			// DAO
			OrderDaoModuleImp orderDaoModuleImp = new OrderDaoModuleImp();

			String datetime = LocalDateTime.now().toString();

			result = orderDaoModuleImp.saveOrder(menuId, email, quentity, total, datetime);
		} catch (Exception e) {

			result = "SERVICE ERROR";

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<OrderPojo> ViewAllOrder() {

		List<OrderPojo> l = null;
		try {

			OrderDaoModuleImp orderDaoModuleImp = new OrderDaoModuleImp();

			l = orderDaoModuleImp.viewAllOrder();

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		return l;
	}

}
