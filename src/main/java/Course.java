import java.util.ArrayList;

public class Course {
    private String courseName;
    private String courseTeacherName;
    private ArrayList <StudentsClass> courseStudents = new ArrayList<>();


    public void setCourseName(String n){
    courseName=n;
}
    public void setCourseTeacherName(String n){
    courseTeacherName=n;
}
    public  void setCourseStudents(Student s){
        StudentsClass sc= new StudentsClass(s ,0);
        courseStudents.add(sc);
    }
    public  void setCourseStudentsScore( double score,int number){
        StudentsClass sc= courseStudents.get(number-1);
        sc.setScore(score);
        courseStudents.set(number-1,sc);
    }


    public String getCourseName(){return courseName;}
    public String getCourseTeacherName(){return courseTeacherName;}
    public ArrayList<StudentsClass> getCourseStudents(){return courseStudents;}

    public void seeCourseStudents (){
        int i=1;
        for(StudentsClass sc : courseStudents){
        System.out.println(i+"- "+"Name: "+ sc.getName()+" Score"+sc.getScore());
        i++;
    }
}



}
class StudentsClass {
    private Student student;
    private double score=0;
    public StudentsClass(Student student , double score){
        this.student=student;
        this.score=score;
    }
    public  void setScore(double s){score=s;}
    public String getName (){
       return student.getName();
    }
    public double getScore(){
        return score;
    }

}
//end
