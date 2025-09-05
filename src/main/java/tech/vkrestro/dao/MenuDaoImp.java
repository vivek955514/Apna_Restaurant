package tech.vkrestro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import tech.vkrestro.connection.ConnectionFactory;
import tech.vkrestro.model.MenuPojo;
import tech.vkrestro.model.ServiceModulePojo;

public class MenuDaoImp implements MenuDao {

	Connection con = ConnectionFactory.getUserConnection();

	@Override
	public String saveMenu(String name, String description, double price, String category, String imageUrl) {

		String insertQuery = "insert into menu(name,description,price,category,image_url) values (?,?,?,?,?)";
		try {

			if (con != null) {

				PreparedStatement ps = con.prepareStatement(insertQuery);
				ps.setString(1, name);
				ps.setString(2, description);
				ps.setDouble(3, price);
				ps.setString(4, category);
				ps.setString(5, imageUrl);
				System.out.println("save in db ofter excute");
				return ps.executeUpdate() > 0 ? "SERVICE ADDED" : "null";

			}

			else {

				return null;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<MenuPojo> readAllMenu() {
		// TODO Auto-generated method stub

		String selectUserQuery = " select * from menu";

		try {

			PreparedStatement ps = con.prepareStatement(selectUserQuery);
			List<MenuPojo> users = new ArrayList<>();
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				int idmenu = set.getInt("idmenu");
				String name = set.getString("name");

				String description = set.getString("description");
				double price = set.getDouble("price");
				String category = set.getString("category");

				String imageurl = set.getString("image_url");

				MenuPojo user = new MenuPojo(idmenu, name, description, price, category, imageurl);
				users.add(user);
			}

			return users;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean deleteMenuById(int id) {
		String deleteQuery = "delete from menu where idmenu = ?";

		try {

			PreparedStatement ps = con.prepareStatement(deleteQuery);

			ps.setInt(1, id);

			int a = ps.executeUpdate();

			return a > 0;
		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}
	}

	@Override
	public MenuPojo readmenuById(int id) {
		String selectUserByIdQuery = "select * from menu where idmenu = ?";

		try {
			PreparedStatement ps = con.prepareStatement(selectUserByIdQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				String category = rs.getString("category");

				MenuPojo menu = new MenuPojo();

				menu.setName(name);
				menu.setDescription(description);
				menu.setPrice(price);
				menu.setCategory(category);

				return menu;

			} else {
				return null; // user not found
			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String updatemenuById(String name, String description, double price, String category, int idmenu) {
		String updateQuery = "UPDATE menu SET name = ?, description = ?, price = ?,category=? WHERE idmenu  = ?";

		try {

			if (con != null) {

				PreparedStatement ps = con.prepareStatement(updateQuery);
				ps.setString(1, name);
				ps.setString(2, description);
				ps.setDouble(3, price);
				ps.setString(4, category);
				ps.setInt(5, idmenu);

				int rows = ps.executeUpdate();

				return rows > 0 ? "UPDATED" : "null";

			} else {

				return null;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
	}

}
