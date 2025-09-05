package tech.vkrestro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tech.vkrestro.connection.ConnectionFactory;

public class UserRegisterLoginDaoImp implements UserRegisterLoginDao {
	Connection con = ConnectionFactory.getUserConnection();

	@Override
	public String usersave(String username, String email, String password) {

		String insertQuery = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

		try {

			if (con != null) {

				PreparedStatement ps = con.prepareStatement(insertQuery);
				ps.setString(1, username);
				ps.setString(2, email);
				ps.setString(3, password); // 👉 Store hashed password in real projects

				return ps.executeUpdate() > 0 ? "SAVED" : "null";

			} else {

				return null;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
	}

	@Override
	public boolean validateUser(String email, String password) {

		boolean status = false;

		String sql = "SELECT * FROM users WHERE email=? AND password=?";

		try {

			if (con != null) {

				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, email);
				ps.setString(2, password);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					status = true; // true if user exists

				}

			} else {

				return status;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return status;

	}

}
