//Student Registration System
//Jason Shetty

import java.lang.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for course details
        System.out.println("Enter Course Code:");
        String courseCode = scanner.nextLine();
        System.out.println("Enter Course Name:");
        String courseName = scanner.nextLine();
        Course testCourse1 = new Course(courseCode, courseName);

        // Prompt for student details
        System.out.println("Enter Student ID:");
        String studentId = scanner.nextLine();
        System.out.println("Enter Student Name:");
        String studentName = scanner.nextLine();
        System.out.println("Enter Student Birthday:");
        String studentBirthday = scanner.nextLine();
        Student testStudent1 = new Student(Integer.parseInt(studentId), studentName, studentBirthday);

        // Prompt for professor details
        System.out.println("Enter Professor ID:");
        String professorId = scanner.nextLine();
        System.out.println("Enter Professor Name:");
        String professorName = scanner.nextLine();
        Professor testProfessor1 = new Professor(Integer.parseInt(professorId), professorName);

        testProfessor1.assignCourse(testCourse1);
        testStudent1.enrollCourse(testCourse1);

        // Print lists
        testCourse1.printStudentsAlphabetically();
        testStudent1.printEnrolledCoursesAlphabetically();

        scanner.close();


//        Course testCourse1 = new Course("CS 3345", "Data Structures and Algorithms");
//        Course testCourse2 = new Course("CS 3377", "Systems Programming Unix");
//
//        Professor testProfessor1 = new Professor(123, "Feng");
//        Professor testProfessor2 = new Professor(456, "Jiang");
//
//        Student testStudent1 = new Student(123, "Jason", "06-03-2004");
//        Student testStudent2 = new Student(456, "Allen", "01-15-2004");
//
//
//        testProfessor1.assignCourse(testCourse1);
//        testProfessor2.assignCourse(testCourse2);
//
//        testStudent1.enrollCourse(testCourse1);
//        testStudent2.enrollCourse(testCourse2);
//
//        testCourse1.printStudentsAlphabetically();
//        testCourse2.printStudentsAlphabetically();
//        testCourse1.printProfessorsAlphabetically();
//        testCourse2.printProfessorsAlphabetically();
//
//        testStudent1.printEnrolledCoursesAlphabetically();
//        testStudent2.printEnrolledCoursesAlphabetically();
    }
}

//Course class
class Course {
    //object attributes
    private String courseCode;
    private String courseName;
    private ArrayList<Professor> professorList = new ArrayList<Professor>();
    private ArrayList<Student> studentList = new ArrayList<Student>();
    //parameterized constructor
    public Course(String courseCode, String courseName){
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    //adding/removing students and professors
    public void addStudent(Student student){
        studentList.add(student);
    }
    public void removeStudent(Student student){
        studentList.remove(student);
    }
    public void addProfessor(Professor professor){
        professorList.add(professor);
    }
    public void removeProfessor(Professor professor){
        professorList.remove(professor);
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + ", Course Name: " + courseName;
    }
    public ArrayList<Student> getStudents() {
        return studentList;
    }

    public void printStudentsAlphabetically() {
        studentList.sort((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
        System.out.println("Students enrolled in course " + courseName + ":");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public void printProfessorsAlphabetically() {
        professorList.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
        System.out.println("For Professor assigned in course " + courseName + ":");
        for (Professor professor : professorList) {
            System.out.println(professor);
        }
    }
}

//Student class
class Student extends Person implements CourseEnrollment {
    //object attributes
    private String studentBirthday;
    private ArrayList<Course> courseList = new ArrayList<Course>();
    //parameterized constructor
    public Student(int id, String name, String studentBirthday){
        super(id, name);
        this.studentBirthday = studentBirthday;
    }

    @Override
    public String toString() {
        return "Student ID: " + getId() + ", Student Name: " + getName() + ", Student Birthday: " + studentBirthday;
    }

    //adding/removing courses
    @Override
    public void enrollCourse(Course course) {
        courseList.add(course);
        course.addStudent(this);
    }
    @Override
    public void dropCourse(Course course){
        courseList.remove(course);
        course.removeStudent(this);
    }

    //method to print courses in alphabetical order
    public void printEnrolledCoursesAlphabetically() {
        courseList.sort((c1, c2) -> c1.getCourseName().compareToIgnoreCase(c2.getCourseName()));
        System.out.println("Courses enrolled by " + getName() + ":");
        for (Course course : courseList) {
            System.out.println(course);
        }
    }

}

//Professor class
class Professor extends Person implements CourseAssignment {
    //object attributes
    private ArrayList<Course> coursesTeachingList = new ArrayList<Course>();
    //parameterized constructor
    public Professor(int id, String name) {
        super(id, name);
    }
    //adding/removing courses teaching
    @Override()
    public void assignCourse(Course course) {
        coursesTeachingList.add(course);
        course.addProfessor(this);
    }
    @Override()
    public void deAssignCourse(Course course){
        coursesTeachingList.remove(course);
        course.removeProfessor(this);
    }

    public void printAssignedCoursesAlphabetically() {
        coursesTeachingList.sort((c1, c2) -> c1.getCourseName().compareToIgnoreCase(c2.getCourseName()));
        System.out.println("Courses assigned by " + getName() + ":");
        for (Course course : coursesTeachingList) {
            System.out.println(course);
        }
    }
}

// Interface for objects that can be enrolled in courses
interface CourseAssignment {
    void assignCourse(Course course);
    void deAssignCourse(Course course);
}
interface CourseEnrollment {
    void enrollCourse(Course course);
    void dropCourse(Course course);
}

// Base class for Person - Student/Professor
abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}