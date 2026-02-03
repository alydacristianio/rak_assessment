# Student Management Service

## Overview
Student Management Service is a Spring Boot microservice responsible for managing student information in a school system.  
It provides RESTful APIs to add students and retrieve student details.

This service is part of a **microservices-based Student Fee Collection system**.

## Responsibilities
- Add new students
- Retrieve student details by ID
- List all students

## Tech Stack
- Java 21
- Spring Boot 3.x
- Spring Data JPA
- H2 In-Memory Database
- OpenAPI / Swagger
- Gradle

## Swagger UI
Once the application is running, you can access the Swagger UI at:
http://localhost:8081/swagger-ui.html

## Postman Collection
You can import the Postman collection from the `postman` directory to test the APIs.

## How to Run

### Prerequisites
- Java 21+
- Gradle

## Features / APIs

| Endpoint               | Method | Description                        |
|------------------------|--------|------------------------------------|
| `/api/students`        | GET    | Get all students                   |
| `/api/students/{id}`   | GET    | Get student by ID                  |
| `/api/students`        | POST   | Add a new student  

### Steps
```bash
./gradlew bootRun
```

## H2 Database Console
You can access the H2 database console at:
http://localhost:8081/h2-console
- JDBC URL: `jdbc:h2:mem:studentdb
- Username: `sa`
- Password: ``
- Driver Class: `org.h2.Driver`