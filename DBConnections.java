// DBConnection.java

import java.sql.*; // Import necessary classes for SQL connection

public class DBConnection {
    
    // JDBC URL pointing to the MySQL database. 
    // "localhost" specifies that the database is on the local machine.
    // "3306" is the default port for MySQL, and "student_db" is the database name.
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    
    // Username for the database connection. In this case, it's the default "root" user.
    private static final String USER = "root";
    
    // Password for the "root" user. Ensure this is correctly set in your environment.
    private static final String PASS = "password"; // Change this to your actual password

    // This method establishes a connection to the MySQL database using the provided credentials.
    // It throws a SQLException if the connection cannot be established.
    public static Connection getConnection() throws SQLException {
        // DriverManager is used to get a connection to the database.
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

