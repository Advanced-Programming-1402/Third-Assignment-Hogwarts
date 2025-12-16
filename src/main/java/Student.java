import java.util.*;
public class Student extends Account {
    List<Course> courses;
    List<String> teachers;
    String hat;
    Random random = new Random();
    String[] group = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
    public Student(String username , String password) {
        super(username , password);
        teachers = new ArrayList<>();
        courses = new ArrayList<>();
        hat = group[random.nextInt(4)];
    }
    public void addCourse(Course temp) {
        courses.add(temp);
        temp.addStudent(getUsername());
        teachers.add(temp.getTeacherName());
    }
    public List<Course> getCourses(){
        return courses;
    }
    public List<String> getTeachers(){
        return teachers;
    }
    public void scoreTeacher(UUID uuid ,Double teacherScore)
    {
        this.scoreTeacher(uuid , teacherScore);
    }
}
