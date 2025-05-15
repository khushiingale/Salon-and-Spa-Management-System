# 💇‍♀️ Salon and Spa Management System 💆‍♂️

A full-stack web application designed to streamline and digitalize salon and spa operations. Built using **Spring Boot**, **Thymeleaf**, and **MySQL**, this project enables efficient service management, user-friendly booking systems, and administrative control — all under one platform.

---

## 🔍 Overview

The Salon and Spa Management System is aimed at enhancing the digital experience of both salon administrators and customers. It offers real-time service management, appointment scheduling, and booking modification functionalities.

---

## 🚀 Features

### 👩‍💼 Admin Capabilities
- Secure login access
- Add new services with name, description, and price
- Update existing service details
- Delete services when not required
- View all customer bookings

### 👩 User Capabilities
- Signup with form validation
- Secure login access
- View available services
- Book a service with a selected date
- Update or cancel an existing booking

---

## 🧱 Tech Stack

| Layer          | Technology         |
|----------------|--------------------|
| **Backend**    | Spring Boot        |
| **Frontend**   | Thymeleaf, HTML, CSS |
| **Database**   | MySQL              |
| **ORM**        | Hibernate (Spring Data JPA) |
| **Build Tool** | Maven              |
| **Validation** | Hibernate Validator (JSR 380) |

---

## 🗃️ Project Structure
src/
├── main/
│ ├── java/com/salonspa/
│ │ ├── controller/
│ │ ├── model/
│ │ ├── repository/
│ │ ├── service/
│ │ └── SalonSpaApplication.java
│ └── resources/
│ ├── templates/
│ │ ├── login.html
│ │ ├── signup.html
│ │ ├── admin-dashboard.html
│ │ └── user-dashboard.html
│ └── application.properties


---

## ⚙️ Configuration

### ✅ Database Setup

1. Create the database in MySQL:
```sql
CREATE DATABASE salon_spa_db;


2. Update the database credentials in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/salon_spa_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

📬 Email/SMS notifications for booking confirmation and cancellations

🔐 Optional integration of Spring Security for role-based access control


