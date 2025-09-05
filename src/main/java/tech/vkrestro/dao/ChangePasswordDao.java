package tech.vkrestro.dao;

public interface ChangePasswordDao {
	
	public boolean changepasswordDao(String username, String oldPassword, String newPassword);

}
