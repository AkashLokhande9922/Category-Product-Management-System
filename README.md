# Category-Product Management System

This is a Spring Boot project that demonstrates CRUD operations for managing Categories and Products, using JPA and Hibernate. The project uses a REST API and has a relational database configuration with server-side pagination for retrieving large sets of data.

## Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- RESTful APIs

## Features

1. **Category Management:**
   - Create, Read, Update, and Delete categories.
   - API supports pagination for listing categories.
   - A category is associated with products using a One-to-Many relationship.
   
2. **Product Management:**
   - Create, Read, Update, and Delete products.
   - API supports pagination for listing products.
   - A products are associated with a category using a Many-to-One  relationship.

3. **Pagination:**
   - All list endpoints (`GET /categories` and `GET /products`) support pagination using query parameters (`?page=(page no.)&size=(page size)`).

4. **Category-Product Relation:**
   - A category can have multiple products, but a product can belong to only one category.
   - When fetching a product, the associated category details are also included.

## API Endpoints

### Category Endpoints:

1. **GET All Categories (with pagination):**
   
2. **Create a New Category:**
   
3. **Get Category by ID:"http:**
   
4. **Update Category by ID:**
   
5. **Delete Category by ID:**


### Product Endpoints:

1. **GET All Products (with pagination):**

2. **Create a New Product:**

3. **Get Product by ID (includes category details):**

4. **Update Product by ID:**

5. **Delete Product by ID:**



## Database Configuration

This project uses MySQL as the database. You can configure your own database by updating the `application.properties` file.

Example configuration for MySQL:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

