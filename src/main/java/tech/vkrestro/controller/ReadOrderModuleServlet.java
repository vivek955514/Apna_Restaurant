package tech.vkrestro.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.model.BookingPojo;
import tech.vkrestro.model.OrderPojo;
import tech.vkrestro.service.BookingTableServiceImp;
import tech.vkrestro.service.OrderServiceModuleImp;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ReadOrderModuleServlet
 */
@WebServlet("/ReadOrderModuleServlet")
public class ReadOrderModuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		 
	    OrderServiceModuleImp    orderServiceModuleImp  =  new  OrderServiceModuleImp();
        
		   List<OrderPojo> l =   orderServiceModuleImp.ViewAllOrder();
		   
		   System.out.println(" BEFOR  on servlet booking read list is ---"+l);
		 
	     	   if(l!=null&& !l.isEmpty()) {
	     		   
	     		  System.out.println("  AFTER THE on servlet booking read list is ---"+l);

	     		 session.setAttribute("AllData", l);
	     		response.sendRedirect("viewOrder.jsp");// attribute preserved
        }
	     	    else
	      		  {
	      		
	               request.setAttribute("msg", "SOMETHING WENT WRONG");
	      		   RequestDispatcher rd = request.getRequestDispatcher("viewOrder.jsp");
	      		   rd.forward(request, response);   // attribute preserved
	      		}
	       // forward request to JSP (not redirect)
	}

}
