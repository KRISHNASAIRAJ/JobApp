# JobApp

## Introduction
Welcome to my Spring Boot Application repository! This is a beginner-level project I started to learn Java Spring Boot. The application is implemented using Spring Boot and JPA (Java Persistence API). It features modular development with each module containing its own service, controller, and repository classes and interfaces. The application includes modules such as Jobs, Companies, and Reviews.

## Project Structure
The project is organized into the following modules:

### Jobs
Handles job-related operations.

### Companies
Manages company-related operations.

### Reviews
Manages reviews of jobs and companies.

Each module consists of:

### Service Layer
Contains the business logic.

### Controller Layer
Handles HTTP requests and responses.

### Repository Layer
Manages database interactions.

## Features
For each module, the following operations are implemented and tested using POSTMAN:

### Add
Add new records to the database.

### Delete
Remove existing records from the database.

### Update
Modify existing records.

### Fetch All
Retrieve all records from the database.

### Fetch by ID
Retrieve specific records by their ID.

## Database
The application uses an H2 database, which is commonly used for development due to its simplicity and in-memory capabilities. The H2 database also provides a web-based console for easy database management and inspection.

## Docker and PostgreSQL
The application has been updated to include Docker support with PostgreSQL and pgAdmin. This allows for more robust database management and easier deployment.

### Docker Setup
The project includes a docker-compose.yaml file to set up the necessary containers for the application, PostgreSQL, and pgAdmin. The Maven Docker plugin is used to build and manage Docker images.

![image](https://github.com/KRISHNASAIRAJ/JobApp/assets/90061814/0c617e56-dd25-4e07-ae49-9f2bccbc2b39)


### PostgreSQL
PostgreSQL is used as the main database for production environments, providing a more scalable and reliable solution compared to the H2 in-memory database.

### pgAdmin
pgAdmin is included to provide a web-based interface for managing the PostgreSQL database.

![image](https://github.com/KRISHNASAIRAJ/JobApp/assets/90061814/202182a5-3961-4cab-8566-805676435041)


## Prerequisites
* Java 11 or higher
* Maven
* Docker and Docker Compose
* POSTMAN (for testing API endpoints)

### Accessing the H2 Database Console
Once the application is running, you can access the H2 database console at:
http://localhost:8080/h2-console

## Testing the API
You can use POSTMAN to test the various endpoints for each module. Below are the endpoints for each module:

![image](https://github.com/KRISHNASAIRAJ/JobApp/assets/90061814/68199612-c458-480d-b5e4-54523221edc3)


### Fetch All Jobs: GET /jobs
### Fetch Job by ID: GET /jobs/{id}

## Companies Module
### Add Company: POST /companies
### Delete Company: DELETE /companies/{id}
### Update Company: PUT /companies/{id}
### Fetch All Companies: GET /companies
### Fetch Company by ID: GET /companies/{id}

## Reviews Module
### Add Review: POST /reviews
### Delete Review: DELETE /reviews/{id}
### Update Review: PUT /reviews/{id}
### Fetch All Reviews: GET /reviews
### Fetch Review by ID: GET /reviews/{id}
