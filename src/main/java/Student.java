import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Student {
    String student;
    String passWord;
    static UUID username1;
    static UUID username2;
    static UUID Username;
    static String UserName;
    static int hash1;
    static int hash2;
    static ArrayList<String> takeCourse = new ArrayList<>(); // Declare takeCourse as a class-level variable

    public Student(String student, String passWord) {
        this.student = student;
        this.passWord = passWord;
    }

    public Student(String str) {
    }

    public String getStudent() {
        return student;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void username(String str) throws NoSuchMethodException {

        ArrayList<Student> Studentslist = new ArrayList<>();
        Student student1 = new Student("H@arrythe_CHOSENone", "19800731harry");
        Student student2 = new Student("dr@c0M@lf0y", "19800605draco");



        username1 = UUID.nameUUIDFromBytes(student1.student.getBytes());
        username2 = UUID.nameUUIDFromBytes(student2.student.getBytes());
        hash1 = student1.passWord.hashCode();
        hash2 = student2.passWord.hashCode();

        System.out.println("Enter the username:");
        Scanner scanner = new Scanner(System.in);
        UserName = scanner.next();
        Username = UUID.nameUUIDFromBytes(UserName.getBytes());
        TheAccount userName = new TheAccount();
        TheAccount.Settings theusername = userName.new Settings();
        theusername.validateUsername(username1, username2, Username, hash1, hash2);
    }

    public void password(String str) throws NoSuchMethodException {
        System.out.println("Enter the password:");
        Scanner scanner = new Scanner(System.in);
        String passCode = scanner.next();

        TheAccount passcode = new TheAccount();
        TheAccount.Settings passcode2 = passcode.new Settings();
        passcode2.validatePassword(username1, username2, Username, str, passCode, hash1, hash2);
    }

    public static void student() {
        System.out.println("Here is the menu. Please choose:");
        ArrayList<String> menu = new ArrayList<>();
        menu.add("take a courses");
        menu.add("view courses");
        menu.add("sorting hat");

        for (String option : menu) {
            System.out.println(option);
        }

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        if (str.equals("take a courses")) {
            takecourse();
        }

        if (str.equals("view courses")) {
            viewCourses();
        }

        if (str.equals("sorting hat")) {
            SortingHat();
        }

        if(str.equals("changeUsername")){
            TheAccount obj = new TheAccount();
            TheAccount.Settings obj2= obj.new Settings();
            obj2.changeUsername(str,username1,username2);
        }

        if(str.equals("changePassword")){
            TheAccount obj = new TheAccount();
            TheAccount.Settings obj2= obj.new Settings();
            obj2.changePassword(str,username1,username2);
        }
    }

    public static void takecourse() {
        System.out.println("Type the name of the course and then, type 'done':");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) {
            takeCourse.add(input);
        }

        System.out.println("Course(s) added");
        student();
    }

    public static void viewCourses() {
        // Logic to view courses
        System.out.println("Viewing courses:");
        // Print the courses
        System.out.println("Courses taken:");
        for (String course : takeCourse) {
            System.out.println(course);
        }
        student();
    }

    public static void SortingHat(){

    }
}
