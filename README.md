# Bus Ticket Booking System

A simple Bus Ticket Booking System developed using Java, Spring Boot, Spring Data JPA, Hibernate, MySQL and REST APIs.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- REST API
- Postman
- Maven

## Features

- User Management
- Bus Management
- Bus Booking
- Seat Availability
- CRUD Operations
- MySQL Database Integration

## REST API Endpoints

### Users
- POST `/users` - Create User
- GET `/users` - Get All Users
- GET `/users/{id}` - Get User by ID
- PUT `/users/{id}` - Update User
- DELETE `/users/{id}` - Delete User

### Buses
- POST `/buses` - Add Bus
- GET `/buses` - Get All Buses
- GET `/buses/{id}` - Get Bus by ID

### Bookings
- POST `/bookings` - Create Booking
- GET `/bookings` - Get All Bookings

## Database

MySQL database is used for storing users, buses and booking information.

## How to Run

1. Clone the repository.
2. Create a MySQL database named `ticket_booking`.
3. Configure MySQL credentials in `application.properties`.
4. Run the Spring Boot application.
5. Test the REST APIs using Postman.
