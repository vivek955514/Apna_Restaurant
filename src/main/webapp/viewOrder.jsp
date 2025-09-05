
<%@page import="tech.vkrestro.model.OrderPojo"%>
<%@page import="java.util.List"%>
<%
String check = (String) session.getAttribute("adminlogin");
if (check == null) {

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
<link rel="stylesheet" href="css/readcontact.css">
</head>
<body>

	<!-- Header -->
	<header>
		<h1>VIEW BOOKING</h1>
		<h1>
			<%@include file="message.jsp"%></h1>
	</header>

	<!-- Navigation Links -->
	<nav>
		<a href="admin.jsp">Home</a> <a href="ReadOrderModuleServlet">Refresh</a>

		<%
		List<OrderPojo> l = (List<OrderPojo>) session.getAttribute("AllData");
		%>


	</nav>

	<table border="1">
		<tr>

			<th>MENU_ID:</th>
			<th>EMAIL:</th>
			<th>QUANTITY:</th>
			<th>TOTAL_PRICE:</th>
			<th>STATUS:</th>
			<th>ORDER_DATE-TIME:</th>
			<!-- <th colspan="1">Action :</th> -->


		</tr>
		<%
		if (l != null) {

			for (OrderPojo user : l) {
		%>
		<tr>

			<td><%=user.getMenuId()%></td>
			<td><%=user.getUserEmail()%></td>
			<td><%=user.getQuantity()%></td>
			<td><%=user.getTotalPrice()%></td>
			<td><%=user.getStatus()%></td>
			<td><%=user.getDatetime()%></td>
			<%-- <td>
        <form action="DeleteContactServlet" method="post">
          <input type="hidden" name="email" value="<%=user.getEmail()%>">
          <input type="submit" value="Delete">
        </form>
      </td>
			 --%>
		</tr>
		<%
		}
		}

		else {
		%>

		<tr>
			<td colspan="6" style="color: red;">No Order found</td>
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
	<footer> &copy; 2025 Admin Panel | All Rights Reserved </footer>

</body>
</html>