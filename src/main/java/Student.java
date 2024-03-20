import java.util.*;

public class Student extends Account {
    Random rand = new Random();
    List<Course> courses;
    static HashMap<UUID, Double> TeacherScore = new HashMap<>();
    List<Teacher> Teachers;
    String HogwartsSchool;
    String[] sortinghat = {"Hufflepuff", "Gryffindor", "Slytherin", "Ravenclaw"};
    public Student(String username, String password) {
        super(username, password);
        HogwartsSchool = sortinghat[rand.nextInt(4)];
        Teachers = new ArrayList<>();
        courses = new ArrayList<>();
    }
    public void addCourse(Course course) {
        courses.add(course);
        course.addStudent(getUsername());
        Teachers.add(course.getCourseTeacher());
    }
    public List<Course> getCourses() {
        return courses;
    }
    public List<Teacher> getTeachers() {
        return Teachers;
    }
    public void scoreTeacher(UUID id, Double teacherScore) {
        this.scoreTeacher(id, teacherScore);
    }
}