This project implements a microservices-based Student Fee Collection system using Spring Boot.
It consists of two independent services:

Student Service – Manages student information

Fee Service – Manages fee collection and receipts

The services communicate with each other using REST APIs and follow clean architecture and REST best practices.

| Service         | Responsibility                                        |
| --------------- | ----------------------------------------------------- |
| Student Service | Student CRUD operations                               |
| Fee Service     | Fee collection, receipts, inter-service communication |

| Service         | Database         |
| --------------- | ---------------- |
| Student Service | `students` table |
| Fee Service     | `receipts` table |

Each service provides:

✅ Swagger UI

✅ Postman Collection

✅ README with detailed instructions
