package tech.vkrestro.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.service.AdminLoginServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		
		String username= request.getParameter("username");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword= request.getParameter("newPassword");
		String confirmPassword= request.getParameter("confirmPassword");
		
		
		
		if(!newPassword.equals(confirmPassword)) {
			
			System.out.println("New password and Confirm password do not match!");
			session.setAttribute("msg","New password and Confirm password do not match!");
			response.sendRedirect("changepassword.jsp");
	      		return;
				
			
}
		 AdminLoginServiceImpl  changePass  = new  AdminLoginServiceImpl();
		
		boolean success = changePass.changePasswordService(username, oldPassword, newPassword);
		if(success) {
			
			session.setAttribute("msg","Password changed successfully!");
			response.sendRedirect("adminlogin.jsp");
		}
		else {
			
			 request.setAttribute("msg", "Invalid username or old password!");
			RequestDispatcher rd = request.getRequestDispatcher("changepassword.jsp");
      		rd.forward(request, response);   //
			
		}
		
		
		
		
		
		
		
	}

}
