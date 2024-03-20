import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Hogwarts {

    static List<Assistant> Assistants = new ArrayList<>();
    static List<Student> Students = new ArrayList<>();
    static List<Teacher> Teachers = new ArrayList<>();
    static List<Course> Courses = new ArrayList<>();
    public static void addAssistant(Assistant assistant) {
        Assistants.add(assistant);
    }
    public void addStudent(Student student) {
        Students.add(student);
    }
    public void addTeacher(Teacher teacher) {
        Teachers.add(teacher);
    }
    public void addCourse(Course courseName) {
        Courses.add(courseName);
    }

    public void courseReq(Teacher teacher, Course courseName) {
        if (courseName.getCourseTeacher().getUsername().equals("")) {
            courseName.courseTeacher.changeUsername(teacher.getUsername());
        }
        else {
            System.out.println("access denied");
        }
    }

    public static void viewAllTeachers() {
        for (int i = 0; i < Teachers.size(); i++) {
            System.out.print(Teachers.get(i).getUsername() + " - ");
        }
    }

    public static void viewAllStudents() {
        for (int i = 0; i < Students.size(); i++) {
            System.out.print(Students.get(i).getUsername() + " - ");
        }
    }

    public void viewAllCourses() {
        for (int i = 0; i < Courses.size(); i++) {
            System.out.print(Courses.get(i).getCourseName() + " - ");
        }
    }
    public static void courseRequest(Teacher teacher) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < Courses.size(); i++) {
            if (Courses.get(i).courseTeacher.getUsername().equals("")) {
                System.out.println(Courses.get(i).getCourseName() + "  " + Courses.get(i).getCourseID() + "  details: " + Hogwarts.Courses.get(i).getDetails());
            }
        }
        System.out.print("enter UUID for get course: ");
        String input2 = in.next();
        for (int i = 0; i < Hogwarts.Courses.size(); i++) {
            if (!Courses.get(i).courseTeacher.getUsername().equals("") && Courses.get(i).getCourseID().toString().equals(input2)) {
                System.out.println("access denied!");
            }
            else if (Courses.get(i).courseTeacher.getUsername().equals("") && Courses.get(i).getCourseID().toString().equals(input2)) {
                teacher.addCourse(Courses.get(i), teacher);
            }
        }
    }
    public static void Scoring(Teacher teacher) {
        teacher.scoring();
    }
    public static void GetCourseViaUUID(UUID uuid) {
        for (int i = 0; i < Courses.size(); i++) {
            if (Courses.get(i).getCourseID().equals(uuid)) {
                System.out.print(Courses.get(i).getCourseName() + " :\n");
                System.out.print("Teacher: " + Courses.get(i).courseTeacher.getUsername() + "\n");
                System.out.println("Students :");
                System.out.print("\t");
                for (int j = 0; j < Courses.get(i).getStudents().size(); j++) {
                    System.out.print(Courses.get(i).getStudents().get(j) + " - ");
                }
            }
        }
    }
}