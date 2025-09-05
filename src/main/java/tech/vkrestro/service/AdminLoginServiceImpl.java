package tech.vkrestro.service;

import tech.vkrestro.dao.AdminLoginDaoImpl;
import tech.vkrestro.dao.ChangepasswordDaoImp;
import tech.vkrestro.validation.AdminLoginValidationImpl;

public class AdminLoginServiceImpl implements AdminLoginService {

	 private String result;
	 
	 
	@Override
	public String adminLoginService1(String username, String password) {
		
		   try {
			       
			   AdminLoginValidationImpl  adminLoginVal   =	new   AdminLoginValidationImpl();
			   
			   result =   adminLoginVal.adminLoginValidation(username, password) ;
			       
		   }catch(Exception e) {
			   e.printStackTrace();
			   
			   result = "SERVICE ERROR";
	 }
		   
		return result;
		
	}
	@Override
	public String adminLoginService2(String username, String password) {
		
		  try {
			   //DAO
			  
			  AdminLoginDaoImpl  adminLogin = 	new   AdminLoginDaoImpl();
			  
	        	result= adminLogin.checkAdminLoginData(username, password);
			  
			  
			  
		  }  catch(Exception e) {
			   e.printStackTrace();
			   result = "SERVICE ERROR";
			  
			  
		  }
		
		
		return  result;
	}
	@Override
	public boolean changePasswordService(String username, String oldPassword, String newPassword) {
		
		boolean  re = false;
		 try {
			   //DAO
			  
			     
		ChangepasswordDaoImp    changepasswordDaoImp	= new  ChangepasswordDaoImp();  
		           
		  re=  changepasswordDaoImp.changepasswordDao(username, oldPassword, newPassword);
			  
			  
		  }  catch(Exception e) {
			   e.printStackTrace();
			   result = "SERVICE ERROR";
			  
			  
		  }
		
		
		return  (boolean) re;
	}
	

}
