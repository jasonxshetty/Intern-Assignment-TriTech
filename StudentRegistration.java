//Student Registration System
//Jason Shetty

import java.util.*;

public class StudentRegistration {
    //Course class 
    class Course{
        //object attributes
        String courseCode;
        String courseName;
        //parameterized constructor
        Course(String courseCode, String courseName){
            this.courseCode = courseCode;
            this.courseName = courseName;
        }

        //list of professors
        //list of students
    }

    //Student class
    class Student{
        //object attributes
        int studentID;
        String studentName;
        String studentBirthday;
        //parameterized constructor
        Student(int studentID, String studentName, String studentBirthday){
            this.studentID = studentID;
            this.studentName = studentName;
            this.studentBirthday = studentBirthday;
        }
        //list of courses
    }

    //Professor class
    class Professor{
        //object attributes
        int professorID;
        String professorName;
        //parameterized constructor
        Professor(int professorID, String professorName){
            this.professorID = professorID;
            this.professorName = professorName;
        }
        //list of courses teaching
    }

    public static void main(String[] args) {
        System.out.println("Program executed.");
    }
}
