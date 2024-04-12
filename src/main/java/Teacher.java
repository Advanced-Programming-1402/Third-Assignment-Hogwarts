import java.util.ArrayList;
import java.util.List;
public class Teacher {
    private String name;
    private String username;
    private String password;
    private int userId;
    private ArrayList<Course> teachearCourses=new ArrayList<>();

    public Teacher(String n ,String u , String p ){
        name= n;
        username= u;
        password=p;
    }
    public String getName(){return name;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public void seeCourseList (ArrayList<Course> courseList){
        int i=1;
       for(Course course : courseList){
           System.out.println(i+"- "+ course.getCourseName());
           i++;
       }
    }
    public void chooseCourseList(ArrayList<Course> courseList,int a,ArrayList<Course> choosenCourses){
        Course course = courseList.get(a-1);
        teachearCourses.add(course);
        course.setCourseTeacherName(this.name);
        choosenCourses.add(course);
        courseList.remove(a-1);

    }
    public void seeTeacherCourses (){
        int i=1;
        for (Course course : teachearCourses) {
            System.out.println(i+"- "+course.getCourseName());
        }
    }
    public void seeCourseStudents (int a){
        Course course =teachearCourses.get(a-1);
        course.seeCourseStudents();
    }
    public void setScoreStudents(int a,int number, double score) {
        Course course = teachearCourses.get(a-1);
        course.setCourseStudentsScore(score,number);
    }

    }
//end

