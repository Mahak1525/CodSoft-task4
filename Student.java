package internshipTasks;
import java.util.ArrayList;
import java.util.Scanner;
    
    class Student {
        private String name;
        private int rollNumber;
        private String grade;
    
        public Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }
    
        public String getName() {
            return name;
        }
    
        public int getRollNumber() {
            return rollNumber;
        }
    
        public String getGrade() {
            return grade;
        }
    
        @Override
        public String toString() {
            return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
        }
    }
    
    class StudentManagementSystem {
        private ArrayList<Student> students;
    
        public StudentManagementSystem() {
            this.students = new ArrayList<>();
        }
    
        public void addStudent(Student student) {
            students.add(student);
        }
    
        public void removeStudent(int rollNumber) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getRollNumber() == rollNumber) {
                    students.remove(i);
                    System.out.println("Student with roll number " + rollNumber + " removed.");
                    return;
                }
            }
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    
        public void searchStudent(int rollNumber) {
            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    System.out.println("Student found:");
                    System.out.println(student);
                    return;
                }
            }
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    
        // Method to display all students
        public void displayAllStudents() {
            if (students.isEmpty()) {
                System.out.println("No students to display.");
            } else {
                System.out.println("List of students:");
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            StudentManagementSystem system = new StudentManagementSystem();
    
            system.addStudent(new Student("Pisu", 1, "A"));
            system.addStudent(new Student("Leni", 2, "B"));
            system.addStudent(new Student("Kiyu", 3, "A"));
    
            while (true) {
                System.out.println("\nWelcome to Student Management System");
                System.out.println("1. Add a new student");
                System.out.println("2. Remove a student");
                System.out.println("3. Search for a student");
                System.out.println("4. Display all students");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
    
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character after nextInt()
    
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
    
                        System.out.print("Enter roll number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character after nextInt()
    
                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();
    
                        Student newStudent = new Student(name, rollNumber, grade);
                        system.addStudent(newStudent);
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter roll number of student to remove: ");
                        int rollToRemove = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character after nextInt()
                        system.removeStudent(rollToRemove);
                        break;
                    case 3:
                        System.out.print("Enter roll number of student to search: ");
                        int rollToSearch = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character after nextInt()
                        system.searchStudent(rollToSearch);
                        break;
                    case 4:
                        system.displayAllStudents();
                        break;
                    case 5:
                        System.out.println("Exiting program. Goodbye!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        }
    }
     
