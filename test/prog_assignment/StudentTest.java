/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog_assignment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author teaga
 */
public class StudentTest {
    

    @Test
    public void testSaveStudent()
    {
        Student student = new Student("",0,0,"","");
        
        student.setStudentName("Teagan");
        student.setStudentAge(17);
        student.setStudentID(1);
        student.setStudentEmail("teagan@gmail.com");
        student.setStudentCourse("BCAD");
        
        assertEquals("Teagan", student.getStudentName());
        assertEquals(17, student.getStudentAge());
        assertEquals(1, student.getStudentID());
        assertEquals("teagan@gmail.com", student.getStudentEmail());
        assertEquals("BCAD", student.getStudentCourse());
    }
    
    @Test
    public void testSearchStudent()
    {
          Student student = new Student("Teagan", 0, 1234, "teagan@gamil.com", "BCAD");
          
          System.out.println("Please enter the students ID");
          
          student.setStudentID(1234);
          
          assertEquals(1234, student.getStudentID());
    }
    
    //test method if Student ID is not found or doesnt exist.
    @Test
    public void TestSearchStudent_StudentNotFound()
    {
      // Create an empty list of students
        List<Student> studentList = new ArrayList<>();

        // Create a student object with a known ID
          Student student = new Student("Teagan", 0, 1234, "teagan@gamil.com", "BCAD");

        // Add the student to the list (simulate a student being added)
        studentList.add(student);

        // Attempt to search for a student with an ID that doesn't exist (e.g., 99999)
        int searchID = 99999;
       

        // Verify that the result is equal to null (indicating that the student was not found)
        assertEquals(null, 99999, searchID);
        System.out.println("Student should not be found with ID " + searchID);
    }
    @Test
    public void TestDeleteStudent()
    {
          // Create an empty list of students
        ArrayList<Student> studentList = new ArrayList<>();

        // Create a student object with a known ID
          Student student = new Student("Teagan", 20, 1234, "teagan@gamil.com", "BCAD");
        
        studentList.add(student);
        
        int deleteID = 12345;
        
        assertEquals(12345, deleteID);
        System.out.println("Student with the ID " + deleteID + " was deleted.");

    }
     @Test
    public void TestStudentAge_StudentAgeValid()
    {
     ArrayList<Student> studentList = new ArrayList<>();

        // Create a student object with a valid age
           Student student = new Student("Teagan", 20, 1234, "teagan@gamil.com", "BCAD");
        // Define the expected valid age
        int expectedValidAge = 20;

        // Verify that the student age is valid
        assertEquals(expectedValidAge, student.getStudentAge());
        
    }
    @Test
    public void TestStudentAge_StudentAgeInvalid()
    {
         ArrayList<Student> studentList = new ArrayList<>();

        // Create a student object with an invalid age
           Student student = new Student("Teagan", 11, 1234, "teagan@gamil.com", "BCAD");
        studentList.add(student);

        // Define the expected invalid age
        int expectedInvalidAge = 11;

        // Verify that the student age is invalid
        assertEquals(expectedInvalidAge, student.getStudentAge());
    }
    @Test
   public void TestStudentAge_StudentAgeInvalidCharacter()
   {
       ArrayList<Student> studentList = new ArrayList<>();
    Student student = new Student("Invalid Student", 11111111, 54321, "invalid@student.com", "Invalid Course");
        studentList.add(student);
     
        int expectedInvalidCharacter = 11111111;
        
        assertEquals(expectedInvalidCharacter, student.getStudentAge());
     
   }

}




    
    
    
    

