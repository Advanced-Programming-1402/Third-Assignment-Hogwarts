import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Hogwarts {

    static List<Assistant> Assistants = new ArrayList<>();
    static List<Student> students = new ArrayList<>();
    static List<Teacher> teachers = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();
    public static void addAssistant(Assistant assistant) {
        Assistants.add(assistant);
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public void addCourse(Course courseName) {
        courses.add(courseName);
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
        for (int i = 0; i < teachers.size(); i++) {
            System.out.print(teachers.get(i).getUsername() + " - ");
        }
    }

    public static void viewAllStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getUsername() + " - ");
        }
    }

    public void viewAllCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.print(courses.get(i).getCourseName() + " - ");
        }
    }
    public static void courseRequest(Teacher teacher) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).courseTeacher.getUsername().equals("")) {
                System.out.println(courses.get(i).getCourseName() + " - " + courses.get(i).getCourseID() + "  details: " + Hogwarts.courses.get(i).getDetails());
            }
        }
        System.out.print("enter UUID for get course: ");
        String input2 = in.next();
        for (int i = 0; i < Hogwarts.courses.size(); i++) {
            if (!courses.get(i).courseTeacher.getUsername().equals("") && courses.get(i).getCourseID().toString().equals(input2)) {
                System.out.println("access denied!");
            }
            else if (courses.get(i).courseTeacher.getUsername().equals("") && courses.get(i).getCourseID().toString().equals(input2)) {
                teacher.addCourse(courses.get(i), teacher);
            }
        }
    }
    public static void Scoring(Teacher teacher) {
        teacher.scoring();
    }
    public static void GetCourseViaUUID(UUID uuid) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(uuid)) {
                System.out.print(courses.get(i).getCourseName() + " :\n");
                System.out.print("Teacher: " + courses.get(i).courseTeacher.getUsername() + "\n");
                System.out.println("Students :");
                System.out.print("\t");
                for (int j = 0; j < courses.get(i).getStudents().size(); j++) {
                    System.out.print(courses.get(i).getStudents().get(j) + " - ");
                }
            }
        }
    }
}
