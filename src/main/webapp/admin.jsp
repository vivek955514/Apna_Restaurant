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
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      background: #f4f6f9;
    }

    /* Header */
    header {
      background: #2c3e50;
      color: white;
      padding: 15px;
      text-align: center;
      font-size: 22px;
      font-weight: bold;
    }

    /* Navigation */
    nav {
      background: #34495e;
      padding: 12px;
      display: flex;
      justify-content: center;
      align-items: center;
      gap: 15px;
      position: relative;
    }

    nav a {
      text-decoration: none;
      color: white;
      padding: 8px 15px;
      border-radius: 5px;
      font-weight: bold;
      transition: 0.3s;
    }

    nav a:hover {
      background: #1abc9c;
      color: black;
    }

    /* Dropdown container */
    .dropdown {
      position: relative;
      display: inline-block;
    }

    .dropdown a {
      cursor: pointer;
    }

    /* Dropdown content */
    .dropdown-content {
      display: none;
      position: absolute;
      background: #34495e;
      min-width: 180px;
      box-shadow: 0px 4px 8px rgba(0,0,0,0.2);
      border-radius: 5px;
      z-index: 1;
    }

    .dropdown-content a {
      display: block;
      padding: 10px;
      color: white;
      text-align: left;
      font-weight: normal;
    }

    .dropdown-content a:hover {
      background: #1abc9c;
      color: black;
    }

    /* Show dropdown on hover */
    .dropdown:hover .dropdown-content {
      display: block;
    }

    /* Main Section */
    .content {
      padding: 120px;
      text-align: center;
    }

    /* Footer */
    footer {
      background: #2c3e50;
      color: white;
      text-align: center;
      padding: 12px;
      position: fixed;
      bottom: 0;
      width: 100%;
    }
  </style>
</head>
<body>
  <!-- Header -->
  <header>
    <h1>Admin Panel</h1>
    <h2><%@include file="message.jsp" %></h2>
  </header>

  <!-- Navigation Links -->
  <nav>
    <a href="#">Home</a>
    <a href="addservice.jsp">Add Service</a>
    <a href="addmenu.jsp">Add Menu</a>
    
    <a href="changepassword.jsp">Change Password</a>
    
    <!-- Dropdown -->
    <div class="dropdown">
      <a>Pages ▼</a>
      <div class="dropdown-content">
        <a href="ReadMessageServlet">Read Message</a>
        <a href="ReadBookingModuleServlet">View All Bookings</a>
        <a href="ReadServiceDeleteUpdateModule">Read Service</a>
         <a href="ReadMenuDeleteUpdateModule">Read Menu</a>
          <a href="ReadOrderModuleServlet">Read Order</a>
      </div>
    </div>

    <a href="<%= request.getContextPath() %>/LogoutServletController">Log Out</a>
  </nav>

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
