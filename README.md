# Ticket Resolution System (TRS)

## Overview

The Ticket Resolution System (TRS) is a web-based application designed to help organizations manage and resolve customer support tickets efficiently. The system allows users to raise issues, track their ticket status, and enables administrators to manage and resolve tickets in an organized workflow.

## Features

* User Registration and Login
* Create Support Tickets
* View Personal Tickets
* Ticket Status Tracking (OPEN, IN_PROGRESS, RESOLVED)
* User Dashboard with Ticket Statistics
* Admin Dashboard for Managing Tickets
* Role-based navigation between dashboards

## Technologies Used

### Frontend

* React
* React Router
* Axios
* HTML/CSS

### Backend

* Spring Boot
* REST APIs

### Database

* MySQL

## System Workflow

1. User registers and logs into the system.
2. User creates a support ticket describing their issue.
3. The ticket is stored in the database.
4. Admin can view and manage all tickets.
5. Admin updates the ticket status.
6. Users can track their ticket progress through the dashboard.

## System Workflow

```mermaid
flowchart TD
    A[User] --> B[Register / Login]
    B --> C[Create Ticket]
    C --> D[Ticket Stored in Database]
    D --> E[Admin Reviews Ticket]
    E --> F[Admin Updates Status]
    F --> G[User Tracks Ticket Progress]

## Project Structure

```
TRS-Project
│
├── frontend
│   ├── components
│   ├── pages
│   ├── api
│   └── utils
│
├── backend
│   ├── config
│   ├── controller
|   ├── dto
│   ├── enums
│   └── mapper
|   ├── model
│   ├── repository
│   └── service
│   └── util
│
```

## API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| POST | /api/auth/sign-up | Register new user |
| POST | /api/auth/login | User login |
| GET | /api/ticket/user/{id} | Get user tickets |
| POST | /api/ticket | Create new ticket |
| PUT | /api/ticket/{id} | Update ticket status |

## How to Run the Project

### Backend (Spring Boot)

1. Import the backend project into Spring Tool Suite or IntelliJ.
2. Configure the MySQL database in `application.properties`.
3. Run the Spring Boot application. (Port:8081)

### Frontend (React)

1. Navigate to the frontend folder.
2. Install dependencies:

```
npm install
```

3. Start the React application:

```
npm start
```
Runs on : http://localhost:3000/


## Future Enhancements

* JWT-based authentication
* Email notifications for ticket updates
* File attachments for tickets
* Deployment to cloud platforms

## Learning Outcomes

Through this project, I learned:

* React Hooks (useState, useEffect)
* API integration using Axios
* Building REST APIs with Spring Boot
* Handling role-based application flow
* Managing state and dynamic UI updates

## Author

Monisha M

---

This project was developed as part of learning full-stack web development using React and Spring Boot.
