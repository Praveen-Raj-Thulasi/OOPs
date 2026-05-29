# Banking Management System

A simple console-based Banking Management System built using **Java**, **JDBC**, and **MySQL**.

This project demonstrates CRUD operations, database connectivity, and basic banking functionalities such as account creation, deposits, withdrawals, and account management.

---
## 📌 Project Goals

The primary goals of this project are:

* Learn and implement **Java JDBC connectivity**
* Perform **CRUD operations** with MySQL
* Understand **MVC-style separation** using Controller, View, and Model classes
* Build a simple real-world banking application
* Practice exception handling and SQL integration
* Demonstrate object-oriented programming concepts in Java

---

## 🚀 Features

### 👤 User Features

* Create a bank account
* View account details
* Check account balance
* Deposit money
* Withdraw money

### 🛠️ Admin Features

* View all accounts
* Search account by ID
* Delete account

---

## 🏗️ Project Structure

```bash
Banking-System/
│
├── Main.java
├── Account.java
├── BankController.java
├── BankView.java
├── DBConnection.java
├── mysql-connector-j-9.7.0.jar
```

---

## ⚙️ Technologies Used

* Java
* JDBC
* MySQL
* Console-based UI

---

## 🗄️ Database Setup

Create a MySQL database:

```sql
CREATE DATABASE practice_db;
```

Create the account table:

```sql
CREATE TABLE account (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    balance INT
);
```

Update your database credentials inside `DBConnection.java`.

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/practice_db",
    "root",
    "your_password"
);
```

---

## ▶️ How to Run

### 1. Compile the project
```bash
javac -cp ".:lib/mysql-connector-j-9.7.0.jar" *.java
```

### 2. Run the application

```bash
java -cp ".:lib/mysql-connector-j-9.7.0.jar" Main   
```

---

## 📂 Core Components

### `BankController.java`

Handles application logic and database operations such as:

* Insert account
* Search account
* Deposit/Withdraw
* Delete account

### `BankView.java`
Handles user interaction through console menus and display methods.

### `Account.java`
Represents the account model with fields:

* id
* name
* balance

### `DBConnection.java`
Establishes JDBC connection with MySQL database.

### `Main.java`
Entry point of the application.


## 🔮 Future Improvements

* Add authentication system
* Implement transaction history
* Add password encryption
* Create GUI using Java Swing/JavaFX
* Improve exception handling
* Add unit testing
* Add transfer money feature

---

## 📄 License
This project is developed for educational and learning purposes.
