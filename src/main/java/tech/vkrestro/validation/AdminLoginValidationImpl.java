package tech.vkrestro.validation;

public class AdminLoginValidationImpl implements AdminLoginValidation {
    
	  private String result;
	@Override
	public String adminLoginValidation(String username, String password) {
		
		try {
			
			int userlen = username.length();
			int passlen = password.length();
			
			if(userlen<4||userlen>16) {
				result = "INVALID NAME";
			}
			
			else if( passlen<4|| passlen>16) {
				
				result= "INVALID PASSWORD";
			}
			
			else {
				result = "VALID";
			}
			
		}  
		   catch(Exception e) {
			   
			   result = "SOMETHING WENT WRONG";
			   e.printStackTrace();
			   
		   }
		
		
		return result;
	}
	@Override
	public String adminLoginValidation(String password) {
try {
			
		
			int passlen = password.length();
			
		
			
			 if( passlen<4|| passlen>16) {
				
				result= "INVALID PASSWORD Enter 4 digit Password";
			}
			
			else {
				result = "VALID";
			}
			
		}  
		   catch(Exception e) {
			   
			   result = "SOMETHING WENT WRONG";
			   e.printStackTrace();
			   
		   }
		
		
		return result;
	
	}

}
