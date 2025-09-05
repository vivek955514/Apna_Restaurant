🍴 Apna-Restaurant

Apna-Restaurant is a dynamic web application built to provide a seamless online food ordering and restaurant management system. It allows customers to explore the menu, service , place orders, book table, and enjoy a smooth user experience, while also enabling the admin to manage menu items and view customer orders efficiently.

🚀 Features

✅ User Authentication – Secure login and signup for users and admin

✅ Dynamic Menu – Breakfast, Lunch, and Dinner categories

✅ Place Orders – Customers can order food directly from the menu

✅ Booking Table – Customers can book the Table 

✅ Order Management – Admin can view and track orders

✅ Service Management – Admin can view and add,update services

✅ Responsive UI – Modern and mobile-friendly design using Bootstrap

✅ Database Integration – Menu and orders stored in MySQL

🛠️ Tech Stack

Frontend: HTML, CSS, JavaScript, Bootstrap

Backend: Java, JSP, Servlets,JDBC

Database: MySQL

Server: Apache Tomcat

📂 Project Structure

/connection
Handles the database connectivity. Contains classes for establishing and managing the connection with MySQL.

/controller
Contains Servlets that handle HTTP requests and responses. They act as the entry point for user interactions (login, menu display, order placement, etc.).

/dao (Data Access Object)
Responsible for direct database operations such as CRUD (Create, Read, Update, Delete). It interacts with the database using SQL queries.

/model
Holds the Java classes (POJOs) representing entities such as User, Menu, Order. These are simple objects used to transfer and hold data.

/service
Contains the business logic of the application. It acts as a bridge between the controller and DAO layers, ensuring clean separation of concerns.

/validation
Contains input validation logic (e.g., checking valid email, preventing SQL injection, etc.) to ensure data correctness and security.
