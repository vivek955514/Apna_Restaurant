<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
   <%    
   
         String message =  (String)session.getAttribute("msg");
          
          if(message!=null)
          
          {
        	   if(message.contains("SUCCESSFULLY")){
        		   
        		   
        		   
  %> 
  
            <span   style="color:blue">   <%=message %>   </span>
  
<%  }
        	   
        	   else
        	   {
        		   %>  
      <span   style="color:red">   <%=message %>   </span>
     
          
      
    
  <%   
        
        	   }
    }
          
          session.removeAttribute("msg");
  
  %>  