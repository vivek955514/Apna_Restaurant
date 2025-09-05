package tech.vkrestro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.service.UserRegisterLoginServiceModuleImp;

import java.io.IOException;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!password.equals(confirmPassword)) {

			session.setAttribute("msg", "New password and Confirm password do not match!");
			response.sendRedirect("userRegister.jsp");
			return;
		}

		UserRegisterLoginServiceModuleImp register = new UserRegisterLoginServiceModuleImp();

		String result = register.userRegiserService(name, email, password);

		if (result != null) {

			System.out.println(" after at  if  servlet level " + result);

			session.setAttribute("msg", "REGISTERED SUCCESSFULLY");

			response.sendRedirect("userlogin.jsp");

		} else {
			session.setAttribute("msg", "USER NOT REGISTER  SUCCESSFULLY");
			response.sendRedirect("userRegister.jsp");

		}

	}

}
