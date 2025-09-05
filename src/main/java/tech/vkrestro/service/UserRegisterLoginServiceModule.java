package tech.vkrestro.service;

public interface UserRegisterLoginServiceModule {
	
	public String userRegiserService(String username, String email, String password);
	public boolean userLogin(String email , String password);
	
	

}
