import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Course  {
    private UUID courseID;
    Teacher courseTeacher;
    private String teacherName;
    private String courseName;
    private String details;
    List<String> students;
    static HashMap<String,Double> studentScore = new HashMap<>();
    public Teacher getCourseTeacher() {
        return courseTeacher;
    }
    public String getDetails() {
        return details;
    }
    public Course(Teacher courseTeacher, String courseName, String details) {
        this.courseTeacher = courseTeacher;
        this.courseName = courseName;
        this.details = details;
        this.courseID = UUID.randomUUID();
        this.students = new ArrayList<>();
    }

    public void addStudent(String student) {
        this.students.add(student);
    }
    public List<String> getStudents() {
        return students;
    }
    public void changeTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }
    public String getCourseName() {
        return courseName;
    }
    public void scoring(String studentName, Double score) {
        studentScore.put(studentName, score);
    }
    public UUID getCourseID() {
        return courseID;
    }
}
