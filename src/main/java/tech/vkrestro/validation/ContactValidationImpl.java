package tech.vkrestro.validation;

public class ContactValidationImpl implements ContactValidation {
     
	  private String result;
	@Override
	public String contactValidation(String name, String email,  String subject, String message) {
		// TODO Auto-generated method stub
		
		int name_len= name.length();
		int email_len= email.length();
		int subject_len= subject.length();
		int message_len= message.length();
	
		
		if( name_len<2|| name_len>50) {
			
			 result ="Invalid name";
		}
		
		else if( email_len<10|| email_len>50|| !email.contains("@") || !email.endsWith(".com")) {
			
			
			result ="INVALID EMAIL";
		}
		
		else if(subject_len<5||subject_len>70)
		{
			result="INVALID SUBJECT";
		}
		
		else if(message_len<5||message_len>500) {
			result="INVALID MESSAGE";
			
		}
		
		else {
			result="VALID";
		}
		return result;
	}

}
