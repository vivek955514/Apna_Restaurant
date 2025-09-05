package tech.vkrestro.dao;

import java.util.List;

import tech.vkrestro.model.BookingPojo;
import tech.vkrestro.model.ContactPogo;

public interface BookingTableDao {
	
	
	 public String saveBooking(String name, String email, String datetime, int people, String message);
	 public List<BookingPojo> viewAllBooking();
}
