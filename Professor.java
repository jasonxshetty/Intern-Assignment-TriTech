package Other;

import java.util.*;

public class Professor extends Person implements CourseAssignment {
    private List<Course> coursesTeachingList = new ArrayList<Course>();

    public Professor(){}

    public Professor(int id, String name) {
        super(id, name);
    }

    @Override
    public void assignCourse(Course course) {
        coursesTeachingList.add(course);
        course.addProfessor(this);
    }

    @Override
    public void deAssignCourse(Course course) {
        coursesTeachingList.remove(course);
        course.removeProfessor(this);
    }

    public void printAssignedCoursesAlphabetically() {
        coursesTeachingList.sort((c1, c2) -> c1.getCourseName().compareToIgnoreCase(c2.getCourseName()));
        System.out.println("Courses assigned to " + getName() + ":");
        for (Course course : coursesTeachingList) {
            System.out.println(course);
        }
    }
}
