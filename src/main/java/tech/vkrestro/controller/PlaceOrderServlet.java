package tech.vkrestro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.service.OrderServiceModuleImp;

import java.io.IOException;

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
	        String email = (String) session.getAttribute("userlogin"); // assuming you store username/email

	        if(email == null) {
	            response.sendRedirect("userlogin.jsp?msg=Please login first");
	            return;
	        }
	        
	        
	        int menuId = Integer.parseInt(request.getParameter("menuId"));
	        int quantity = Integer.parseInt(request.getParameter("quantity"));
	        double price = Double.parseDouble(request.getParameter("price"));
	        double total = price * quantity;
	        
	           OrderServiceModuleImp   orderServiceModuleImp = new    OrderServiceModuleImp();
		                         
	         String result=  orderServiceModuleImp.addService(menuId,email, quantity , total);
	         
	         if (result != null) {

					session.setAttribute("msg", "ORDER PLACED SUCCESSFULLY");

					response.sendRedirect("orderSuccess.jsp");
				}

				else {
					session.setAttribute("msg", "ORDER NOT PLACED SUCCESSFULLY");
					response.sendRedirect("menu.jsp");

				}

	}

}
