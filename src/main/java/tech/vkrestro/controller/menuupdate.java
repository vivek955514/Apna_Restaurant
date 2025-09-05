package tech.vkrestro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.service.MenuModuleServiceImp;

import java.io.IOException;

/**
 * Servlet implementation class menuupdate
 */
@WebServlet("/menuupdate")
public class menuupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	      HttpSession session =  request.getSession();
		
	      String name = request.getParameter("name");
	      String description = request.getParameter("description");
	      double price=Double.parseDouble( request.getParameter("price"));
	      String category = request.getParameter("category");
	      int  idmenu =  Integer.parseInt( request.getParameter("idmenu"));
	      
	      
	      
	             MenuModuleServiceImp   menuModuleServiceImp =  new  MenuModuleServiceImp();
	             
	        String  result=    menuModuleServiceImp.updateMenu(name, description,price,category,idmenu);
	        
	        if(result!=null) {
				 
				 session.setAttribute("msg", "UPDATE SUCCESSFULLY");
			   response.sendRedirect("ReadMenuDeleteUpdateModule"); }
			  
			  else { session.setAttribute("msg" ,"MESSAGE NOT SENT SUCCESSFULLY");
			  response.sendRedirect("readmenu.jsp");
			  
			  }
			 
			 
	             
	             
	      

		
	}

}
