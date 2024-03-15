//Student Registration System
//Jason Shetty

import java.util.*;

public class StudentRegistration {
    public static void main(String[] args) {
        System.out.println("Program executed.");
    }
}

//Course class
class Course{
    //object attributes
    private String courseCode;
    private String courseName;
    private ArrayList<Professor> professorList = new ArrayList<Professor>();
    private ArrayList<Student> studentList = new ArrayList<Student>();
    //parameterized constructor
    Course(String courseCode, String courseName){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professorList = new ArrayList<>();
        this.studentList = new ArrayList<>();
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

}

//Student class
class Student{
    //object attributes
    private int studentID;
    private String studentName;
    private String studentBirthday;
    private ArrayList<Course> courseList = new ArrayList<Course>();
    //parameterized constructor
    Student(int studentID, String studentName, String studentBirthday){
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentBirthday = studentBirthday;
        this.courseList = new ArrayList<>();
    }

    //adding/removing courses
    public void addCourse(Course course){
        courseList.add(course);
    }
    public void removeCourse(Course course){
        courseList.remove(course);
    }

    //method to print courses in alphabetical order
}

//Professor class
class Professor{
    //object attributes
    private int professorID;
    private String professorName;
    private ArrayList<Course> coursesTeachingList = new ArrayList<Course>();
    //parameterized constructor
    Professor(int professorID, String professorName){
        this.professorID = professorID;
        this.professorName = professorName;
        this.coursesTeachingList = new ArrayList<>();
    }

    //adding/removing courses teaching
    public void addCoursesTeaching(Course course){
        coursesTeachingList.add(course);
    }
    public void removeCoursesTeaching(Course course){
        coursesTeachingList.remove(course);
    }
}
