package tech.vkrestro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.service.ServiceModuleServiceImp;

import java.io.IOException;

/**
 * Servlet implementation class ServiceModuleServlet1
 */
@WebServlet("/ServiceModuleServlet1")
public class ServiceModuleServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String iconname = request.getParameter("iconname");
		String title = request.getParameter("title");
		String description = request.getParameter("description");

		ServiceModuleServiceImp serviceModuleServiceImp = new ServiceModuleServiceImp();

		String result = serviceModuleServiceImp.validateService(iconname, title, description);

		if (result.equals("VALID")) {

//          FORWARD

			result = serviceModuleServiceImp.addService(iconname, title, description);

			if (result != null) {

				session.setAttribute("msg", "MESSAGE SENT SUCCESSFULLY");

				response.sendRedirect("addservice.jsp");
			}

			else {
				session.setAttribute("msg", "MESSAGE NOT SENT SUCCESSFULLY");
				response.sendRedirect("addservice.jsp");

			}

		} else {

			session.setAttribute("msg", result);
			response.sendRedirect("addservice.jsp");

		}
	}
}
