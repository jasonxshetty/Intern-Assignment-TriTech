package Other;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Student extends Person implements CourseEnrollment {
    private String studentBirthday;
    private List<Course> courseList = new ArrayList<>();

    //Student(){}

    public Student(int id, String name, String studentBirthday) {
        super(id, name);
        this.studentBirthday = studentBirthday;
    }

    public Student(){
    }

    @Override
    public void enrollCourse(Course course) {
        courseList.add(course);
        course.addStudent(this);
    }

    @Override
    public void dropCourse(Course course) {
        courseList.remove(course);
        course.removeStudent(this);
    }

    public void printEnrolledCoursesAlphabetically() {
        List<Course> sortedCourses = new ArrayList<>(courseList);
        sortedCourses.sort(Comparator.comparing(Course::getCourseName));

        System.out.println("Courses enrolled by " + getName() + ":");
        for (Course course : sortedCourses) {
            System.out.println(course);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Birthday: " + studentBirthday;
    }
}
