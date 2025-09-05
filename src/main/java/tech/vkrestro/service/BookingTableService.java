package tech.vkrestro.service;

import java.util.List;

import tech.vkrestro.model.BookingPojo;
import tech.vkrestro.model.ContactPogo;

public interface BookingTableService {
	
	public String bookingTableService1(String name, String email, int people, String message);
	public String bookingTableService2(String name, String email, String bookingDate, int people, String message);
	 public List<BookingPojo> ViewAllBooking(); 

}
