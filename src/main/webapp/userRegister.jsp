<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account - Restaurant</title>
<link rel="stylesheet" href="css/registeruser.css">
</head>
<body>


 <div class="form-container">
    <h2>Create Account</h2>

    <!-- Show message if passed from servlet -->
    <%
        String msg = request.getParameter("msg");
        if(msg != null){
    %>
        <p style="color:green; text-align:center;"><%= msg %></p>
    <%
        }
    %>

    <form action="UserRegisterServlet" method="post">
      <label>Full Name</label><br>
      <input type="text" name="name" placeholder="Enter your full name" required><br><br>

      <label>Email</label><br>
      <input type="email" name="email" placeholder="Enter your email" required><br><br>

      <label>Password</label><br>
      <input type="password" name="password" placeholder="Enter a password" required><br><br>

      <label>Confirm Password</label><br>
      <input type="password" name="confirmPassword" placeholder="Re-enter password" required><br><br>

      <button type="submit">Register</button>
    </form>

    <div class="extra-option">
      <p>Already have an account?</p>
      <a href="userlogin.jsp" class="btn-create">Login</a>
    </div>
  </div>

</body>
</html>