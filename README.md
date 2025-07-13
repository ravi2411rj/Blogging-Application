# Blogging-Application

A fully functional **blogging platform** built using **Spring Boot**. Designed to simulate real-world backend architecture, it provides RESTful APIs for core blogging operations and integrates essential enterprise features like authentication, caching, and API docs.

---

## Features

- **User Management**
  - Register and authenticate users
  - Role-based access (e.g., Author, Admin)

- **Blog Posts**  
  - Create, read, update, and delete articles  
  - Support for rich content and metadata (title, body, timestamp)

- **Commenting**  
  - Nested comments for articles  
  - APIs to fetch, add, edit, and delete comments

- **Authentication & Security**  
  - JWT-based stateless authentication  
  - Secure endpoints with role-based authorization

- **Performance Enhancements**  
  - Redis caching for hot data (e.g., popular posts)  
  - Asynchronous loading for large blog retrieval via pagination and lazy loading

- **Documentation**  
  - Interactive Swagger/OpenAPI UI  
  - Exportable Postman collections

- **Database**  
  - JPA/Hibernate for ORM  
  - ER diagrams and DB schema included

- **Developer Convenience**  
  - Dockerized backend for easy local setup  

---

## Tech Stack

| Layer         | Technology                          |
|---------------|-------------------------------------|
| Language      | Java                                |
| Framework     | Spring Boot                         |
| Persistence   | JPA / Hibernate with MySQL          |
| Authentication| JWT, Spring Security                |
| Caching       | Redis                               |
| API Docs      | Swagger UI                          |
| Container     | Docker                              |

---

## Project Structure
```
com.blogspot.app
├── config
├── controller
├── dto
├── entity
├── exception
├── repository
├── security
├── service
└── utils
```
---

## Setup & Run

1. Clone the repo:
   ```bash
   git clone https://github.com/ravi2411rj/Blogging-Application.git
   cd Blogging-Application
    ```
2. Set up environment
   - Update `application.properties` or `application.yml` with your database (MySQL) and Redis credentials.
   - Ensure MySQL and Redis instances are running (either locally or via Docker containers).

3. Build and run
    ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
    ```

4. Access the application
   - Swagger UI: `http://localhost:8080/swagger-ui/`
   - API Base URL: `http://localhost:8080/api/`

---

## Authentication

1. Register and log in to get your JWT token.
2. Use the token in the Authorization header for protected routes:
   ```
   Authorization: Bearer <your_token_here>
   ```

---

## API Documentation

 - Swagger UI: (to be updated)
 - Postman Collection: (to be updated)

---

## ER Diagram / Schema

 - The ER diagram is located in src/main/resources/diagram.png (to be updated).
 - Key entities:
   - User
   - Post
   - Comment
   - Category

---

## Learnings & Objectives

This project was built to:
- Gain hands-on experience in building production-like backend services
- Apply backend best practices including layered architecture and modularity
- Work with JWT, Redis, Swagger, and Docker in a real use-case
- Prepare for Java backend developer roles (SDE/SWE)

---

## Contributing

Contributions are welcome!
- Fork the repository
- Create a feature branch
- Commit and push your changes
- Open a pull request

---

## Contact

**Ravi Ranjan Shah** | Backend Developer | SDE Aspirant
* **Email:** ravi2411rj@gmail.com
* **LinkedIn:** [https://www.linkedin.com/in/ravi2411rj/](https://www.linkedin.com/in/ravi2411rj/)

---

## License
This project is open-source and available under the MIT License.
