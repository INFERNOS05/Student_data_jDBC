// Name: Sehajdeep Singh Sikka
// PRN: 23070126119
// Batch: B2 | Class of 2027

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in); // Scanner for input
        StudentOperations operations = new StudentOperations(); // Object to perform student operations
        int choice;

        do {
            // Display menu options for the user
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student (By PRN)");
            System.out.println("4. Search Student (By Name)");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt(); // Read user choice
            scan.nextLine(); // Consume the newline character

            // Perform the selected operation based on user choice
            switch (choice) {
                case 1:
                    operations.addStudent(scan); // Add a new student
                    break;
                case 2:
                    operations.displayStudents(); // Display all students
                    break;
                case 3:
                    operations.searchByPRN(scan); // Search for student by PRN
                    break;
                case 4:
                    operations.searchByName(scan); // Search for student by name
                    break;
                case 5:
                    operations.updateStudent(scan); // Update student details
                    break;
                case 6:
                    operations.deleteStudent(scan); // Delete student by PRN
                    break;
                case 7:
                    System.out.println("Exiting program..."); // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice! Try again."); // Invalid choice handler
            }
        } while (choice != 7); // Repeat menu until user chooses to exit
    }
}

