package tech.vkrestro.model;

public class ContactPogo {
	
	
	private String name;
	private String email;
	private String subject;
	private String message;
	private String  datetime;
	
	
	
	
	
	public ContactPogo(String name, String email, String subject, String message, String datetime) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.datetime = datetime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "ContactPogo [name=" + name + ", email=" + email + ", subject=" + subject + ", message=" + message
				+ ", datetime=" + datetime + "]";
	}
	
	

}
