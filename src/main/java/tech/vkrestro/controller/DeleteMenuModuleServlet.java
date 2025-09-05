package tech.vkrestro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.vkrestro.service.MenuModuleServiceImp;
import tech.vkrestro.service.ServiceModuleServiceImp;

import java.io.IOException;

/**
 * Servlet implementation class DeleteMenuModuleServlet
 */
@WebServlet("/DeleteMenuModuleServlet")
public class DeleteMenuModuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("id"));

		MenuModuleServiceImp menuModuleServiceImp = new MenuModuleServiceImp();

		boolean result = menuModuleServiceImp.deleteMenu(id);

		if (result) {

			session.setAttribute("msg", "DELETE SUCCESSFULLY ");

			response.sendRedirect("ReadMenuDeleteUpdateModule");

		} else {
			session.setAttribute("msg", " NOT DELETE SUCCESSFULLY");

			response.sendRedirect("readmenu.jsp");

		}

	}

}
