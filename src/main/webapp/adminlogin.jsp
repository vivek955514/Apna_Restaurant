<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Form</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      background: linear-gradient(135deg, #32cb110d, #25fc3108);
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .login-box {
      background: #fff;
      padding: 40px 30px;
      border-radius: 15px;
      box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.2);
      width: 320px;
      text-align: center;
    }

    .login-box h2 {
      margin-bottom: 20px;
      color: #6a11cb;
    }

    .input-box {
      margin-bottom: 20px;
      position: relative;
    }

    .input-box input {
      width: 100%;
      padding: 12px;
      border: none;
      border-bottom: 2px solid #6a11cb;
      outline: none;
      font-size: 16px;
      background: transparent;
      transition: 0.3s;
    }

    .input-box input:focus {
      border-bottom: 2px solid #2575fc;
    }

    .btn {
      width: 100%;
      padding: 12px;
      border: none;
      background: linear-gradient(90deg, #ff512f, #dd2476);
      color: white;
      font-size: 16px;
      font-weight: bold;
      border-radius: 25px;
      cursor: pointer;
      transition: 0.3s;
    }

    .btn:hover {
      background: linear-gradient(90deg, #dd2476, #ff512f);
      transform: scale(1.05);
    }
  </style>
</head>
<body>
  <div class="login-box">
  <%@include file="message.jsp"%>
    <h2> Admin Login Form</h2>
    <form  action ="AdminLoginServlet1"  method="post">
      <div class="input-box">
        <input type="text"  name="username" placeholder="Username" required>
      </div>
      <div class="input-box">
        <input type="password"  name="password" placeholder="Password" required>
      </div>
      <button type="submit" class="btn">Login</button>
    </form>
  </div>
</body>
</html>
