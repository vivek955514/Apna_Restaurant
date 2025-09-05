

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
<link rel="stylesheet" href="css/readservice.css">

 
</head>
<body>


 <!-- Header -->
  <header>
   <h1> READ SERVICE</h1>
    <h1> <%@include file="message.jsp" %></h1>
  </header>

  <!-- Navigation Links -->
  <nav>
    <a href="admin.jsp">Home</a>
     <a href="ReadServiceDeleteUpdateModule">Refresh</a>

 
<%  
 List<ServiceModulePojo> l = (List<ServiceModulePojo>) request.getAttribute("data");
%> 
 </nav>

 <table border="1">
      <tr>

			<th>TITLE NAME:</th>
			<th>DESCRIPTION:</th>
			<th>DATETIME:</th>
			<th colspan="2">Action:</th>
	</tr>
		 <%
		for (ServiceModulePojo user : l) {
		%> 
		<tr>
			 <td><%=user.getTitle()%></td>
			<td><%=user.getDescription()%></td>
	        <td><%=user.getDatetime()%></td>

			<td> 
        <form action="DeleteServiceModuleServlet" method="post">
          <input type="hidden" name="title" value="  <%=user.getTitle() %>">
          <input type="submit" value="Delete">
        </form>
      </td>
      <td><a style="text-decoration: none;"href="updateservice.jsp?title=<%=user.getTitle()%>">Update</a></td>
			
		</tr>
		
		<%
		}
		%>

	</table>
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