import java.util.*;
public class Teacher extends Account{
    static List<Course> courses;
    List<HashMap<UUID , Double>> scores = new ArrayList<>();
    private String password;
    private static String username;

    public Teacher(String password , String username){
        super(password , username);//the constructor
        courses = new ArrayList<>();
    }

    public void setPassword(String password){

        this.password = password;
    }

    public void signup(){

        signUp(password);//inherit from the superclass, Account
    }
    public static void addingCourse(Course takenCourse, Teacher theTeacher){
        courses.add(takenCourse);
        takenCourse.changeTeacherName(theTeacher.getUsername());
        for(int i = 0 ; i < takenCourse.getStudents().size() ; i++){
            for(int j = 0 ; j < Hogwarts.students.size() ; j++) {
                if(Hogwarts.students.get(j).getUsername().equals(takenCourse.getStudents().get(i))) {
                    //Hogwarts.students.get(j).teachers.add(takenCourse.courseTeacher);
                }
            }
        }
        for(int i = 0 ; i < Hogwarts.courses.size() ; i++) {
            if(Hogwarts.courses.get(i).getCourseID().equals(takenCourse.getCourseID())) {
                Hogwarts.courses.get(i).changeTeacher(theTeacher);
            }
        }
    }
    public void addCourse(String courseName , List<Course>allTheCourses , Teacher teacher){
        for(int i = 0  ; i < courses.size() ; i++){
            if(courses.get(i).getCourseName().equals(courseName)){
                addingCourse(allTheCourses.get(i) , teacher);
            }
        }
    }
    public void scoring(){
        Scanner input = new Scanner(System.in);
        for(int i = 0 ; i < courses.size() ; i++){
            System.out.println(courses.get(i).getCourseName() + " : ");
        }
        System.out.println("Please Enter the name of the course : ");
        String courseName = input.nextLine();
        for(int i = 0 ; i < courses.size() ; i++){
            if(courses.get(i).getCourseName() == courseName){
                System.out.println(courses.get(i).getStudents());
                System.out.println("Please Enter the score of this student : ");
                for(int k = 0 ; k < courses.get(i).getStudents().size() ; k++){
                    String nameOfStudent = courses.get(i).getStudents().get(k);
                    Double score = input.nextDouble();
                    courses.get(i).scoring(nameOfStudent , score);
                }
            }
        }
    }

    public void getStudent(){
        Scanner input = new Scanner(System.in);
        for(int i = 0 ; i < courses.size() ; i++){
            System.out.print(courses.get(i).getCourseName() + " : ");
        }
        System.out.println("Please Enter the name of the course : ");
        String courseName = input.next();
        for(int i = 0 ; i < courses.size() ; i++){
            if(courses.get(i).getCourseName().equals(courseName)) {
                System.out.println(courses.get(i).getStudents());
            }
        }
    }
    public void getCourse(){
        for(int i = 0 ; i < courses.size() ; i++) {
            System.out.print(courses.get(i).getCourseName() + " : ");
        }
        System.out.println();
    }
    public void addTeacherScore(Course course , Double TeacherScore) {
        HashMap<UUID , Double> temp = new HashMap<>();
        temp.put(Course.getCourseID() , TeacherScore);
        this.scores.add(temp);
    }
    public void getTeacherScore() {
        for(int i = 0 ; i < courses.size() ; i++) {
            System.out.println(courses.get(i).getCourseName() + " " + courses.get(i).getCourseID() + " : ");
            Double TeacherScore = 0.0;
            Double counter = 0.0;
            for(int j = 0 ; j < scores.size() ; i++){
                if(scores.get(j).get(courses.get(i)) != null){
                    counter++;
                    TeacherScore += scores.get(j).get(courses.get(i).getCourseID());
                }
            }
            if(counter == 0.0){
                System.out.println("Invalid");
            }
            else{
                System.out.println(TeacherScore/counter);
            }
        }

    }


    public String getUsername() {
        return username;
    }
}
