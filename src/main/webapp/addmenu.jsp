<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
<link rel="stylesheet" href="css/MENU.css">  <!-- External CSS -->
</head>
<body>

  <header>
   <h2> ADD MENU ITEM</h2>
   <h1> <%@include file="message.jsp" %></h1>
  </header>

  <!-- Navigation Links -->
  <nav>
    <a href="admin.jsp">Home</a>
  </nav>

  <form action="AddMenuServlet" method="post">
        <label>Food Name:</label>
        <input type="text" name="name" required placeholder="enter food name"><br><br>

        <label>Description:</label>
        <textarea name="description" required   placeholder="write here"></textarea><br><br>

        <label>Price:</label>
        <input type="number" name="price" placeholder="enter price" step="0.01" required><br><br>

        <label>Category:</label>
        <select name="category" required>
            <option value="">enter category</option>
            <option value="BREAKFAST">BREAKFAST</option>
            <option value="LUNCH">LUNCH</option>
            <option value="DINNER">DINNER</option>
             <option value="SNACKS">SNACKS</option>
        </select><br><br>
        
        <label>Image URL:</label>
        <input type="text" placeholder="enter url" name="image_url"><br><br>

        <button type="submit">Add Menu</button>
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
