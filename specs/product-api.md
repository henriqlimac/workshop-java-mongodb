# Product API Specifications

## Context
We are building a scalable backend to receive Discord user 
IDs along with an array/list of products linked to the user ID.

## Requirements
- CRUD for the product linked to the user ID and the user itself.
- Create a Clean Code architecture following the SOLID principles.
- Error handling and validation for the API requests.
- Cleanup and refactor the code to ensure maintainability and readability.
- Do not add any additional features or functionalities beyond what is specified in the requirements. Focus on implementing the core functionality as outlined in the tasks below.
- Do not implement any authentication or authorization mechanisms for the API. The focus should be solely on the core functionality of handling user IDs and linked products.
- Clean broken code and ensure that the codebase is free of any syntax errors or logical issues before proceeding with the implementation of the tasks.

## Tasks
### Task 1.0: Create User Logic
1.1 The User domain entity will receive the following things:
    1.1 String id: Discord User ID;
    1.2 List<Product> products: Array/List of products;
    1.3 Create getters and setters for the User model/entity;
    1.4 Create hashCode and equals methods for the User model/entity.
1.2 Create User DTO (Data Transfer Object) to receive the data from the API request;
1.3 Create User Repository to handle database operations for the User entity;
1.4 Create User Service to handle business logic for creating a user and linking products to the user ID;
1.5 Create User Controller to handle API requests for creating a user and linking products;
- Requirements: 2.0 to 2.5 should be implemented before 1.0 to 1.5.

### Task 2.0: Create Product Logic
2.1 The Product domain entity will receive the following things:
    2.1 String id: Unique identifier for the product;
    2.2 String name: Name of the product;
    2.3 Double averageRange: Range of the product;
    2.4 Create getters and setters for the Product model/entity;
    2.5 Create hashCode and equals methods for the Product model/entity.
2.2 Create Product DTO (Data Transfer Object) to receive the data from the API request;
2.3 Create Product Repository to handle database operations for the Product entity;
2.4 Create Product Service to handle business logic for creating a product and linking it to the User entity;
2.5 Create Product Controller to handle API requests for creating a product and linking it