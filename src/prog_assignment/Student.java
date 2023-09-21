/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author teaga
 */
public class Student {
     private List<Student> student;
    
     private String studentName; 
  private int studentAge;
  private int studentID;
  private String studentEmail;
  private String studentCourse;
  
  //construcor 
    public Student(String studentName, int studentAge, int studentID, String studentEmail, String studentCourse) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentID = studentID;
        this.studentEmail = studentEmail;
        this.studentCourse = studentCourse;
    }

    
    
    
    //setters and getters methods for student information
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public static void saveStudent(ArrayList<Student> studentList){
        //this method allows user to enter all the student information and save it to an array.
        //this means when the user searches for a student, the program can find it.
        //as well as when we need to do the student report.
        Scanner kb = new Scanner(System.in);
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("****************************");
        System.out.println("Enter the students name: ");
        String studentName = kb.nextLine();
       
        int studentAge;
        do {
            System.out.println("Enter stduent age ( >= 16");
            if (kb.hasNextInt()){
                studentAge = kb.nextInt();
                if (studentAge < 16) {
                    System.out.println("Invalid age!"
                            + "age must be >= 16");
                    
                }
            } else{
                System.out.println("Invalid input.Please enter a valid age!");
            kb.next(); //comsume invalid input.
            studentAge = -1; //set an invalid age to continue the loop.
            }
        }
        while(studentAge < 16);
        
        System.out.println("Enter the students ID: ");
        int studentID = kb.nextInt();
        kb.nextLine(); //consume the newline character.
        
        System.out.println("Enter the students email: ");
        String studentEmail = kb.nextLine();
        
        System.out.println("Enter the student's course: ");
        String studentCourse = kb.nextLine();
        
        //create a new student object and add it to the array list.
        Student student = new Student(studentName, studentAge, studentID, studentEmail, studentCourse);
        studentList.add(student);
        
        System.out.println("Student details have been successfully added."
                + "\n");
           // Ask if the user wants to return to the menu or exit
    System.out.print("Enter (1) to return to the menu or any other key to exit: ");
    int choice = kb.nextInt();
    kb.nextLine(); // Consume the newline character

    if (choice != 1) {
        exitStudentApplication(); // Exit the program if the user chooses any other key
        
        
        
    }
    }//end of method 
    
public static void searchStudent(ArrayList<Student> studentList)
{
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter the students ID to search :");
    int searchID = kb.nextInt();
    
    boolean found = false;
    
    for (Student student : studentList) {
        if (student.getStudentID() == searchID) {
            //if student found --> display all the details!
            System.out.println("----------------------");
            System.out.println("Student ID:" + student.getStudentID());
            System.out.println("Student name: " + student.getStudentName());
            System.out.println("Student Age: " + student.getStudentAge());
            System.out.println("Student email: " + student.getStudentEmail());
            System.out.println("Student course: " + student.getStudentCourse());
            System.out.println("             "
                    + "                          ");
            
            found = true;
            
            break; // stop search as we found the student!
            
            
        }
    }
    if (!found) {
        System.out.println("Student with ID " + searchID + " not found!"); //displays if thw student number does not exist.
    }
     // Ask if the user wants to return to the menu or exit
    System.out.print("Enter (1) to return to the menu or any other key to exit: ");
    int choice = kb.nextInt();
    kb.nextLine(); // Consume the newline character

    if (choice != 1) {
        exitStudentApplication(); // Exit the program if the user chooses any other key
    }
}//end of method
  
//next method used to delete a student using their ID
public static void deleteStudent(ArrayList<Student> studentsList)
{
    Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to delete: ");
        int deleteID = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        boolean found = false;
        String confirmation = ""; // Declare confirmation outside of the if block

        for (Student student : studentsList) {
            if (student.getStudentID() == deleteID) {
                // Student found, confirm deletion
                System.out.println("Student found:");
                System.out.println("Name: " + student.getStudentName());
                System.out.println("Age: " + student.getStudentAge());
                System.out.println("ID: " + student.getStudentID());
                System.out.println("Email: " + student.getStudentEmail());
                System.out.println("Course: " + student.getStudentCourse());

                System.out.print("Are you sure you want Student " + deleteID + " to be deleted from the system? (y/n): ");
                confirmation = scanner.next().toLowerCase(); // Assign confirmation here
                found = true;
                break; // Stop searching, we found the student
            }
        }

        if (!found) {
            System.out.println("Student with ID " + deleteID + " not found.");
        } else if (confirmation.equals("y")) { // Check confirmation outside of the loop
            studentsList.removeIf(student -> student.getStudentID() == deleteID);
            System.out.println("Student with the ID " + deleteID + " has successfully been removed.");
        } else {
            System.out.println("Deletion canceled.");
        }
          // Ask if the user wants to return to the menu or exit
    System.out.print("Enter (1) to return to the menu or any other key to exit: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character

    if (choice != 1) {
        exitStudentApplication(); // Exit the program if the user chooses any other key
    }

}//end of method

public static void studentReport(ArrayList<Student> studentsList)
    {
        if (studentsList.isEmpty()) { //if the user has not entered ant student details, it will display that there are no student details
            System.out.println("No students have been added.");
        }
        else{
            System.out.println("STUDENT REPORT: ");
             for (int i = 0; i < studentsList.size(); i++) {  //for loop that goes through the array lsit and displays each and every student.
                Student student = studentsList.get(i);
                System.out.println("-----------------------------------");
                System.out.println("STUDENT " + (i + 1));
                System.out.println("-----------------------------------");
                System.out.println("STUDENT ID: " + student.getStudentID());
                System.out.println("STUDENT NAME: " + student.getStudentName());
                System.out.println("STUDENT AGE: " + student.getStudentAge());
                System.out.println("STUDENT EMAIL: " + student.getStudentEmail());
                System.out.println("STUDENT COURSE: " + student.getStudentCourse());
            }
        }
         // Ask if the user wants to return to the menu or exit
    System.out.print("Enter (1) to return to the menu or any other key to exit: ");
    Scanner kb = new Scanner(System.in);
    int choice = kb.nextInt();
    kb.nextLine(); // Consume the newline character

    if (choice != 1) {
        exitStudentApplication(); // Exit the program if the user chooses any other key
    }
    }
        
//method to exit the program.

   public static void exitStudentApplication() {
      System.out.print("Enter (1) to return to the menu or any other key to exit: ");
    Scanner kb = new Scanner(System.in);
    int choice = kb.nextInt();
    kb.nextLine(); // Consume the newline character

    if (choice != 1) {
        exitStudentApplication(); // Exit the program if the user chooses any other key
    }
    }
     
   public int getStudentSize(){
       return student.size();
   }
}
