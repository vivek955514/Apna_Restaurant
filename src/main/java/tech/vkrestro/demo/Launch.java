package tech.vkrestro.demo;


import java.util.List;

import tech.vkrestro.connection.ConnectionFactory;
import tech.vkrestro.dao.ServiceDaoImpl;
import tech.vkrestro.model.ServiceModulePojo;

public class Launch {
	
	public static void main(String[] args) {
		
		
		
		List<ServiceModulePojo>  l =null;
		
		 ServiceDaoImpl  serDao =  new  ServiceDaoImpl() ;
         
		   
	     System.out.println("serviceimp  dao calll " );
         l =  serDao.readFourServices();
        
         
         for( ServiceModulePojo s:l) {
				
        	 System.out.println(s.toString());
				
			}
        
		
		
		
		
		
	}

}
