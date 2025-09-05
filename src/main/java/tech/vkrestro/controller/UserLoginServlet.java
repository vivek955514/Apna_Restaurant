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
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean isValid = new UserRegisterLoginServiceModuleImp().userLogin(email, password);

		if (isValid) {

			session.setAttribute("userlogin", email);
		session.setMaxInactiveInterval(300);

			response.sendRedirect("index.jsp");

		} else {
			session.setAttribute("msg", "NOT EXIST");
			response.sendRedirect("userlogin.jsp");

		}

	}

}
