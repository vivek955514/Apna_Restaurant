package tech.vkrestro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.service.ContactServiceImpl;
import tech.vkrestro.service.ServiceModuleServiceImp;

import java.io.IOException;

/**
 * Servlet implementation class DeleteServiceModuleServlet
 */
@WebServlet("/DeleteServiceModuleServlet")
public class DeleteServiceModuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String title = (String) request.getParameter("title");

		if (title != null) {

			title = title.trim();// remove accidental spaces
		}

		ServiceModuleServiceImp serviceModuleServiceImp = new ServiceModuleServiceImp();

		boolean result = serviceModuleServiceImp.deleteService(title);

		if (result) {

			session.setAttribute("msg", "DELETE SUCCESSFULLY ");

			response.sendRedirect("ReadServiceDeleteUpdateModule");

		} else {
			session.setAttribute("msg", " NOT DELETE SUCCESSFULLY");

			response.sendRedirect("readservice.jsp");

		}
	}

}
