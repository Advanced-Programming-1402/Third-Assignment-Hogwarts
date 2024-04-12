import java.util.ArrayList;

public class Student {
    private String name;
    private int userId;
    private String username ;
    private String password;
    private ArrayList<Course> studentCourses= new ArrayList<>();
    public Student(String n , String u , String p){
        name = n;
        username = u;
        password = p;
    }
    public void setUserName(String u){username=u;}
    public void setPassword(String p){password=p;}
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getUsername(){
        return username;
    }


    public void seeCoursList (ArrayList<Course> coursList) {
        int i = 1;
        for (Course course : coursList) {
            System.out.println(i + "- " + course.getCourseName()+"  Teacher: "+course.getCourseTeacherName());
            i++;
        }
    }
    public void chooseCourseList(ArrayList<Course> courseList,int a){
    Course course = courseList.get(a-1);
    studentCourses.add(course);
    Student thisStudent=new Student(this.name , this.username,this.password);
    course.setCourseStudents(thisStudent);
    }
    public void seeStudentCourses (){
        int i=1;
        for (Course course : studentCourses){
            System.out.println(i+"- "+course.getCourseName()+"  Teacher: "+course.getCourseTeacherName());
        }
    }


}
//end