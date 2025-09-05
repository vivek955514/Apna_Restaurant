
<%@page import="tech.vkrestro.model.ContactPogo"%>
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
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Panel</title>
  
  <link rel = "stylesheet" href="css/readcontact.css">
  
 
</head>
<body>
  <!-- Header -->
  <header>
   <h1> READ CONTACT</h1>
    <h1> <%@include file="message.jsp" %></h1>
  </header>

  <!-- Navigation Links -->
  <nav>
    <a href="admin.jsp">Home</a>
     <a href="ReadMessageServlet">Refresh</a>
    
    <%  
    
	    List<ContactPogo> l= (List<ContactPogo>)session.getAttribute("contactdata");
     %>
    
   
  </nav>
     <table border="1">
      <tr>

			<th>NAME:</th>
			<th>EMAIL:</th>
			<th>SUBJECT:</th>
			<th>MESSAGE:</th>
			<th>DATETIME:</th>
			<th colspan="1">Action :</th>
			

		</tr>
		<%
		for (ContactPogo user : l) {
		%>
		<tr>
			<td><%=user.getName()%></td>
			<td><%=user.getEmail()%></td>
	        <td><%=user.getSubject()%></td>
			<td><%=user.getMessage()%></td>
			<td><%=user.getDatetime()%></td>
			<td>
        <form action="DeleteContactServlet" method="post">
          <input type="hidden" name="email" value="<%=user.getEmail()%>">
          <input type="submit" value="Delete">
        </form>
      </td>
			
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
