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
 * Servlet implementation class serviceupdate
 */
@WebServlet("/serviceupdate")
public class serviceupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String iconname = request.getParameter("iconname");
		String title = request.getParameter("title");
		String description = request.getParameter("description");

		ServiceModuleServiceImp serviceModuleServiceImp = new ServiceModuleServiceImp();

//    FORWARD

		String tt = serviceModuleServiceImp.updateService(iconname, title, description);

		if (tt != null) {

			session.setAttribute("msg", "UPDATE SUCCESSFULLY");
			response.sendRedirect("ReadServiceDeleteUpdateModule");
		}

		else {
			session.setAttribute("msg", "MESSAGE NOT SENT SUCCESSFULLY");
			response.sendRedirect("readservice.jsp");

		}

	}

}
