package Other;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String courseName;
    private List<Professor> professorList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();

    public Course(){}

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public void addProfessor(Professor professor) {
        professorList.add(professor);
    }

    public void removeProfessor(Professor professor) {
        professorList.remove(professor);
    }

    public List<Student> getStudents() {
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
        System.out.println("Professors teaching in course " + courseName + ":");
        for (Professor professor : professorList) {
            System.out.println(professor);
        }
    }

    @Override
    public String toString() {
        return "Course: " + courseCode + " - " + courseName;
    }
}