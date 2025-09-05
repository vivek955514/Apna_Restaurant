<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/loginuser.css">

</head>
<body>


<div class="form-container">
    <h2>Login</h2>
     <h1> <%@include file="message.jsp" %></h1>

    <!-- Show message if passed from servlet -->
    

    <form action="UserLoginServlet" method="post">
      <label>Email</label><br>
      <input type="email" name="email" placeholder="Enter your email" required><br><br>

      <label>Password</label><br>
      <input type="password" name="password" placeholder="Enter your password" required><br><br>

      <button type="submit">Login</button>
    </form>

    <div class="extra-option">
      <p>Don’t have an account?</p>
      <a href="userRegister.jsp" class="btn-create">Create Account</a>
    </div>
  </div>

</body>
</html>