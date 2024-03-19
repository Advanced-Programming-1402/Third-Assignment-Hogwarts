import java.util.*;
public class Teacher extends Account{
    List<Course> courses;
    List<HashMap<Course , Double>> scores = new ArrayList<>();
    private String password;

    public Teacher(String password , String username){//the constructor
        courses = new ArrayList<>();
        super(password , username);
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void signup(){

        signUp(password);//inherit from the superclass, Account
    }
    public void addingCourse(Course takenCourse){
        courses.add(takenCourse);
        takenCourse.changeTeacherName(getUsername());
    }
    public void addCourse(String courseName , List<Course>courses){
        for(int i = 0  ; i < courses.size() ; i++){
            if(courses.get(i).getCourseName().equals(courseName)){
                addCourse(courses.get(i));
            }
        }
    }
    public void scoring(){
        Scanner input = new Scanner(System.in);
        for(int i = 0 ; i < courses.size() ; i++){
            System.out.println(courses.get(i).getCourseNAme() + " : ");
        }
        System.out.println("Please Enter the name of the course : ");
        String courseName = input.nextLine();
        for(int i = 0 ; i < courses.size() ; i++){
            if(courses.get(i).getCourseName().equals(courseName)){
                System.out.println(courses.get(i).getStudents());
                System.out.println("Please Enter the score of this student : ");
                for(int k = 0 ; k < courses.get(i).getStudents().size() ; k++){
                    String nameOfStudent = courses.get(i).getStudents().get(k);
                    Double score = input.nextDouble();
                    courses.get(i).scoring(studentName , score);
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
                System.out.println(courses.get(i).getStudent());
            }
        }
    }
    public void addTeacherScore(Course course , Double TeacherScore) {
        HashMap<Course , Double> temp = new HashMap<>();
        temp.put(course , TeacherScore);
        this.scores.add(temp);
    }
    public Double getTeacherScore() {
        for(int i = 0 ; i < courses.size() ; i++) {
            System.out.println(courses.get(i).getCourseName() + " " + courses.get(i).getCourseID() + " : ");
            Double TeacherScore = 0.0;
            Double counter = 0.0;
            for(int j = 0 ; j < scores.size() ; i++){
                if(scores.get(j).get(courses.get(i)) != 0.0){
                    counter++;
                    TeacherScore += scores.get(j).get(courses.get(i));
                }
            }
            if(counter == 0.0){
                System.out.println("Invalid");
            }
            else{
                System.out.println(TeacherScore/Counter);
            }
        }
        Double TeacherScore = 0.0;
        Double quantityOfTheTeachers = (double)teacherScore.size();
        for(int i = 0 ; i < teacherScores.size() ; i++) {
            TeacgerScore += teacherScores.get(i);
        }
        return TeacherScore/quantityOfTheTeachers;
    }


}
