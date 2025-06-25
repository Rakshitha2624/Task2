package task2;

import java.util.ArrayList;
import java.util.Scanner;

// Student class with encapsulation
class Student {
    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Display student details
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

// Main class
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
        	System.out.println("\n===== Welcome to the Student Records Management Console =====");
            System.out.println("1. Register New Student");
            System.out.println("2. View All Student Records");
            System.out.println("3. Edit Student Information");
            System.out.println("4. Remove Student From System");
            System.out.println("5. Exit Application");           
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Program terminated successfully.");
                default -> System.out.println("Invalid selection. Please enter a valid option from the menu.");

            }
        } while (choice != 5);
    }

    private static void addStudent() {
    	System.out.print("Please enter the Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Please enter the Student's Name: ");
        String name = scanner.nextLine();

        System.out.print("Please enter the Student's Marks: ");
        double marks = scanner.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student record has been successfully added.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
        	System.out.println("The database is currently empty. No records to display.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() {
    	System.out.print("Input the Student's ID to proceed with the update: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == id) {
                scanner.nextLine(); // consume newline
                System.out.print("Please enter the updated name: ");
                s.setName(scanner.nextLine());

                System.out.print("Please enter the updated marks: ");
                s.setMarks(scanner.nextDouble());

                System.out.println("Student record has been updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
        	System.out.println("Student does not exist in the current database.");
        }
    }

    private static void deleteStudent() {
    	System.out.print("Input Student ID for deletion: ");
        int id = scanner.nextInt();
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
        	System.out.println("Student record has been deleted successfully.");
        } else {
        	System.out.println("No matching student record found for the given ID.");

        }
    }
}