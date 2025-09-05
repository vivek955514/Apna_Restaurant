package tech.vkrestro.validation;

public class MenuValidationImp implements MenuValidation {
        
	private String result;
	@Override
	public String MenuModuleValidation(String name, String description, String category) {
		
		
		int name_len=name.length();
		
		int description_len= description.length();
		
		int category_len = category.length(); 
		
	
		
		if( name_len<3|| name_len>30) {
			
			 result ="Invalid NAME";
		}
		
		else if( category_len<4|| category_len>50) {
			
			
			result ="INVALID CATEGORY";
		}
		
		else if(description_len<5||description_len>120)
		{
			result="INVALID DESCRIPTION ";
		}
		
		
		
		else {
			result="VALID";
		}
		return result;
	}
	
	

}
