package tech.vkrestro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tech.vkrestro.connection.ConnectionFactory;
import tech.vkrestro.model.ContactPogo;
import tech.vkrestro.model.ServiceModulePojo;

public class ServiceDaoImpl implements ServiceDao {

	Connection con = ConnectionFactory.getUserConnection();

	@Override

	public String saveService(String iconname, String title, String description, String datetime) {

		String insertQuery = "insert into service(iconname, title,  description,  datetime) values (?,?,?,?)";

		try {

			if (con != null) {

				PreparedStatement ps = con.prepareStatement(insertQuery);
				ps.setString(1, iconname);
				ps.setString(2, title);
				ps.setString(3, description);
				ps.setString(4, datetime);

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
	public List<ServiceModulePojo> readAllServices() {

		String selectUserQuery = " select * from service";

		try {

			PreparedStatement ps = con.prepareStatement(selectUserQuery);
			List<ServiceModulePojo> users = new ArrayList<>();
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				String iconname = set.getString("iconname");
				String title = set.getString("title");
				String description = set.getString("description");

				String datetime = set.getString("datetime");

				ServiceModulePojo user = new ServiceModulePojo(iconname, title, description, datetime);
				users.add(user);
			}

			return users;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ServiceModulePojo> readFourServices() {

		String selectUserQuery = " select * from service LIMIT 4";

		try {

			PreparedStatement ps = con.prepareStatement(selectUserQuery);
			List<ServiceModulePojo> users = new ArrayList<>();
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				String iconname = set.getString("iconname");
				String title = set.getString("title");
				String description = set.getString("description");
				String datetime = set.getString("datetime");
				ServiceModulePojo user = new ServiceModulePojo(iconname, title, description, datetime);
				users.add(user);
			}

			return users;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteService(String title) {

		String deleteQuery = "delete from service where title = ? ";

		try {

			PreparedStatement ps = con.prepareStatement(deleteQuery);

			ps.setString(1, title);

			int a = ps.executeUpdate();

			return a > 0;
		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}
	}

	@Override
	public ServiceModulePojo readServicesByTitle(String title) {

		String selectUserQuery = " select * from service where title=? ";

		try {

			PreparedStatement ps = con.prepareStatement(selectUserQuery);
			ps.setString(1, title);

			ResultSet set = ps.executeQuery();
			ServiceModulePojo user = null;
			if (set.next()) {
				String iconname = set.getString("iconname");
				String title1 = set.getString("title");
				String description = set.getString("description");

				String datetime = set.getString("datetime");

				user = new ServiceModulePojo(iconname, title1, description, datetime);

			}

			return user;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	@Override
	public String updateService(String iconname, String title, String description, String datetime) {
		String updateQuery = "UPDATE service SET iconname = ?, description = ?, datetime = ? WHERE title = ?";

		try {

			if (con != null) {

				PreparedStatement ps = con.prepareStatement(updateQuery);
				ps.setString(1, iconname);
				ps.setString(2, description);
				ps.setString(3, datetime);
				ps.setString(4, title);

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
