# Hotel Booking Notification Service

> **Project showcase:** [Browse the static portfolio](portfolio/index.html) · [GitHub Pages publishing guide](PORTFOLIO.md)


A Spring Boot microservice responsible for processing hotel booking notifications using Apache Kafka in an event-driven architecture.

## Features

- Receives booking events from Apache Kafka
- Generates booking confirmation notifications
- Stores notifications in H2 Database
- REST API to retrieve notifications
- Event-driven communication with Booking Service

## Technologies

- Java 21
- Spring Boot
- Spring Data JPA
- Apache Kafka
- H2 Database
- Maven
- Docker

## Project Structure

```
notification-service
│
├── config
├── controller
├── dto
├── entity
├── event
├── kafka
├── repository
├── service
└── resources
```

## REST API

### Get All Notifications

```
GET /notifications
```

### Example Response

```json
[
  {
    "id":1,
    "bookingId":1,
    "customerName":"Adam",
    "customerEmail":"adam123@gmail.com",
    "notificationType":"BOOKING_CONFIRMED",
    "status":"SENT"
  }
]
```

## Event Flow

Booking Service
↓

Apache Kafka
↓

Notification Service
↓

H2 Database
↓

REST API

## Author

**Tanjid Islam Tanim**

Bachelor in Software Engineering (Hons) 
University of Wollongong Malaysia
