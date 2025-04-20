#Student_data_jDBC
# Student Data Entry System with MySQL

This project aims to develop a Java-based console application for managing student records using a MySQL database. The system enables users to perform various operations such as adding, displaying, searching, updating, and deleting student data. The system uses JDBC (Java Database Connectivity) for database interaction and allows students' details to be stored, retrieved, and modified efficiently.

## Overview of the System

The system is divided into multiple Java classes to handle different functionalities. Each class has a specific responsibility that contributes to the overall operation of the application.

## System Requirements
```
 - Java Development Kit (JDK): Java 8 or later.
 - MySQL Database: Version 5.7 or later.
 - JDBC Driver: MySQL Connector/J (for connecting the Java application with MySQL).
 - Operating System: Compatible with Windows, macOS, and Linux.
 - IDE: Any Java IDE (Eclipse, IntelliJ IDEA, or NetBeans) for running the Java code.
 - MySQL Server: Installed and running with proper access credentials.
 - Database Configuration: Ensure the student_db database and students table are set up according to the SQL schema provided above.
```
### 1. **Database Connection Class (DBConnection.java)**

This class is responsible for managing the connection between the Java application and the MySQL database. It establishes a connection to the database and returns the connection object that other classes can use for database operations.

- **Core Functionality**: It provides a static method to establish the connection using the database URL, username, and password. If the connection fails, it throws an exception to notify the user.

### 2. **Student Class (Student.java)**

The `Student` class is designed to represent the student entity. It includes the attributes that define a student’s details and provides necessary getter and setter methods to access and modify those details.

- **Attributes**:
  - `name`: The student’s full name.
  - `prn`: The unique Permanent Registration Number for the student.
  - `dept`: The department to which the student belongs.
  - `batch`: The academic batch or year of the student.
  - `cgpa`: The Cumulative Grade Point Average of the student.

- **Functionality**: The class includes a constructor to initialize a student object with all the required attributes. It also contains methods to get and set each attribute individually. The `display()` method is responsible for displaying all the details of the student in a formatted output.

### 3. **Student Operations Class (StudentOperations.java)**

The `StudentOperations` class includes all CRUD (Create, Read, Update, Delete) operations related to student records. This class acts as the intermediary between the user and the database, managing the student records based on user input.

- **Methods**:
  - `addStudent()`: This method prompts the user to input details for a new student and adds that student’s record to the database.
  - `displayStudents()`: Retrieves and displays all students stored in the database.
  - `searchByPRN()`: Allows the user to search for a student based on their PRN (Permanent Registration Number) and displays their details.
  - `searchByName()`: Enables the user to search for students by their name, supporting partial matches.
  - `updateStudent()`: Lets the user update an existing student’s details after confirming the student’s PRN exists in the database.
  - `deleteStudent()`: This method deletes a student’s record based on the provided PRN, removing it from the database.

### 4. **Main Driver Class (Main.java)**

The `Main.java` class is the entry point of the application. It provides a menu-based interface for users to interact with the system and perform various operations like adding, displaying, searching, updating, or deleting student records.

- **Core Functionality**: The main method initializes the application, displays a menu for the user to select operations, and calls the appropriate methods from the `StudentOperations` class based on user input.

---

## Database Assumptions

- The MySQL server is running.
- A database named `student_db` is created and used for storing student records.
- A table `students` exists with the following columns:
  - `prn BIGINT PRIMARY KEY`: The unique identifier for the student.
  - `name VARCHAR(100)`: The student's full name.
  - `dept VARCHAR(50)`: The student's department.
  - `batch VARCHAR(20)`: The student's academic batch or year.
  - `cgpa DOUBLE`: The student's cumulative grade point average.

Example SQL for setting up the database:

```sql
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
  prn BIGINT PRIMARY KEY,
  name VARCHAR(100),
  dept VARCHAR(50),
  batch VARCHAR(20),
  cgpa DOUBLE
);
```


## Conclusion

- 1.) The Student Data Entry System offers a practical solution for managing student information using a MySQL database. The Java-based application allows users to efficiently perform essential CRUD operations, including adding, displaying, searching, updating, and deleting student records.

 - 2.) This system can serve as a foundation for more advanced student management systems. By enhancing the user interface or integrating additional features such as file import/export functionality or security measures like encryption, this project can be expanded to meet more specific requirements for educational institutions.

 - 3.)The use of JDBC and MySQL makes the application highly scalable and suitable for handling larger datasets, providing a robust and flexible system for managing student records in any academic environment.

