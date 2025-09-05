package tech.vkrestro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.service.MenuModuleServiceImp;
import tech.vkrestro.service.ServiceModuleServiceImp;

import java.io.IOException;

/**
 * Servlet implementation class AddMenuServlet
 */
@WebServlet("/AddMenuServlet")
public class AddMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  HttpSession session =  request.getSession();
		
	      String name = request.getParameter("name");
	      String description = request.getParameter("description");
	      double  price = Double.parseDouble( request.getParameter("price"));
	    
	      String category = request.getParameter("category");
	      String imageUrl = request.getParameter("image_url"); 
	      
	MenuModuleServiceImp  menuModuleServiceImp   =  new MenuModuleServiceImp();
	
 String  result=  menuModuleServiceImp.validateMenu(name, description, category);
	 

	
	 if(result.equals("VALID")) {
  	  
//   FORWARD
      
		  result = menuModuleServiceImp.addMenu(name, description, price, category, imageUrl);
              System.out.println("at servlet level "+result);
             if(result!=null) {
          	   
            	 System.out.println(" after at  if  servlet level "+result);
             
     	             session.setAttribute("msg", "MESSAGE SENT SUCCESSFULLY") ;
      	 
     	             response.sendRedirect("addmenu.jsp");
             }
             
             
             else {
          	    session.setAttribute("msg" ,"MESSAGE NOT SENT SUCCESSFULLY");
     	    	    response.sendRedirect("addmenu.jsp");
          	   
          	   
             }
             
  	     
				
				  } else {
				  
				  session.setAttribute("msg", result);
				  response.sendRedirect("addmenu.jsp");
				  
				  
				 
				 
				  }
				 
	}

}
