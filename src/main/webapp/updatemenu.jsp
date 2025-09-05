

<%@page import="tech.vkrestro.model.MenuPojo"%>
<%@page import="tech.vkrestro.service.MenuModuleServiceImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/menuupdate.css">

</head>
<body>


	<%
	HttpSession hhtpSession = request.getSession();

	int id = Integer.parseInt(request.getParameter("id"));

	MenuPojo menu = new MenuModuleServiceImp().readMenuById(id);
	%>

	<header>
		<h2>UPDATE MENU</h2>

	</header>



	<form action="menuupdate" method="post">
		<label>NAME</label><br> <input type="text"
			value="<%=menu.getName()%>" name="name"> <br> <label>DESCRIPTION</label>
		<br>

		<textarea name="description" rows="10" cols="40"><%=menu.getDescription()%></textarea>
		<br> <label>PRICE</label><br> <input type="number"
			name="price" value="<%=menu.getPrice()%>"> <br> <label>CATEGORY</label><br>
		<input type="text" name="category" value="<%=menu.getCategory()%>">
		<br> <label>ID_MENU</label><br> <input type="number"
			value="<%=id%>" name="idmenu"> <br> <br> <input
			type="submit" value="update">

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