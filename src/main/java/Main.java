

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static <string> void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        ArrayList<Student> studentsList = new ArrayList<>();
        ArrayList<Teacher> teachersList = new ArrayList<>();
        ArrayList <Course> coursesList = new ArrayList<>();

        ArrayList<Course> listfirst = new ArrayList<>();
        ArrayList<Course> listsecond = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        int input;
        do{
            System.out.println("1-Student\n2-Teacher\n3-Admin\n4-Exit");
            input=scanner.nextInt();
            switch (input){
                case 1:
                    do {
                        System.out.println("1-Log in\n2-Sign in\n3-Exit");
                        input=scanner.nextInt();
                        switch (input){
                            case 1:
                                System.out.println("Enter Your Username");
                                String username=scanner.next();
                                System.out.println("Enter Your Password");
                                String password = scanner.next();
                                if(checkUserPassS(studentsList,username,password)!=null){
                                    Student student =checkUserPassS(studentsList,username,password);
                                    studentMenu(student,listsecond);
                                }


                                break;
                            case 2:
                                System.out.println("Enter Your Name:");
                                String name =scanner.next();
                                System.out.println("Enter Username");
                                username=scanner.next();
                                System.out.println("Enter Your Password");
                                password= scanner.next();
                                Student newstudet= new Student(name,username,password);
                                studentsList.add(newstudet);
                                System.out.println();
                                break;
                            default:
                                //
                                break;
                        }
                    }while (input!=3);
                    break;
                case 2:
                    do {
                        System.out.println("1-Log in\n2-Sign in\n3-Exit");
                        input=scanner.nextInt();
                        switch (input){
                            case 1:
                                System.out.println("Enter Your Username");
                                String username=scanner.next();
                                System.out.println("Enter Your Password");
                                String password = scanner.next();
                                if(checkUserPassT(teachersList,username,password)!=null){
                                    Teacher teacher =checkUserPassT(teachersList,username,password);
                                    teacherMenu(teacher,listfirst,listsecond);
                                }


                                break;
                            case 2:
                                System.out.println("Enter Your Name:");
                                String name =scanner.next();
                                System.out.println("Enter Username");
                                username=scanner.next();
                                System.out.println("Enter Your Password");
                                password= scanner.next();
                                Teacher newteacher= new Teacher(name,username,password);
                                teachersList.add(newteacher);
                                break;
                            default:
                                //
                                break;
                        }
                    }while (input!=3);
                    break;
                case 3:
                    do {
                        System.out.println("1-Log in\n2-Exit");
                        input=scanner.nextInt();
                        if(input==1){
                            System.out.println("Enter Username:");
                            String username=scanner.next();
                            System.out.println("Enter Password:");
                            String password=scanner.next();
                            if(checkUserPassA(username,password)==true) {
                                adminMenu(studentsList, teachersList, coursesList, listfirst);
                            }
                            else System.out.println("its not correct");
                        }

                    }while (input!=2);
                    break;
            }
        }while(input!=4);
        Assistant aa = new Assistant();
        aa.seeStudentsList(studentsList);
    }

    public static Student checkUserPassS(ArrayList<Student> studentsList, String u, String p) {
        for (Student student : studentsList) {
            boolean checku = student.getUsername().equals(u);
            boolean checkp = student.getPassword().equals(p);
            if (checkp && checku) {
                return student;
            }
        }
        System.out.println("Username or password is incorrect.");
        return null;
    }
    public static void studentMenu(Student student, ArrayList<Course> listsecond) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.println("1-Choose Course\n2-Display My Courses\n3-Change Username\n4-Change Password\n5-Exit");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    student.seeCoursList(listsecond);
                    System.out.println("Which Course Do You Want?");
                    int chosenCourse = scanner.nextInt();
                    student.chooseCourseList(listsecond, chosenCourse);
                    System.out.println("Course chosen successfully.");
                    break;
                case 2:
                    student.seeStudentCourses();
                    break;
                case 3:
                    System.out.println("Enter Your New Username");
                    String newUsername = scanner.next();
                    student.setUserName(newUsername);
                    System.out.println("Username changed successfully.");
                    break;
                case 4:
                    System.out.println("Enter your New Password");
                    String newPassword = scanner.next();
                    student.setPassword(newPassword);
                    System.out.println("Password changed successfully.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (input != 5);
    }
    public static Teacher checkUserPassT(ArrayList<Teacher> teacherList,String u , String p){
        for (Teacher teacher :teacherList){
            boolean checku =true;
            boolean checkp =true;
            checku=teacher.getUsername().equals(u);
            checkp=teacher.getPassword().equals(p);
            if(checkp==true && checku==true){
                return teacher;
            }
        }
        System.out.println("its not correct");
        return null;
    }
    public static void teacherMenu(Teacher teacher, ArrayList<Course> firstList, ArrayList<Course> secondList) {
        Scanner scanner = new Scanner(System.in);
        int input;
        int number;
        do {
            System.out.println("1-Choose Course\n2-Display My Courses\n3-Set Score\n4-Change Username\n5-Change Password\n6-Exit");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    teacher.seeCourseList(firstList);
                    number = scanner.nextInt();
                    teacher.chooseCourseList(firstList, number, secondList);
                    break;
                case 2:
                    teacher.seeTeacherCourses();
                    break;
                case 3:
                    teacher.seeTeacherCourses();
                    System.out.println("\nWhich Course Do You Want?");
                    number = scanner.nextInt();
                    teacher.seeCourseStudents(number);
                    System.out.println("Enter The Student Number:");
                    int studentNumber = scanner.nextInt();
                    System.out.println("Enter The Score:");
                    int score = scanner.nextInt();
                    teacher.setScoreStudents(number, studentNumber, score);
                    break;
                case 4:
                    System.out.println("Enter Your New Username");
                    String newUsername = scanner.next();
                    teacher.setUsername(newUsername);
                    System.out.println("Username changed successfully.");
                    break;
                case 5:
                    System.out.println("Enter your New Password");
                    String newPassword = scanner.next();
                    teacher.setPassword(newPassword);
                    System.out.println("Password changed successfully.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        } while (input != 6);
    }
   public static boolean checkUserPassA(String u ,String p){
        Assistant check =new Assistant();
        if(Objects.equals(check.getUsername(), u)&& Objects.equals(check.getPassword(), p)){
            return true;
        }
        else return false;
   }
    public static void adminMenu(ArrayList<Student> studentsList,ArrayList<Teacher> teachersList,ArrayList<Course>coursesList,ArrayList<Course>firstList){
        Scanner scanner=new Scanner(System.in);
        int input,number;
        do{
            System.out.println("1-Display Students\n2-Display Teachers\n3-Display Courses\n4-Remove Student\n5-Remove Teacher\n6-Remove Course\n7-Creat Course\n8-Exit");
            Assistant admin =new Assistant();
            input=scanner.nextInt();
            switch (input){
                case 1 :
                    admin.seeStudentsList(studentsList);
                    break;
                case 2 :
                    admin.seeaTeachersList(teachersList);
                    break;
                case 3 :
                    admin.seeaCoursesList(coursesList);
                    break;
                case 4 :
                    admin.seeStudentsList(studentsList);
                    System.out.println("Enter The Student Number");
                    number =scanner.nextInt();
                    admin.removeStudent(number,studentsList);
                    break;
                case 5 :
                    admin.seeaTeachersList(teachersList);
                    System.out.println("Enter The Teacher Number");
                    number =scanner.nextInt();
                    admin.removeTeacher(number,teachersList);
                    break;
                case 6 :
                    admin.seeaCoursesList(coursesList);
                    System.out.println("Enter The Course Number");
                    number =scanner.nextInt();
                    admin.removeCourse(number,coursesList);
                    break;
                case 7 :
                    System.out.println("Enter Course Name");
                    String coursename=scanner.next();
                    Course newcourse= new Course();
                    newcourse.setCourseName(coursename);
                    coursesList.add(newcourse);
                    firstList.add(newcourse);
                    break;
            }

        }while (input!=8);
    }
}
//end