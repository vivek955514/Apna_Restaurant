package tech.vkrestro.service;

public interface AdminLoginService {
	
	public String adminLoginService1(String username , String password);
	public String adminLoginService2(String username , String password);
	public boolean changePasswordService(String username, String oldPassword, String newPassword);

}
