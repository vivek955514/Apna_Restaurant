package tech.vkrestro.dao;

public interface UserRegisterLoginDao {
	
	    public String usersave(String username, String email, String password);
        
	    public boolean validateUser(String email, String password);

}
