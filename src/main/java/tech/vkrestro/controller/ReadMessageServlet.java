package tech.vkrestro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.model.ContactPogo;
import tech.vkrestro.service.ContactServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ReadMessageServlet
 */
@WebServlet("/ReadMessageServlet")
public class ReadMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       HttpSession        session  =      request.getSession();
		     ContactServiceImpl     contactServiceImp  =   new   ContactServiceImpl();
		
	       	List<ContactPogo>  l = contactServiceImp.readContactService();
	       	
	       	if(l!=null) {
	       		session.setAttribute("contactdata",l);
	       		response.sendRedirect("readcontact.jsp");
	       		
	       	}
	       	else {
	       		
	       	 session.setAttribute("msg","SOMETHING WENT WRONG");
       		 response.sendRedirect("admin.jsp");
	       	}
		
	}

}
