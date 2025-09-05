package tech.vkrestro.validation;

public class ServiceModuleValidationImp implements ServiceModuleValidation {
	
	  private String result;
	@Override
	public String serviceModuleValidation(String iconname, String title, String description) {
		int iconname_len=iconname.length();
		int title_len= title.length();
		int description_len= description.length();
		
	
		
		if( iconname_len<4|| iconname_len>20) {
			
			 result ="Invalid ICONNAME";
		}
		
		else if( title_len<4|| title_len>40) {
			
			
			result ="INVALID TITLE";
		}
		
		else if(description_len<10||description_len>120)
		{
			result="INVALID DESCRIPTION";
		}
		
		
		
		else {
			result="VALID";
		}
		return result;
	}

}
