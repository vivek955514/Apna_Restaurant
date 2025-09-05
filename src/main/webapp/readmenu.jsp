<%@page import="tech.vkrestro.model.MenuPojo"%>
<%@page import="java.util.List"%>
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
   <h1> READ MENU</h1>
    <h1> <%@include file="message.jsp" %></h1>
  </header>

  <!-- Navigation Links -->
  <nav>
    <a href="admin.jsp">Home</a>
     <a href="">Refresh</a>

 
<%  
 List<MenuPojo> l  = (List<MenuPojo>) request.getAttribute("data");
     
%> 
 </nav>
<table border="1">
      <tr>

			<th>FOOD NAME:</th>
			<th>DESCRIPTION:</th>
			<th>PRICE:</th>
			<th>CATEGORY:</th>
			<th colspan="2">Action:</th>
	</tr>
		 <%
		for (MenuPojo user : l) {
		%> 
		<tr>
			 <td><%=user.getName()%></td>
			<td><%=user.getDescription()%></td>
	        <td><%=user.getPrice()%></td>
	         <td><%=user.getCategory()%></td>

			<td> 
         <form action="DeleteMenuModuleServlet" method="post">
          <input type="hidden" name="id" value="<%=user.getIdmenu()%>">
          <input type="submit" value="Delete">
        </form> 
      </td>
      <td><a style="text-decoration: none;"href="updatemenu.jsp?id=<%=user.getIdmenu()%>">Update</a></td>
			
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