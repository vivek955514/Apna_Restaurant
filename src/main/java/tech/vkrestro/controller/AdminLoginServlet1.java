package tech.vkrestro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.service.AdminLoginServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class AdminLoginServlet1
 */
@WebServlet("/AdminLoginServlet1")
public class AdminLoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		AdminLoginServiceImpl adminLogin = new AdminLoginServiceImpl();

		String result = adminLogin.adminLoginService1(username, password);

		if (result.equals("VALID")) {

			// FORWARD
			result = adminLogin.adminLoginService2(username, password);

			if (result.equals("EXIST")) {

				session.setAttribute("adminlogin", username);
				// ADMIN PANAL
				response.sendRedirect("admin.jsp");
			}

			else {
				session.setAttribute("msg", "NOT EXIST");
				response.sendRedirect("adminlogin.jsp");

			}

		}

		else {

			session.setAttribute("msg", result);
			response.sendRedirect("adminlogin.jsp");

		}

	}

}
