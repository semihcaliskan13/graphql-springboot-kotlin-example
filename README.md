# GraphQL-Spring-Boot-Kotlin-MySQL-Docker Application

## Introduction

This project is a GraphQL-based Spring Boot application developed in Kotlin, utilizing Gradle as the build tool, and Docker for containerization. It integrates with a MySQL database to manage authors and their books.

## Prerequisites

Before you begin, ensure you have the following installed on your development machine:

- [Java](https://www.java.com/en/download/)
- [Kotlin](https://kotlinlang.org/docs/getting-started.html)
- [Gradle](https://gradle.org/install/)
- [Docker](https://www.docker.com/get-started)
- MySQL

```
spring.datasource.url=jdbc:mysql://localhost:3306/your_database 

spring.datasource.username=your_username

spring.datasource.password=your_password
```

```
query {
  getAuthorById(id: "authorId") {
    id
    firstName
    lastName
    books {
      id
      name
      pageCount
    }
  }
}
```
