<%@page import="tech.vkrestro.service.ServiceModuleServiceImp"%>
<%@page import="tech.vkrestro.service.ServiceModuleService"%>
<%@page import="tech.vkrestro.model.ServiceModulePojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/updateservice.css">
</head>
<body>

     <% 
     
                 String title = request.getParameter("title");
      %>

 

<%

ServiceModuleServiceImp    serviceModuleServiceImp =  new  ServiceModuleServiceImp();
ServiceModulePojo   ser = serviceModuleServiceImp.readServiceByTitle(title);
%>
   <header>
		<h2>UPDATE SERVICE</h2>

	</header>
   

 <form action="serviceupdate" method="post">
		<label>ICON</label><br>
		 <input type="text" value="<%=ser.getIconname() %>" name="iconname"> <br>
			
	
		<label>TITLE</label><br>
		 <input type="text" name="title" value="<%=ser.getTitle()%>"> <br>
		<label>DESCRIPTION</label>	<br>
		<textarea name="description"  rows="10" cols="40"><%=ser.getDescription()%></textarea> <br>
			
<br> 
<input type="submit" value="update">

	</form>
	
	
  <!-- Content Section -->
  <div class="content">
    <h2>Welcome, Admin!</h2>
    <p>Here you can manage your website easily.</p>
  </div>

  <!-- Footer -->
  <footer>
    &copy; 2025 Admin Panel | All Rights Reserved
  </footer>
	
	

</body>
</html>