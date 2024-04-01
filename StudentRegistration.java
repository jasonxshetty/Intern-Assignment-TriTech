//Student Registration System
//Jason Shetty

import Other.Course;
import Other.Professor;
import Other.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRegistration {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<Professor> professorList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        char response;
        do {
            // Course details
            System.out.print("Enter Course Code:");
            String courseCode = scanner.nextLine();
            int flag = 0;
            Course course = new Course();
            for(int i=0;i<courseList.size();i++){
                if(courseList.get(i).getCourseCode().equals(courseCode)){
                    course = courseList.get(i);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                System.out.print("Enter Course Name:");
                String courseName = scanner.nextLine();
                course = new Course(courseCode, courseName);
                courseList.add(course);
            }

            // Student details
            System.out.print("Enter Student ID:");
            int studentId = Integer.parseInt(scanner.nextLine());
            flag = 0;
            Student student = new Student();
            for(int i=0;i<studentList.size();i++){
                if(studentList.get(i).getId() == studentId){
                    student = studentList.get(i);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                System.out.print("Enter Student Name:");
                String studentName = scanner.nextLine();
                System.out.print("Enter Student Birthday:");
                String studentBirthday = scanner.nextLine();
                student = new Student(studentId, studentName, studentBirthday);
                studentList.add(student);
            }


            // Professor details
            System.out.print("Enter Professor ID:");
            int professorId = Integer.parseInt(scanner.nextLine());

            flag = 0;
            Professor professor = new Professor();
            for(int i=0;i<professorList.size();i++){
                if(professorList.get(i).getId() == professorId){
                    professor = professorList.get(i);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                System.out.print("Enter Professor Name:");
                String professorName = scanner.nextLine();
                professor = new Professor(professorId, professorName);
                professorList.add(professor);
            }

            professor.assignCourse(course);
            student.enrollCourse(course);

            System.out.print("\nEnter 'y' or 'Y' to add more data.\nEnter 'n' or 'N' to quit.");
            response = scanner.next().charAt(0);
            scanner.nextLine();
        } while (response == 'y' || response == 'Y');

        for (Student student : studentList) {
            student.printEnrolledCoursesAlphabetically();
        }

        scanner.close();
    }

}