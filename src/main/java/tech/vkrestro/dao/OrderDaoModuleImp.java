package tech.vkrestro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tech.vkrestro.connection.ConnectionFactory;
import tech.vkrestro.model.OrderPojo;

public class OrderDaoModuleImp implements OrderDaoModule {

	Connection con = ConnectionFactory.getUserConnection();

	@Override
	public String saveOrder(int menuId, String email, int quentity, double total, String datetime) {
		String insertQuery = "insert into orders(menu_id, user_email, quantity, total_price, status,order_date) values (?,?,?,?,?,?)";

		try {

			if (con != null) {

				PreparedStatement ps = con.prepareStatement(insertQuery);
				ps.setInt(1, menuId);
				ps.setString(2, email);
				ps.setInt(3, quentity);
				ps.setDouble(4, total);
				ps.setString(5, "pending");
				ps.setString(6, datetime);

				return ps.executeUpdate() > 0 ? "SERVICE ADDED" : "null";

			} else {

				return null;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
	}

	@Override
	public List<OrderPojo> viewAllOrder() {

		String selectUserQuery = "select * from orders order by order_date DESC";
		List<OrderPojo> users = new ArrayList<>();
		try {

			PreparedStatement ps = con.prepareStatement(selectUserQuery);

			ResultSet set = ps.executeQuery();
			while (set.next()) {

				int menu_id = set.getInt("menu_id");
				String email = set.getString("user_email");
				int quantity = set.getInt("quantity");
				double total_price = set.getDouble("total_price");
				String status = set.getString("status");
				String order_date = set.getString("order_date");

				OrderPojo user = new OrderPojo();
				user.setMenuId(menu_id);
				user.setUserEmail(email);
				user.setQuantity(quantity);
				user.setTotalPrice(total_price);
				user.setStatus(status);
				user.setDatetime(order_date);
				users.add(user);

			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		return users;
	}

}
