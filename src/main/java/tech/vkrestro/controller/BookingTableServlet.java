package tech.vkrestro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.service.BookingTableServiceImp;
import tech.vkrestro.service.ContactServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class BookingTableServlet
 */
@WebServlet("/BookingTableServlet")
public class BookingTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    HttpSession  session =request.getSession();
		    String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String datetime = request.getParameter("datetime");
	        int people = Integer.parseInt(request.getParameter("people"));
	        String message = request.getParameter("message");
	        
                       
		     
		     BookingTableServiceImp   bookingTableServiceImp  = new  BookingTableServiceImp();
		     
		     result =    bookingTableServiceImp.bookingTableService1(name, email, people, message);
		       
		     
		     if(result.equals("VALID")) {
		    	 
		    	 System.out.println("validated  BOOKING");
		    	 
		    	 result =   bookingTableServiceImp.bookingTableService2(name, email,datetime, people, message);
		    	 if(result!=null) {
		    		 session.setAttribute("msg","Booking successful! Your table has been reserved.");
		    		 response.sendRedirect("booking.jsp");
		    	 }
		    	 
		    	 else {
		    		 session.setAttribute("msg","Something went wrong. Please try again.");
		    		 response.sendRedirect("booking.jsp");
		    	 }
		    	 
		    	 
		    	 
		    	 
		     }
		     else {
		    	 
		    	  session.setAttribute("msg", result);
		    	  response.sendRedirect("booking.jsp");
		    	  
			   
		    	  
		    	  
		     }
		
	        
		
	}

}
