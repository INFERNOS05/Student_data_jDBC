// Student.java
// Class representing a student with attributes like name, PRN, department, batch, and CGPA.

public class Student {

    // Instance variables (attributes) for the Student class
    private String name;    // Name of the student
    private long prn;       // PRN (Permanent Registration Number) of the student
    private String dept;    // Department to which the student belongs
    private String batch;   // Batch in which the student is enrolled
    private double cgpa;    // CGPA (Cumulative Grade Point Average) of the student

    // Constructor to initialize student attributes
    // This constructor is called when a new Student object is created.
    public Student(String name, long prn, String dept, String batch, double cgpa) {
        this.name = name;    // Initialize the name attribute with the passed value
        this.prn = prn;      // Initialize the prn attribute with the passed value
        this.dept = dept;    // Initialize the dept attribute with the passed value
        this.batch = batch;  // Initialize the batch attribute with the passed value
        this.cgpa = cgpa;    // Initialize the cgpa attribute with the passed value
    }

    // Getter and Setter methods for encapsulation
    // These methods provide controlled access to the private attributes

    public String getName() { 
        return name; // Returns the name of the student
    }
    
    public void setName(String name) { 
        this.name = name; // Sets the name of the student
    }

    public long getPRN() { 
        return prn; // Returns the PRN of the student
    }
    
    public void setPRN(long prn) { 
        this.prn = prn; // Sets the PRN of the student
    }

    public String getDept() {  
        return dept; // Returns the department of the student
    }
    
    public void setDept(String dept) { 
        this.dept = dept; // Sets the department of the student
    }

    public String getBatch() { 
        return batch; // Returns the batch of the student
    }
    
    public void setBatch(String batch) { 
        this.batch = batch; // Sets the batch of the student
    }

    public double getCGPA() { 
        return cgpa; // Returns the CGPA of the student
    }
    
    public void setCGPA(double cgpa) { 
        this.cgpa = cgpa; // Sets the CGPA of the student
    }

    // Method to display student details in a readable format
    public void display() {
        // Output the student information to the console in a formatted manner
        System.out.println("Name: " + name + ", PRN: " + prn + ", Department: " + dept + ", Batch: " + batch + ", CGPA: " + cgpa);
    }
}

