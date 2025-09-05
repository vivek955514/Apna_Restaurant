package tech.vkrestro.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.vkrestro.model.MenuPojo;
import tech.vkrestro.model.ServiceModulePojo;
import tech.vkrestro.service.MenuModuleServiceImp;
import tech.vkrestro.service.ServiceModuleServiceImp;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ReadMenuDeleteUpdateModule
 */
@WebServlet("/ReadMenuDeleteUpdateModule")
public class ReadMenuDeleteUpdateModule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		MenuModuleServiceImp menuModuleServiceImp = new MenuModuleServiceImp();

		List<MenuPojo> l = menuModuleServiceImp.readMenu();

		if (l != null && !l.isEmpty()) {
			request.setAttribute("data", l);
			RequestDispatcher rd = request.getRequestDispatcher("readmenu.jsp");
			rd.forward(request, response); // attribute preserved
		} else {

			request.setAttribute("msg", "SOMETHING WENT WRONG");
			RequestDispatcher rd = request.getRequestDispatcher("readmenu.jsp");
			rd.forward(request, response); // attribute preserved
		}
		// forward request to JSP (not redirect)
	}

}
