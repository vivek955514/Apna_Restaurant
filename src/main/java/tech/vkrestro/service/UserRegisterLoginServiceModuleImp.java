package tech.vkrestro.service;

import tech.vkrestro.dao.UserRegisterLoginDaoImp;

public class UserRegisterLoginServiceModuleImp implements UserRegisterLoginServiceModule {

	private String result;

	@Override
	public String userRegiserService(String username, String email, String password) {
		try {
			// DAO

			UserRegisterLoginDaoImp registerdao = new UserRegisterLoginDaoImp();
			result = registerdao.usersave(username, email, password);

		} catch (Exception e) {

			result = "SERVICE ERROR";

			e.printStackTrace();
		}
		return result;

	}

	@Override
	public boolean userLogin(String email, String password) {

		boolean status = false;

		try {
			// DAO

			UserRegisterLoginDaoImp logindao = new UserRegisterLoginDaoImp();
			status = logindao.validateUser(email, password);

		} catch (Exception e) {

			result = "SERVICE ERROR";

			e.printStackTrace();
		}
		return status;

	}

}
