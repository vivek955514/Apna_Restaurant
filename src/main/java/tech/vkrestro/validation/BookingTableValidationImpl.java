package tech.vkrestro.validation;

public class BookingTableValidationImpl implements BookingTableValidation {
 
	  private String result;
	@Override
	public String bookingTableValidation(String name, String email, int people, String message) {
		// TODO Auto-generated method stub
		int name_len= name.length();
		int email_len= email.length();
		int numberOfPeople = people;
		int message_len= message.length();
	
		
		if( name_len<3|| name_len>50) {
			
			 result ="Invalid name";
		}
		
		else if( email_len<5|| email_len>50|| !email.contains("@") || !email.endsWith(".com")) {
			
			
			result ="INVALID EMAIL";
		}
		
		else if(numberOfPeople<1)
		{
			result="INVALID PEOPLE";
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
