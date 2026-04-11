# Discord User Products Mapping API (DUPM)

## Project Overview
This is a microservice backend application built with **Spring Boot** and **MongoDB**. It serves as a service that receives a **Discord User ID** as a parameter and links one or more hardware/software **products** to that User. 

The main idea is to process and store this information so that another external application (which stores the real Discord user metrics alongside other external data) can use the Discord User ID as an anchor to fetch the user's product preferences and price ranges.

## Core Features
*   **User Management**: Store users uniquely identified by their `discordId`.
*   **Product Management**: Store distinct products with dynamically calculated price tolerances.
    *   *Base Range*: A base target value (`averageRange`).
    *   *Tolerance Calculation*: A percentage (`tolerance`) used to automatically calculate and save bounds (`lowerTolerance` and `higherTolerance`) in the database.
*   **Relational Embedded Mapping**: Each user contains a list of their preferred products.
*   **Mocked Environment Start**: Pre-loads a mocked collection of Users and Hardware Products (e.g., Laptops, Mice, Keyboards) every time the system runs initialization routines.

## Built With
*   **Java 25** (Compatible with modern LTS)
*   **Spring Boot** (v3.x / v4.x)
*   **Spring Web** (RESTful APIs)
*   **Spring Data MongoDB**
*   **Maven**

## Architecture and Folder Structure
The project follows a clean, Domain-Driven Design (DDD) inspired structure utilizing **SOLID** principles. Below is an advanced breakdown of the `src/main/java` directory:

```text
src/main/java/dev/henriqlimac/workshopmdb/
├── SbmdbApplication.java              # Main Spring Boot application class
├── config/                            # Application configuration
│   └── Instantiation.java             # Seed data and mock initializations
├── domain/                            # Domain entities (Models)
│   ├── product/                       # Product domain models
│   │   └── Product.java               # Product document mapping
│   └── user/                          # User domain models
│       └── User.java                  # User document mapping
├── dto/                               # Data Transfer Objects
│   ├── product/                       # Product request/response payloads
│   │   └── ProductDTO.java            
│   └── user/                          # User request/response payloads
│       └── UserDTO.java               
├── resources/                         # REST API Controllers (Endpoints)
│   ├── product/                       # Product API routers
│   │   └── ProductResource.java       
│   └── user/                          # User API routers
│       └── UserResource.java          
├── respositories/                     # Database repository interfaces
│   ├── product/                       # Product MongoDB interfaces
│   │   └── ProductRepository.java     
│   └── user/                          # User MongoDB interfaces
│       └── UserRepository.java        
└── services/                          # Business logic layer
    ├── exception/                     # Global/Custom error handling
    │   ├── ObjectNotFoundException.java 
    │   ├── ResourceExceptionHandler.java  
    │   └── StandardError.java             
    ├── product/                       # Product business logic
    │   └── ProductService.java        # Calculates tolerances, manages DB actions
    └── user/                          # User business logic
        └── UserService.java           # Maps users dependencies
```

*(Create a `src/main/resources/application.properties` for local variables configuration)*

## Running the Application

### Prerequisites
1. Ensure you have **Java** installed.
2. Have **MongoDB** running locally without authentication (or update properties if auth is needed).

### Start via Maven
You can start the server locally using the integrated maven wrapper:
```bash
# On Windows
./mvnw.cmd spring-boot:run

# On Linux/Mac
./mvnw spring-boot:run
```

### Running Tests
To execute the application testing context and verify connection to MongoDB:
```bash
./mvnw test
```

## API Endpoints

### Users (`/users`)
*   `GET /users` - Retrieve all users and their linked products.
*   `GET /users/{id}` - Retrieve a specific user by MongoDB ID.
*   `POST /users` - Create a new user (receives `discordId` and array of `products`).
*   `DELETE /users/{id}` - Delete a user.

### Products (`/products`)
*   `GET /products` - Retrieve all products available in the database.
*   `GET /products/{id}` - Find a specific product.
*   `POST /products` - Create a new product.
*   `PUT /products/{id}` - Update a product (Updates `averageRange` and automatically recalculates tolerances).
*   `DELETE /products/{id}` - Remove a product.

