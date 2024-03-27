import java.util.*;
public class Assistant extends Account{
    static List<Course> allTheCourses = new ArrayList<>();
    static List<Teacher> tempTeacher = new ArrayList<>();
    public Assistant(String username , String password){
        super(username , password);
    }
    public void showCoursesStudent(List<Course> allTheCourses) {
        for(int i = 0 ; i < allTheCourses.size() ; i++) {
            System.out.println(allTheCourses.get(i).getCourseName() + " : ");
            System.out.println(allTheCourses.get(i).getStudents());
        }
    }
    public void addCourse(Course temp) {
        allTheCourses.add(temp);
    }
    public void makeCourses(String courseName , String information) {
        Teacher teacher = new Teacher("" , "");
        Course temp = new Course(teacher , courseName , information);
        Teacher.addingCourse(temp , teacher);
    }
    public static List<String> getCourseNames() {
        List<String> courseNames = new ArrayList<>();
        for(int i = 0; i < allTheCourses.size() ; i++){
            courseNames.add(allTheCourses.get(i).getCourseName());
        }
        return courseNames;
    }
    public void teacherRegister() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < tempTeacher.size(); i++) {
            System.out.print(tempTeacher.get(i).getUsername() + " , ");
        }
        System.out.print("Please Enter  the name of the teacher to register : ");
        String teacherName = in.next();
        Teacher targetTeacher = new Teacher("", "");
        for (int i = 0; i < tempTeacher.size(); i++) {
            Teacher teacher = tempTeacher.get(i);
            if (teacher.getUsername().equals(teacherName)) {
                teacher.signUp("");
                targetTeacher = teacher;
            }
        }
        tempTeacher.remove(targetTeacher);
    }
}
