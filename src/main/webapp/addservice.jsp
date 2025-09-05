

<%@page import="tech.vkrestro.model.ServiceModulePojo"%>
<%@page import="java.util.List"%>
<% 

  String check = (String)session.getAttribute("adminlogin");
  if(check==null){
	  
	  response.sendRedirect("adminlogin.jsp");
	  return;
  }
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 

  <link rel="stylesheet" href="css/addservice.css">
   
    
   
</head>
<body>
<!-- Header -->
  <header>
   <h1> ADD SERVICE</h1>
    <h1> <%@include file="message.jsp" %></h1>
  </header>

  <!-- Navigation Links -->
  <nav>
    <a href="admin.jsp">Home</a>
    
</nav>
<form action="ServiceModuleServlet1" method="post">

<input  type = "text" name="iconname" placeholder=" enter the icon name"><br>
<input  type = "text" name="title" placeholder=" enter the title"><br>
<input  type = "text" name="description" placeholder=" enter the Description"><br>
<button>Add Service</button>
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