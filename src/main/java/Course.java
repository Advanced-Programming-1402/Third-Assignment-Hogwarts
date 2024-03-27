import java.util.*;
public class Course {
    private static UUID courseID;
    static UUID accountID;
    Teacher courseTeacher;
    private String teacherName;
    private String courseName;
    private String information;


    List<String> students;
    static HashMap<String , Double> studentScore = new HashMap<>();

    public Course(Teacher teacher, String courseName, String information) {
        this.courseTeacher = courseTeacher;
        this.courseID = UUID.randomUUID();
        this.students = new ArrayList<>();
        this.courseName = courseName;
        this.information = information;

    }
    public String getInformation() {
        return information;
    }

    public Teacher getCourseTeacher() {
        return courseTeacher;
    }
    public void changeTeacher(Teacher courseTeacher){
        this.courseTeacher = courseTeacher;
    }
    public String getCourseName(){
        return courseName;
    }
    public void scoring(String studentName , Double score) {
        studentScore.put(studentName , score);
    }
    public static UUID getCourseID() {
        return courseID;
    }

    public List<String> getStudents() {
        return students;
    }
    public void addStudent(String student){
        this.students.add(student);
    }


    public void changeTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }
}
