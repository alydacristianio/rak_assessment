# Student Fee Collection Service

## Overview
The Student Fee Collection Service is a Spring Boot microservice responsible for collecting student fees and generating payment receipts.  

It communicates with the **Student Management Service** to fetch student details before generating receipts.

## Responsibilities
- Collect student fees
- Generate fee receipts
- Retrieve receipt by ID
- Retrieve all receipts for a student

## Tech Stack
- Java 21
- Spring Boot 3.x
- Spring Data JPA
- H2 In-Memory Database
- OpenAPI / Swagger
- Gradle

## Swagger UI
Once the application is running, you can access the Swagger UI at:
http://localhost:8082/swagger-ui.html

## Postman Collection
You can import the Postman collection from the `postman` directory to test the APIs.

## How to Run

### Prerequisites
- Java 21+
- Gradle
- Student Management Service running on port 8081

## Features / APIs

| Endpoint                     | Method | Description                            |
|-------------------------------|--------|----------------------------------------|
| `/api/fees/collect`          | POST   | Collect fee for a student               |
| `/api/fees/{id}`             | GET    | Get receipt by receipt ID               |
| `/api/fees/student/{id}`     | GET    | Get all receipts for a student         |

### Steps
```bash
./gradlew bootRun
```

## H2 Database Console
You can access the H2 database console at:
http://localhost:8082/h2-console
- JDBC URL: `jdbc:h2:mem:feecollectiondb`
- Username: `sa`
- Password: ``
- Driver Class: `org.h2.Driver`

