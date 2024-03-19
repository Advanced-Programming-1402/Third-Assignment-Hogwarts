import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Assistant extends Account {
    static List<Course> allCourses = new ArrayList<>();
    static List<Teacher> teachersInQueue = new ArrayList<>();
    public Assistant(String username, String password) {
        super(username, password);
    }
    public void getCoursesAndStudents(List<Course> allCourses) {
        for (int i = 0; i < allCourses.size(); i++){
            System.out.println(allCourses.get(i).getCourseName() + " :");
            System.out.println("\t" + allCourses.get(i).getStudents());
        }
    }
    public void addCourse(Course c) {
        allCourses.add(c);
    }
    public void makeCourse(String courseName, String details) {
        Teacher teacher = new Teacher("", "");
        Course c = new Course(teacher, courseName, details);
        addCourse(c);
    }
    public static List<String> getCoursesName() {
        List<String> coursesName = new ArrayList<>();
        for (int i = 0; i < allCourses.size(); i++) {
            coursesName.add(allCourses.get(i).getCourseName());
        }
        return coursesName;
    }
    public void getProfile() {
        System.out.println();
    }
    public void teacherRegister() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < teachersInQueue.size(); i++) {
            System.out.print(teachersInQueue.get(i).getUsername() + ", ");
        }
        System.out.print("\nEnter teachers name for register: ");
        String teacherName = in.next();
        Teacher teacherTarget = new Teacher("", "");
        for (int i = 0; i < teachersInQueue.size(); i++) {
            Teacher teacher = teachersInQueue.get(i);
            if (teacher.getUsername().equals(teacherName)) {
                teacher.signUp();
                teacherTarget = teacher;
            }
        }
        teachersInQueue.remove(teacherTarget);
    }
}
