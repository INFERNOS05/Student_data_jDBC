// StudentOperations.java
// Class to manage student records using MySQL through JDBC (no in-memory storage).

import java.sql.*;
import java.util.Scanner;

class StudentOperations {

    // Method to add a new student to the database
    public void addStudent(Scanner scan) {
        try (Connection conn = DBConnection.getConnection()) {
            // Collect student details from user input
            System.out.print("Enter name: ");
            String name = scan.nextLine();
            System.out.print("Enter PRN: ");
            long prn = scan.nextLong();
            scan.nextLine();  // Consume newline character
            System.out.print("Enter Department: ");
            String dept = scan.nextLine();
            System.out.print("Enter Batch (YYYY-YY): ");
            String batch = scan.nextLine();
            System.out.print("Enter CGPA: ");
            double cgpa = scan.nextDouble();
            scan.nextLine();  // Consume newline character

            // SQL query to insert a new student into the students table
            String sql = "INSERT INTO students (prn, name, dept, batch, cgpa) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Set the parameters for the SQL query
            stmt.setLong(1, prn);
            stmt.setString(2, name);
            stmt.setString(3, dept);
            stmt.setString(4, batch);
            stmt.setDouble(5, cgpa);

            // Execute the SQL statement
            stmt.executeUpdate();

            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            // Handle any SQL exceptions
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Method to display all students in the database
    public void displayStudents() {
        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to retrieve all student records
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            boolean found = false;
            // Loop through and display each student's details
            while (rs.next()) {
                found = true;
                System.out.println("Name: " + rs.getString("name") +
                        ", PRN: " + rs.getLong("prn") +
                        ", Dept: " + rs.getString("dept") +
                        ", Batch: " + rs.getString("batch") +
                        ", CGPA: " + rs.getDouble("cgpa"));
            }
            // If no students were found, display a message
            if (!found) System.out.println("No student records found.");
        } catch (SQLException e) {
            // Handle any SQL exceptions
            System.out.println("Error displaying students: " + e.getMessage());
        }
    }

    // Method to search for a student by PRN
    public void searchByPRN(Scanner scan) {
        System.out.print("Enter PRN: ");
        long prn = scan.nextLong();
        scan.nextLine(); // Consume newline character
        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to find a student by PRN
            String sql = "SELECT * FROM students WHERE prn = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, prn);
            ResultSet rs = stmt.executeQuery();

            // If student found, display their details
            if (rs.next()) {
                System.out.println("Name: " + rs.getString("name") +
                        ", PRN: " + rs.getLong("prn") +
                        ", Dept: " + rs.getString("dept") +
                        ", Batch: " + rs.getString("batch") +
                        ", CGPA: " + rs.getDouble("cgpa"));
            } else {
                // If no student found, display a message
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            System.out.println("Error searching by PRN: " + e.getMessage());
        }
    }

    // Method to search for students by name (partial search)
    public void searchByName(Scanner scan) {
        System.out.print("Enter Name: ");
        String name = scan.nextLine();
        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to find students by name (partial match using LIKE)
            String sql = "SELECT * FROM students WHERE name LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");  // '%' for partial match
            ResultSet rs = stmt.executeQuery();

            boolean found = false;
            // Loop through and display each student matching the name
            while (rs.next()) {
                found = true;
                System.out.println("Name: " + rs.getString("name") +
                        ", PRN: " + rs.getLong("prn") +
                        ", Dept: " + rs.getString("dept") +
                        ", Batch: " + rs.getString("batch") +
                        ", CGPA: " + rs.getDouble("cgpa"));
            }
            // If no students were found, display a message
            if (!found) {
                System.out.println("No student found with that name.");
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            System.out.println("Error searching by name: " + e.getMessage());
        }
    }

    // Method to update the details of an existing student
    public void updateStudent(Scanner scan) {
        System.out.print("Enter PRN of student to update: ");
        long prn = scan.nextLong();
        scan.nextLine(); // Consume newline character

        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to check if the student exists by PRN
            String checkSql = "SELECT * FROM students WHERE prn = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setLong(1, prn);
            ResultSet rs = checkStmt.executeQuery();

            // If student exists, update their details
            if (rs.next()) {
                System.out.print("Enter new name: ");
                String name = scan.nextLine();
                System.out.print("Enter new Department: ");
                String dept = scan.nextLine();
                System.out.print("Enter new Batch: ");
                String batch = scan.nextLine();
                System.out.print("Enter new CGPA: ");
                double cgpa = scan.nextDouble();
                scan.nextLine();  // Consume newline character

                // SQL query to update student details
                String updateSql = "UPDATE students SET name=?, dept=?, batch=?, cgpa=? WHERE prn=?";
                PreparedStatement stmt = conn.prepareStatement(updateSql);
                stmt.setString(1, name);
                stmt.setString(2, dept);
                stmt.setString(3, batch);
                stmt.setDouble(4, cgpa);
                stmt.setLong(5, prn);
                stmt.executeUpdate();

                System.out.println("Student details updated.");
            } else {
                // If student doesn't exist, display a message
                System.out.println("Student with PRN " + prn + " not found.");
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // Method to delete a student by PRN
    public void deleteStudent(Scanner scan) {
        System.out.print("Enter PRN of student to delete: ");
        long prn = scan.nextLong();
        scan.nextLine(); // Consume newline character

        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to delete a student by PRN
            String deleteSql = "DELETE FROM students WHERE prn = ?";
            PreparedStatement stmt = conn.prepareStatement(deleteSql);
            stmt.setLong(1, prn);
            int rows = stmt.executeUpdate();

            // If the deletion was successful, print a success message
            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                // If no student was found with the PRN, display a message
                System.out.println("Student with PRN " + prn + " not found.");
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}

