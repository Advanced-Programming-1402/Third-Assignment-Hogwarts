import java.util.*;
public class Hogwarts {
    static List<Course> courses = new ArrayList<>();

    static List<Student> students = new ArrayList<>();
    static List<Teacher> teachers = new ArrayList<>();
    static List<Assistant> assistants = new ArrayList<>();

    public static void addAssistant(Assistant assistant) {
        assistants.add(assistant);
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public void addCourse(Course course) {
        courses.add(course);
    }

    public static void viewAllTeachers() {
        for(int i = 0 ; i < teachers.size() ; i++){
            System.out.println(teachers.get(i).getUsername() + " ");
        }
    }

    public static void viewAllStudents() {
        for(int i = 0 ; i < students.size() ; i++){
            System.out.println(students.get(i).getUsername() + " ");
        }
    }

    public void viewAllCourses() {
        for(int i = 0 ; i < courses.size() ; i++) {
            System.out.println(courses.get(i).getCourseName() + " ");
        }
    }
    public static void requestForCourse(Teacher teacher) {
        Scanner input = new Scanner(System.in);
        for(int i = 0 ; i < courses.size() ; i++) {
            if(courses.get(i).courseTeacher.getUsername() == " ") {
                System.out.println(courses.get(i).getCourseName() + " " + courses.get(i).getCourseID() + Hogwarts.courses.get(i).getInformation());
            }
        }
        System.out.println("Please Enter the related UUID to chhose the course : ");
        String theUuid = input.nextLine();
        for(int i = 0 ; i < Hogwarts.courses.size() ; i++) {
            if(courses.get(i).courseTeacher.getUsername() != "" && courses.get(i).getCourseID().toString() == theUuid) {
                System.out.println("You can not have a course for some reasons ...");
            }
            else{
                teacher.addingCourse(courses.get(i) , teacher);
            }
        }
    }
    public static void setScore(Teacher teacher) {
        teacher.scoring();
    }
    public static void showTheCourseViauuid(UUID uuid) {
        for(int i = 0 ; i < courses.size() ; i++) {
            if(courses.get(i).getCourseID() == uuid) {
                System.out.print(courses.get(i).getCourseName() + " : ");
                System.out.println("Teacher's Name : " + courses.get(i).courseTeacher.getUsername());
                System.out.println("Student's Name : " );
                for(int k = 0 ; k < courses.get(i).getStudents().size() ; k++) {
                    System.out.println(courses.get(i).getStudents().get(k) + " ");
                }
            }

        }
    }

}
