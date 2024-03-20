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
    public void addCourse(Course cource, Teacher teacher) {
        courses.add(cource);
        cource.changeTeacher(cource.getCourseTeacher());
        for (int i = 0; i < cource.getStudents().size(); i++) {
            for (int j = 0; j < Hogwarts.Students.size(); j++) {
                if (Hogwarts.Students.get(j).getUsername().equals(cource.getStudents().get(i))) {
                    Hogwarts.Students.get(j).Teachers.add(cource.courseTeacher);
                }
            }
        }
        for (int i = 0; i < Hogwarts.Courses.size(); i++) {
            if (Hogwarts.Courses.get(i).getCourseID().equals(cource.getCourseID())) {
                Hogwarts.Courses.get(i).changeTeacher(teacher);
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
            Double TeachersScore = 0.0, counter = 0.0;
            for (int j = 0; j < scores.size(); j++) {
                if (scores.get(j).get(courses.get(i).getCourseID()) != null) {
                    counter += 1.0;
                    TeachersScore += scores.get(j).get(courses.get(i).getCourseID());
                }
            }
            if (counter == 0.0) {
                System.out.println("score not exist");
            }
            else {
                System.out.println(TeachersScore / counter);
            }
        }
    }
}