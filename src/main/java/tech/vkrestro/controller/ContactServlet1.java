package tech.vkrestro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.service.ContactServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class ContactServlet1
 */
@WebServlet("/ContactServlet1")
public class ContactServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private String result;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    HttpSession  session =request.getSession();
		String name = request.getParameter("name");
		String  email = request.getParameter("email");
		String  subject = request.getParameter("subject");
		String  message = request.getParameter("message");
		
		
		     ContactServiceImpl  contactServiceImpl =  new ContactServiceImpl();
		     result =   contactServiceImpl.contactService1(name , email, subject, message);
		    
		     
		     if(result.equals("VALID")) {
		    	 
		    	 System.out.println("validated   from");
		    	 
		    	 result =   contactServiceImpl.contactService2(name , email, subject, message);
		    	 if(result!=null) {
		    		 session.setAttribute("msg","MESSAGE SENT SUCCESSFULLY");
		    		 response.sendRedirect("contact.jsp");
		    	 }
		    	 
		    	 else {
		    		 session.setAttribute("msg","MESSAGE NOT SENT SUCCESSFULLY");
		    		 response.sendRedirect("contact.jsp");
		    	 }
		    	 
		    	 
		    	 
		    	 
		     }
		     else {
		    	 
		    	  session.setAttribute("msg", result);
		    	  response.sendRedirect("contact.jsp");
		    	  
			   
		    	  
		    	  
		     }
		
	}

}
