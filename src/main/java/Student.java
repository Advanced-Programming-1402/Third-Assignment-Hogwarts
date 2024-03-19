import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Student extends Account {
    List<Course> courses;
    static HashMap<UUID, Double> TeacherScore = new HashMap<>();
    List<Teacher> Teachers;
    public Student(String username, String password) {
        super(username, password);
        Teachers = new ArrayList<>();
        courses = new ArrayList<>();
    }
    public void addCourse(Course c) {
        courses.add(c);
        c.addStudent(getUsername());
        Teachers.add(c.getCourseTeacher());
//        for (int i = 0; i < Hogwarts.students.size(); i++) {
//            if (Hogwarts.students.get(i).getUsername().equals(getUsername())) {
//                Hogwarts.students.get(i).courses.remove(c);
//                Hogwarts.students.get(i).courses.add(c);
//            }
//        }
    }
    public List<Course> getCourses() {
        return courses;
    }
    public List<Teacher> getTeachers() {
        return Teachers;
    }
    public void scoreTeacher(UUID uuid, Double teacherScore) {
        this.scoreTeacher(uuid, teacherScore);
    }
}