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
 * Servlet implementation class DeleteContactServlet
 */
@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   HttpSession       session =   request.getSession();
		
		     String email= (String)request.getParameter("email");
		     
		     if (email != null) {
		            email = email.trim(); // remove accidental spaces
		        }
		     ContactServiceImpl    contactDel =  new ContactServiceImpl();
		     
		  
		     
		       boolean result =   contactDel.deleteService(email);
		       
		        if(result) {
		    	
		    	   
		    	   session.setAttribute("msg", "DELETE SUCCESSFULLY ");
			       
			       response.sendRedirect("ReadMessageServlet");
		    	   
		       }
		       else {
                   session.setAttribute("msg", " NOT DELETE SUCCESSFULLY");
			       
			       response.sendRedirect("readcontact.jsp");
		    	   
		    	   
		    	   
		       }
		      
	}

}
