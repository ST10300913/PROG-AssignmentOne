/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog_assignment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author teaga
 */
public class PROG_ASSIGNMENT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
          // Program to manage students in the ABC College.
        /*
        Program allows user to enter:
        -Student ID
        -Student name 
        -Student age
        -Student email
        -Student course
        
        -menu that allows you to pick the following features:
        -Capture a new student
        -Search for a new student 
        -Delete a student
        -Print student report 
        -Exit application
        */
       
     Scanner kb = new Scanner(System.in);
     ArrayList<Student> studentsList = new ArrayList<>(); //array list is alot easier to manipulate.
       Student student = new Student("",0,0,"","");
      //display the start launch screen.
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("***********************************");
        System.out.println("Enter (1) to launch the menu or any key to exit");
     String launchChoice = kb.nextLine();
     
     //if user enters any key except 1, then program will close.
        if (!launchChoice.equals("1")) {
            System.out.println("Exiting the application...");
            //scanner.close(); or kb.close();
            System.exit(0);
        }//end of if statement 
        
        //menu loop.
        
        while(true){
            System.out.println("Please select one of the following menu items: "
                    + "\n(1) Capture a new student"
                    + "\n(2) Search for a student"
                    + "\n(3) Delete a student"
                    + "\n(4) Print student report"
                    + "\n(5) Exit the application");
            
            int choice = kb.nextInt();
            kb.nextLine(); //consume the newline character
            
            switch(choice){
                case 1: Student.saveStudent(studentsList); break;//Adding a new student 
                case 2: Student.searchStudent(studentsList); break;//seraching for a new student 
                case 3: Student.deleteStudent(studentsList); break;//deleting a student 
                case 4: Student.studentReport(studentsList); break;//view student report 
                case 5: Student.exitStudentApplication();  break; //exit the application
                default: System.out.println("Invalid choice, please try again"); break;
            }
        }//end of while loop.
        
        
    
    }
    
}
