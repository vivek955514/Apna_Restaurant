
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
<title>Change Password</title>
<link rel="stylesheet" href="css/changepass.css">
</head>
<body>

 
 
 <!-- Header -->
  <header>
   <h1> Change Password</h1>
   <h1><%@include file="message.jsp"%></h1>
  </header>

  <!-- Form Section -->
  <div class="form-container">
    <h2>Update Your Password</h2>
    <form action="ChangePasswordServlet" method="post">
      <div class="input-box">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" placeholder="Enter your username" required>
      </div>
      <div class="input-box">
        <label for="oldPassword">Old Password</label>
        <input type="password" name="oldPassword" id="oldPassword" placeholder="Enter old password" required>
      </div>
      <div class="input-box">
        <label for="newPassword">New Password</label>
        <input type="password" name="newPassword" id="newPassword" placeholder="Enter new 4 digit  password" required>
      </div>
      <div class="input-box">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Re-enter new password" required>
      </div>
      <button type="submit" class="btn">Change Password</button>
    </form>
  </div>

  <!-- Footer -->
  <footer>
    &copy; 2025 Admin Panel | All Rights Reserved
  </footer>

</body>
</html>