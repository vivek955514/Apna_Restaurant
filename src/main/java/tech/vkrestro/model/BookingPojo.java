package tech.vkrestro.model;

public class BookingPojo {
	
    private int booking_id;
	private String name;
	private String email;
	private String datetime;
	private int people;
	private String  special_request;
	
	
	public BookingPojo(int booking_id, String name, String email, String datetime, int people,
			String special_request) {
		super();
		this.booking_id = booking_id;
		this.name = name;
		this.email = email;
		this.datetime = datetime;
		this.people = people;
		this.special_request = special_request;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
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
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getSpecial_request() {
		return special_request;
	}
	public void setSpecial_request(String special_request) {
		this.special_request = special_request;
	}
	@Override
	public String toString() {
		return "BookingPojo [booking_id=" + booking_id + ", name=" + name + ", email=" + email + ", datetime="
				+ datetime + ", people=" + people + ", special_request=" + special_request + "]";
	}
	
	
	
	
	

}
