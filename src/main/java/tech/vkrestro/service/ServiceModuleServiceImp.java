package tech.vkrestro.service;

import java.time.LocalDateTime;
import java.util.List;

import tech.vkrestro.dao.ContactDaoImpl;
import tech.vkrestro.dao.ServiceDaoImpl;
import tech.vkrestro.model.ContactPogo;
import tech.vkrestro.model.ServiceModulePojo;
import tech.vkrestro.validation.ContactValidationImpl;
import tech.vkrestro.validation.ServiceModuleValidationImp;

public class ServiceModuleServiceImp implements ServiceModuleService {

	private String result;

	@Override
	public String validateService(String iconname, String title, String description) {
		// TODO Auto-generated method stub
		try {

			ServiceModuleValidationImp serviceModuleValidationImp = new ServiceModuleValidationImp();

			result = serviceModuleValidationImp.serviceModuleValidation(iconname, title, description);

		} catch (Exception e) {

			result = "SERVICE ERROR";

			e.printStackTrace();
		}
		return result;

	}

	@Override
	public String addService(String iconname, String title, String description) {
		try {
			// DAO
			ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();

			String datetime = LocalDateTime.now().toString();

			result = serviceDaoImpl.saveService(iconname, title, description, datetime);
		} catch (Exception e) {

			result = "SERVICE ERROR";

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ServiceModulePojo> readService() {
		List<ServiceModulePojo> l = null;

		try {
			System.out.println("serviceimp  " + l);

			ServiceDaoImpl serDao = new ServiceDaoImpl();

			l = serDao.readAllServices();

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		return l;
	}

	@Override
	public List<ServiceModulePojo> readFourService() {
		List<ServiceModulePojo> l = null;

		try {
			System.out.println("serviceimp  " + l);

			ServiceDaoImpl serDao = new ServiceDaoImpl();

			l = serDao.readFourServices();

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		return l;
	}

	@Override
	public boolean deleteService(String title) {

		boolean result = false;

		try {

			ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();

			result = serviceDaoImpl.deleteService(title);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ServiceModulePojo readServiceByTitle(String title) {
		ServiceModulePojo user = null;

		try {

			ServiceDaoImpl serDao = new ServiceDaoImpl();

			user = serDao.readServicesByTitle(title);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;

	}

	@Override

	public String updateService(String iconname, String title, String description) {
		try {
			// DAO
			ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();

			String datetime = LocalDateTime.now().toString();

			result = serviceDaoImpl.updateService(iconname, title, description, datetime);

		} catch (Exception e) {

			result = "SERVICE ERROR";

			e.printStackTrace();
		}
		return result;
	}

}
