package tech.vkrestro.service;

import java.time.LocalDateTime;
import java.util.List;

import tech.vkrestro.dao.MenuDaoImp;
import tech.vkrestro.dao.ServiceDaoImpl;
import tech.vkrestro.model.MenuPojo;
import tech.vkrestro.model.ServiceModulePojo;
import tech.vkrestro.validation.MenuValidationImp;
import tech.vkrestro.validation.ServiceModuleValidationImp;

public class MenuModuleServiceImp implements MenuModuleService {

	private String result;

	@Override
	public String addMenu(String name, String description, double price, String category, String image_url) {
		try {
			// DAO

			MenuDaoImp menuDaoImp = new MenuDaoImp();
			result = menuDaoImp.saveMenu(name, description, price, category, image_url);

		} catch (Exception e) {

			result = "SERVICE ERROR";

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String validateMenu(String name, String description, String category) {
		// TODO Auto-generated method stub
		try {

			MenuValidationImp menuValidationImp = new MenuValidationImp();

			result = menuValidationImp.MenuModuleValidation(name, description, category);

		} catch (Exception e) {

			result = "SERVICE ERROR";

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<MenuPojo> readMenu() {
		// TODO Auto-generated method stub
		List<MenuPojo> l = null;

		try {
			System.out.println("serviceimp  " + l);

			MenuDaoImp menuDaoImp = new MenuDaoImp();

			l = menuDaoImp.readAllMenu();

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		return l;

	}

	@Override
	public boolean deleteMenu(int id) {

		boolean result = false;

		try {

			MenuDaoImp menuDaoImp = new MenuDaoImp();

			result = menuDaoImp.deleteMenuById(id);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public MenuPojo readMenuById(int id) {

		MenuPojo menu = null;

		try {
			System.out.println("serviceimp  " + menu);

			MenuDaoImp menuDaoImp = new MenuDaoImp();

			menu = menuDaoImp.readmenuById(id);

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		return menu;

	}

	@Override
	public String updateMenu(String name, String description, double price, String category, int idmenu) {

		try {
			// DAO
			MenuDaoImp menuDaoImp = new MenuDaoImp();

			result = menuDaoImp.updatemenuById(name, description, price, category, idmenu);

		} catch (Exception e) {

			result = "SERVICE ERROR";

			e.printStackTrace();
		}
		return result;
	}

}
