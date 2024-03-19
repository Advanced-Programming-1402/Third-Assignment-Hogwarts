import java.util.*;

public class Teacher extends Account {
    List<Course> courses;
    List<HashMap<UUID, Double>> scores = new ArrayList<>();
    private String pass;
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void signUp() {
        SignUp(pass);
    }
    public Teacher(String username, String password) {
        super(username, password);
        courses = new ArrayList<>();
    }
    public void addCourse(Course c, Teacher teacher) {
        courses.add(c);
        c.changeTeacher(c.getCourseTeacher());
        for (int i = 0; i < c.getStudents().size(); i++) {
            for (int j = 0; j < Hogwarts.students.size(); j++) {
                if (Hogwarts.students.get(j).getUsername().equals(c.getStudents().get(i))) {
                    Hogwarts.students.get(j).Teachers.add(c.courseTeacher);
                }
            }
        }
        for (int i = 0; i < Hogwarts.courses.size(); i++) {
            if (Hogwarts.courses.get(i).getCourseID().equals(c.getCourseID())) {
                Hogwarts.courses.get(i).changeTeacher(teacher);
            }
        }
    }
    public void addCourse(String coursename, List<Course> allCourses, Teacher teacher) {
        for (int i = 0; i < allCourses.size(); i++) {
            if (allCourses.get(i).getCourseName().equals(coursename)) {
                addCourse(allCourses.get(i), teacher);
            }
        }
    }
    public void scoring() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < courses.size(); i++) {
            System.out.print(courses.get(i).getCourseName() + ", ");
        }
        System.out.print("\nenter course name: ");
        String courseName = in.next();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(courseName)) {
                System.out.println(courses.get(i).getStudents());
                System.out.print("enter score of students: ");
                for (int j = 0; j < courses.get(i).getStudents().size(); j++) {
                    String studentName = courses.get(i).getStudents().get(j);
                    Double score = in.nextDouble();
                    courses.get(i).scoring(studentName, score);
                }
            }
        }
    }
    public void getStudent() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < courses.size(); i++) {
            System.out.print(courses.get(i).getCourseName() + ", ");
        }
        System.out.print("\nenter course name: ");
        String courseName = in.next();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(courseName)) {
                System.out.println(courses.get(i).getStudents());
            }
        }
    }

    public void getCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.print(courses.get(i).getCourseName() + ", ");
        }
        System.out.print("\n");
    }
    public void addTeacherScore(Course course, Double TeacherScore) {
        HashMap<UUID,Double> save = new HashMap<>();
        save.put(course.getCourseID(), TeacherScore);
        this.scores.add(save);
    }
    public void getTeacherScore() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.print(courses.get(i).getCourseName() + ' ' + courses.get(i).getCourseID() + ": ");
            Double TeacherScore = 0.0, cnt = 0.0;
            for (int j = 0; j < scores.size(); j++) {
                if (scores.get(j).get(courses.get(i).getCourseID()) != null) {
                    cnt = cnt + 1.0;
                    TeacherScore += scores.get(j).get(courses.get(i).getCourseID());
                }
            }
            if (cnt == 0.0) {
                System.out.println("score not exist");
            }
            else {
                System.out.println(TeacherScore / cnt);
            }
        }
    }
}