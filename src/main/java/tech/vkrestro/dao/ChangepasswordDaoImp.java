package tech.vkrestro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tech.vkrestro.connection.ConnectionFactory;

public class ChangepasswordDaoImp implements ChangePasswordDao {

	Connection con = ConnectionFactory.getUserConnection();

	@Override
	public boolean changepasswordDao(String username, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		boolean status = false;

		try {

			if (con != null) {

				// find database password

				String checkQuery = " select password from adminlogin where username =?";

				PreparedStatement ps = con.prepareStatement(checkQuery);
				ps.setString(1, username);

				ResultSet rs = ps.executeQuery();

				String currentPassword = null;
				if (rs.next()) {
					currentPassword = rs.getString("password");

				}

				if (oldPassword.equals(currentPassword)) {

					// Step 3: If matched, update password in DB
					String updateQuery = "UPDATE adminlogin SET password=? WHERE username=?";
					PreparedStatement ps2 = con.prepareStatement(updateQuery);
					ps2.setString(1, newPassword);
					ps2.setString(2, username);

					int rows = ps2.executeUpdate();
					status = rows > 0;

				}

			} else {
				return status;

			}

		}

		catch (Exception e) {
			e.printStackTrace();

		}

		return status;

	}

}
