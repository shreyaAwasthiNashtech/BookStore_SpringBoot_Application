# Bookstore Inventory & Orders
Welcome to the Bookstore Inventory & Orders system, a full-stack web application built with Spring Boot, Spring Data JPA, Hibernate, Thymeleaf, and PostgreSQL. It allows users to browse books, manage a shopping cart, place orders, and view their order history. Admin functionality for managing books, authors, and categories is also included.

# What We Built & Why
The goal of this project was to design a clean, modular bookstore system with realistic features, combining server-side rendering and backend logic. Here's what each part does:

# Backend with Spring Boot
Handles all HTTP requests and business logic.
Cleanly separates concerns using Controllers, Services, Repositories, and Models.

**Spring Data JPA + Hibernate**
Manages database operations like saving, updating, deleting, and fetching books, authors, orders, etc.
Automatically maps Java classes to database tables.

**PostgreSQL Database**
Stores all persistent data like books, orders, authors, and categories.
Chosen for its reliability, support for constraints, and wide industry use.

**Thymeleaf Templates**
Renders HTML pages dynamically with data from the backend.
Offers form binding, conditionals, and loops to display lists and forms.

# What We Added (and Why)
**Models**
We created five core entity classes:

Book.java – Represents each book, including its title, price, author, and category.
Author.java – Stores authors for reference when adding books.
Category.java – Used to classify books (e.g. Fiction, Sci-Fi).
CartItem.java – Temporarily holds items added to the cart.
Order.java – Represents a confirmed purchase, storing a list of books and timestamp.

These map directly to database tables using JPA annotations.

**Services**
All core logic lives here:

CartService – Holds cart items and supports add/remove/clear operations.
OrderService – Handles placing an order and retrieving past orders.

This keeps our controllers clean and focused only on handling requests.

**Controllers**
These serve as entry points to the system:

HomeController – Displays the homepage with book listings.
BookController – Admin panel for adding, updating, and removing books.
CartController – Manages the cart and lets users proceed to checkout.
OrderController – Places an order and shows previous orders.

Each controller fetches or sends data via services and forwards it to Thymeleaf templates.

**Thymeleaf Templates**
User interface is built using server-side HTML:
index.html – Homepage that shows all books with "Add to Cart" buttons.
cart.html – Displays selected books and allows order placement.
orders.html – Shows previous orders with timestamp.
books.html – Admin UI to add/edit/delete books with dropdowns for author/category.

**Data Seeder (CommandLineRunner)**
Instead of manually inserting test data, we used a CommandLineRunner that adds default authors, categories, and books when the app starts. This helps validate functionality straight away.

**Application Flow (Request to Database and Back)**
Here’s what happens when a user interacts with the app:

Browser – User clicks buttons or submits forms (e.g. "Add to Cart").
Thymeleaf – The HTML template passes that request to a Spring controller using forms or links.
Controller – Receives the request (e.g. POST /cart/add) and delegates it to a service.
Service – Processes the logic (e.g. adds a book to cart or saves an order).
Repository – Talks to the database using Spring Data JPA to perform CRUD operations.
Database – PostgreSQL stores or returns the data (e.g. list of books).
Response – Data flows back the same way and is displayed as an updated page.

This layered architecture improves maintainability, scalability, and testing.

**Mandatory Configuration for PostgreSQL + JPA**
In application.properties, the following settings must be added to connect to your PostgreSQL database and allow Hibernate to work:

#PostgreSQL DB connection
spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.datasource.driver-class-name=org.postgresql.Driver

#Hibernate Dialect
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
What does spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect do?
It tells Hibernate which SQL dialect to use so it can generate valid SQL commands for PostgreSQL.
Every database has its own flavour of SQL, and this line ensures Hibernate speaks the correct one.

Without it, Hibernate can’t auto-detect the dialect and throws errors on startup.

# How to Run This App

**1. Create the database**
CREATE DATABASE bookstore;

**2. Add your database credentials**
Edit src/main/resources/application.properties with your actual PostgreSQL username and password.

**3. Build the project**
In the terminal:
./mvnw clean install

**4. Start the app**
./mvnw spring-boot:run

**5. Open the app in browser**
Visit: http://localhost:8080
You’ll see the homepage with a list of books!

# Things You Need To Build & Run
To ensure the app runs smoothly, make sure you have:
1. Java 17 or higher installed
2. PostgreSQL running locally with a bookstore DB
3. Maven installed (or use mvnw included in the project)
4. Required dependencies in your pom.xml:
spring-boot-starter-web
spring-boot-starter-thymeleaf
spring-boot-starter-data-jpa
postgresql driver

# Conclusion
This project is a complete beginner-to-intermediate level full-stack application that helps you understand how to build a real-world system using Spring Boot. It touches every layer, from frontend templates to database handling.
Everything is written to be extendable and clean. You now have a working foundation for any inventory or ordering system.

Happy coding!
— Shreya Awasthi
