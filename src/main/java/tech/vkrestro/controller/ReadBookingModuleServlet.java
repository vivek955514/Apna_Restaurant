package tech.vkrestro.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.model.BookingPojo;
import tech.vkrestro.model.ServiceModulePojo;
import tech.vkrestro.service.BookingTableServiceImp;
import tech.vkrestro.service.ServiceModuleServiceImp;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ReadBookingModuleServlet
 */
@WebServlet("/ReadBookingModuleServlet")
public class ReadBookingModuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
              BookingTableServiceImp    bookingTableServiceImp  = new   BookingTableServiceImp();
        
		   List<BookingPojo> l =  bookingTableServiceImp.ViewAllBooking();
		   
		   System.out.println(" BEFOR  on servlet booking read list is ---"+l);
		 
	     	   if(l!=null&& !l.isEmpty()) {
	     		   
	     		  System.out.println("  AFTER THE on servlet booking read list is ---"+l);

	     		 session.setAttribute("AllData", l);
	     		response.sendRedirect("viewbooking.jsp");// attribute preserved
           }
	     	    else
	      		  {
	      		
	               request.setAttribute("msg", "SOMETHING WENT WRONG");
	      		   RequestDispatcher rd = request.getRequestDispatcher("viewbooking.jsp");
	      		   rd.forward(request, response);   // attribute preserved
	      		}
	       // forward request to JSP (not redirect)
	           
	}

}
