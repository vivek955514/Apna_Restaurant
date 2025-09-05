package tech.vkrestro.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.vkrestro.model.ServiceModulePojo;
import tech.vkrestro.service.ServiceModuleServiceImp;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ReadServiceDeleteUpdateModule
 */
@WebServlet("/ReadServiceDeleteUpdateModule")
public class ReadServiceDeleteUpdateModule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
           ServiceModuleServiceImp     serviceModuleServiceImp   =   new   ServiceModuleServiceImp();
		   List<ServiceModulePojo> l = serviceModuleServiceImp.readService();
		 
	     	   if(l!=null&& !l.isEmpty()) {
	      		 request.setAttribute("data", l);
	      		  RequestDispatcher rd = request.getRequestDispatcher("readservice.jsp");
	      		  rd.forward(request, response);   // attribute preserved
              }
	     	    else
	      		  {
	      		
	               request.setAttribute("msg", "SOMETHING WENT WRONG");
	      		   RequestDispatcher rd = request.getRequestDispatcher("readservice.jsp");
	      		   rd.forward(request, response);   // attribute preserved
	      		}
	       // forward request to JSP (not redirect)
	}
}
