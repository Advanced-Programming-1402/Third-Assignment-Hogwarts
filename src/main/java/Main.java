import javax.swing.plaf.IconUIResource;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Assistant assistant = new Assistant("fatemelashkari" ,"1384");
        Hogwarts.addAssistant(assistant);
        runMenu();
    }

    public static void assistantMenu(Assistant assistant) {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Hi... Welcome To Our Platform :)  ");
            System.out.println("Please Enter the number of your desire option :  ");
            System.out.println("1.Check Profile");
            System.out.println("2.Teacher Request");
            System.out.println("3.Remove Student Or Teacher");
            System.out.println("4.Create A New Course");
            System.out.println("5.View The information of Courses");
            System.out.println("6.Settings");
            System.out.println("7.New Assistant");
            System.out.println("8.Log Out");

            int choice = input.nextInt();
            while(choice > 8 || choice < 1) {
                System.out.println("Invalid Data ...");
                choice = input.nextInt();
            }
            switch(choice){
                case 1:
                    System.out.println("Please determine the role of the person you want to check theis profile : ");
                    System.out.println("1.Teacher");
                    System.out.println("2.Student");
                    int option = input.nextInt();
                    switch(option){
                        case 1 :
                            System.out.println("Who you want to check : ");
                            for(int i = 0 ; i < Hogwarts.teachers.size() ; i++) {
                                System.out.println((i + 1) + Hogwarts.teachers.get(i).getUsername());
                            }
                                int userhoice1 = input.nextInt();
                                System.out.println("UserName : " + Hogwarts.teachers.get(userhoice1-1).getUsername());
                                System.out.println("PassWord : " +Hogwarts.teachers.get(userhoice1-1).getPassword());
                                System.out.print("Courses : ");
                                for(int j = 0 ; j < Hogwarts.teachers.get(userhoice1-1).courses.size(); j++) {
                                    Course course = Hogwarts.teachers.get(userhoice1-1).courses.get(j);
                                    System.out.print(course.getCourseName() + " : ");
                                    for(int k = 0 ; k < course.getStudents().size() ; k++ ){
                                        System.out.print(course.getStudents().get(k));
                                    }
                                }
                                System.out.println();
                                System.out.println(Hogwarts.teachers.get(userhoice1-1));


                            break;
                        case 2 :
                            System.out.println("Who you want to check : ");
                            for(int i = 0 ; i < Hogwarts.students.size() ; i++) {
                                System.out.println((i+1) + Hogwarts.students.get(i).getUsername());
                            }
                            int userchoice2 = input.nextInt();
                            System.out.println("UserName : " + Hogwarts.students.get(userchoice2-1).getUsername());
                            System.out.println("PassWord : " +Hogwarts.students.get(userchoice2-1).getPassword());
                            System.out.print("Courses : ");
                            for(int i = 0 ; i < Hogwarts.students.get(userchoice2-1).courses.size() ; i++) {
                                Course course = Hogwarts.students.get(userchoice2-1).courses.get(i);
                                System.out.print(course.getCourseName() + "Teacher : " + course.courseTeacher.getUsername() + "Score : " + course.studentScore.get(Hogwarts.students.get(userchoice2).getUsername()));
                            }
                            break;
                    }
                    break;
                case 2:
                    assistant.teacherRegister();
                    break;
                case 3:
                    System.out.println("Do you want to remove a student or a teacher ? ");
                    System.out.println("1.Student");
                    System.out.println("2.Teacher");
                    int input1 = input.nextInt();
                    while(input1 < 1 || input1 > 2) {
                        System.out.println("Invalid Data ...");
                        input1 = input.nextInt();
                    }
                    switch(input1){
                        case 1 :
                            Hogwarts.viewAllTeachers();
                            System.out.println("Please Enter the name of the teacher that you want to remove : ");
                            String removingTeacherName = input.nextLine();
                            boolean isExist = false;
                            for(int i = 0 ; i < Hogwarts.teachers.size() ; i++) {
                                if(Hogwarts.teachers.get(i).getUsername() == removingTeacherName) {
                                    isExist = true;
                                }
                            }
                            if(!isExist) {
                                System.out.println("Something went wrong, This user in not exist...");
                            }
                            else {
                                Teacher teacher = new Teacher(" " , removingTeacherName);
                                for(int i = 0 ; i < Hogwarts.teachers.size() ; i++) {
                                    if(Hogwarts.teachers.get(i).getUsername() == removingTeacherName) {
                                        Hogwarts.teachers.remove(teacher);
                                    }
                                }
                                for(int i = 0 ; i < teacher.courses.size() ; i++){
                                    teacher.courses.remove(teacher);
                                }
                                for(int i = 0 ; i < Hogwarts.courses.size() ; i++) {
                                    Hogwarts.courses.remove(teacher);
                                }
                                for(int i = 0 ; i < Hogwarts.teachers.size() ; i++){
                                    Hogwarts.teachers.remove(teacher);
                                }
                            }
                            break;
                        case 2 :
                            Hogwarts.viewAllStudents();
                            System.out.println("Please Enter the name of the student which you want to remove it : ");
                            String studentName = input.nextLine();
                            isExist = false;
                            for(int i = 0 ; i < Hogwarts.students.size() ; i++) {
                                if(Hogwarts.students.get(i).getUsername() == studentName) {
                                    isExist = true;
                                }
                            }
                            if(!isExist) {
                                System.out.println("Something went wrong, This user in not exist...");
                            }
                            else {
                                Student student = new Student(studentName , "");
                                for(int i = 0 ; i < Hogwarts.students.size() ; i++) {
                                    if (Hogwarts.students.get(i).getUsername() == studentName) {
                                        student = Hogwarts.students.get(i);
                                    }
                                }
                                Hogwarts.students.remove(student);
                                for(int i = 0 ; i < student.courses.size() ; i++) {
                                    student.courses.get(i).students.remove(studentName);
                                }
                                for(int i = 0 ; i < Hogwarts.courses.size() ; i++) {
                                    Hogwarts.courses.get(i).students.remove(studentName);
                                }
                                for(int i = 0 ; i < Hogwarts.teachers.size() ; i++) {
                                    for(int j = 0 ; j < Hogwarts.teachers.get(i).courses.size();j++) {
                                        Hogwarts.teachers.get(i).courses.get(j).students.remove(studentName);
                                    }
                                }
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Please Enter the name of the course : ");
                    String courseName = input.nextLine();
                    System.out.println("Please Enter the name of the teacher : ");
                    String teacherName = input.nextLine();
                    Teacher teacher1 = new Teacher("" , "");
                    Course course1 = new Course(teacher1 , courseName , teacherName);
                    Hogwarts.courses.add(course1);
                    break;
                case 5:
                    for(int i = 0 ; i < Hogwarts.courses.size() ; i++) {
                        Course course = Hogwarts.courses.get(i);
                        System.out.print(course.getCourseName() + " : ");
                        System.out.println(course.getInformation() + " " + course.courseTeacher.getUsername());
                        for (int j = 0; j < course.getStudents().size(); j++) {
                            System.out.print(course.getStudents().get(j));
                        }
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.println("1.Change PassWord \n2.Change UserName");
                    int userchoice3 = input.nextInt();
                    while(userchoice3 > 2 || userchoice3 < 1) {
                        System.out.println("Invalid Data...");
                        userchoice3 = input.nextInt();
                    }
                    switch(userchoice3){
                        case 1 :
                            System.out.println("Please Enter your new password : ");
                            String newPass = input.nextLine();
                            assistant.changePassword(newPass);
                            break;
                        case 2 :
                            System.out.println("Please Enter your new username : ");
                            String newUsername = input.nextLine();
                            if(newUsername != assistant.getUsername()) {
                                boolean isExist = false;
                                for(int i = 0 ; i < Hogwarts.assistants.size() ; i++) {
                                    if(Hogwarts.assistants.get(i).getUsername() == newUsername) {
                                        isExist = true;
                                    }

                                }
                                if(isExist == true) {
                                    System.out.println("This username is already exist");
                                }
                                else {
                                    assistant.changeUsername(newUsername);
                                }
                            }
                            break;
                    }
                    break;
                case 7:
                    while(true) {
                        System.out.println("Please Enetr the username of the assistant that you want to add it : ");
                        String assistantUsername = input.nextLine();
                        boolean isExisted = false;
                        for(int i = 0 ; i < Hogwarts.assistants.size() ; i++) {
                            if(Hogwarts.assistants.get(i).getUsername() == assistantUsername) {
                                isExisted = true;
                            }
                        }
                        if(isExisted) {
                            System.out.println("Sorry... This username is already exist!");
                        }
                        else {
                            System.out.println("Please Enter the assistant's password : ");
                            String assistantPassword = input.next();
                            Assistant newAssistant = new Assistant(assistantUsername , assistantPassword);
                            Hogwarts.assistants.add(newAssistant);

                        }
                    }

                case 8:
                    break;

            }
        }
    }
    public static void teacherMenu(Teacher teacher) {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Hi... Welcome To Our Platform :)  ");
            System.out.println("Please Enter the number of your desire option :  ");
            System.out.println("1.Request To Create A New Course");
            System.out.println("2.Show Teacher's Courses");
            System.out.println("3.Scoring");
            System.out.println("4.Show The Teacher's Scores");
            System.out.println("5.Settings");
            System.out.println("6.Log Out");
            int choice = input.nextInt();
            while(choice > 6 || choice < 1 ) {
                System.out.println("Invalid Data...");
                choice = input.nextInt();
            }
            switch(choice) {
                case 1 :
                    Hogwarts.requestForCourse(teacher);
                    break;
                case 2 :
                    teacher.getStudent();
                    break;
                case 3 :
                    Hogwarts.setScore(teacher);
                    break;
                case 4 :
                    teacher.getTeacherScore();
                    break;
                case 5 :
                    System.out.println("1.Change PassWord \n2.Change UserName");
                    int userChoice = input.nextInt();
                    while(userChoice > 2 || userChoice < 1) {
                        System.out.println("Invalid Data ...");
                        System.out.println("1.Change PassWord \n2.Change UserName");
                        userChoice = input.nextInt();
                    }
                    switch(userChoice) {
                        case 1 :
                            System.out.println("Please Enter your new password : ");
                            String newPassword = input.next();
                            teacher.changePassword(newPassword);
                            break;
                        case 2 :
                            System.out.println("Please Enter your new username : ");
                            String newUsername = input.next();
                            boolean isExist = false;
                            for(int i = 0 ; i < Hogwarts.teachers.size() ; i++) {
                                if(Hogwarts.teachers.get(i).getUsername() == newUsername) {
                                    isExist = true;
                                }
                            }
                            if(isExist == true) {
                                System.out.println("This username is already exist ...");
                            }
                            else {
                                String chosenUsername = teacher.getUsername();
                                teacher.changeUsername(newUsername);
                                for(int i = 0 ; i < Hogwarts.teachers.size() ; i++) {
                                    if(Hogwarts.teachers.get(i).getAccountID() == teacher.getAccountID()) {
                                        Hogwarts.teachers.get(i).changeUsername(newUsername);
                                    }
                                }
                                for(int i = 0 ; i < Hogwarts.courses.size() ; i++) {
                                    if(Hogwarts.courses.get(i).getCourseTeacher().getAccountID() == teacher.getAccountID()) {
                                        Hogwarts.courses.get(i).changeTeacher(teacher);
                                    }
                                }
                                for(int i = 0 ; i < Hogwarts.students.size() ; i++) {
                                    Student student = Hogwarts.students.get(i);
                                    for(int j = 0 ; j < student.getTeachers().size() ; j++) {
                                        if(student.courses.get(j).getCourseTeacher().getAccountID() == teacher.getAccountID()) {
                                            student.courses.get(j).changeTeacher(teacher);
                                        }
                                    }
                                }
                                for(int i = 0 ; i < Assistant.tempTeacher.size() ; i++) {
                                    if(Assistant.tempTeacher.get(i).getUsername() == teacher.getUsername()) {
                                        Assistant.tempTeacher.get(i).changeUsername(chosenUsername);
                                    }
                                }
                            }
                            break;
                    }
                    break;
                case 6 :
                    break;
            }
        }
    }
    public static void studentMenu(Student student) {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Hi... Welcome To Our Platform :)  ");
            System.out.println("Please Enter the number of your desire option :  ");
            System.out.println("1.Take A New Course");
            System.out.println("2.Show The Courses");
            System.out.println("3.Show The Teachers");
            System.out.println("4.Show The Teacher's Scores");
            System.out.println("5.Settings");
            System.out.println("6.Log Out");
            int choice = input.nextInt();
            while(choice > 6 || choice < 1 ) {
                System.out.println("Invalid Data...");
                choice = input.nextInt();
            }
            switch(choice) {
                case 1 :
                    System.out.println("Please Enter the number of each course that you want : ");
                    for(int i = 0 ; i < Hogwarts.courses.size() ; i++) {
                        Course course = Hogwarts.courses.get(i);
                        System.out.println((i+1) + course.getCourseName() + course.getCourseTeacher().getUsername() + Course.getCourseID());
                    }
                    int userChoice = input.nextInt();
                    if(userChoice > Hogwarts.courses.size()) {
                        System.out.println("Invalid Data....");
                    }
                    else {
                        Course course = Hogwarts.courses.get(userChoice);
                        boolean isExist = false;
                        for(int i = 0 ; i < student.courses.size() ; i++) {
                            if(student.courses.get(i).getCourseID() == course.getCourseID()) {
                                isExist = true;
                            }

                        }
                        if(isExist == true) {
                            System.out.println("This course is already exist...");
                        }
                        else {
                            student.addCourse(course);
                        }
                    }
                    break;
                case 2 :
                    for(int i = 0 ; i < student.getCourses().size() ; i++) {
                        System.out.print(student.getCourses().get(i).getCourseName() + " ");
                    }
                    System.out.println();
                    break;
                case 3 :
                    break;
                case 4 :
                    System.out.println("Do you want to see the teacher's score for which course : ");
                    for(int i = 0 ; i < student.courses.size() ; i++) {
                        Course course = student.courses.get(i);
                        System.out.println((i+1) + course.getCourseName() + course.getCourseTeacher().getUsername() + course.getCourseID());
                    }
                    int userChoice2 = input.nextInt();
                    while(userChoice2 > student.courses.size() || userChoice2 < 1) {
                        System.out.println("Invalid Data!!!");
                        userChoice2 = input.nextInt();
                    }
                    Course course = student.courses.get(userChoice2);
                    UUID tempuuid = UUID.randomUUID();
                    System.out.println("You have already score this teacher!!!");
                    break;
                case 5 :
                    System.out.println("1.Change PassWord \n2.Change UserName ");
                    int userChoice3 = input.nextInt();
                    while(userChoice3 > 2 || userChoice3 < 1) {
                        System.out.println("Invalid Data !!!");
                        userChoice3 = input.nextInt();
                    }
                    switch (userChoice3) {
                        case 1 :
                            System.out.println("Please Enter your new password : ");
                            String newPassword = input.next();
                            student.changePassword(newPassword);
                            break;
                        case 2 :
                            String theUsername = student.getUsername();
                            while(true) {
                                System.out.println("Please Enter your new username : ");
                                String newUsername = input.next();
                                if(newUsername != student.getUsername()) {
                                    boolean isExist = false;
                                    for(int i = 0 ; i < Hogwarts.students.size() ; i++) {
                                        if(Hogwarts.students.get(i).getUsername() == newUsername) {
                                            isExist = true;
                                        }
                                    }
                                    if(isExist == true) {
                                        System.out.println("this username is already exist!!");
                                    }
                                    else {
                                        student.changeUsername(newUsername);
                                        for(int i = 0 ; i < Hogwarts.courses.size() ; i++) {
                                            Course course2 = Hogwarts.courses.get(i);
                                            for (int j = 0; j < course2.getStudents().size(); j++) {
                                                if (course2.getStudents().get(j) == theUsername) {
                                                    course2.getStudents().get(j).equals(newUsername);
                                                }
                                                course2.studentScore.put(theUsername, course2.studentScore.get(theUsername));
                                                course2.studentScore.remove(theUsername);
                                            }
                                        }
                                    }
                                }
                            }

                    }
                    break;
                case 6 :
                    break;
            }
        }
    }

    public static void runMenu() {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Who are you : ");
            System.out.println("1.Student");
            System.out.println("2.Teacher");
            System.out.println("3.Assistant");
            int role = input.nextInt();
            while(role > 3 || role < 1) {
                System.out.println("Invalid Data!!!");
                role = input.nextInt();
            }
            switch(role) {
                case 1 :
                    System.out.println("Do You want to :  \n1.signup \n2.login");
                    int userchoice = input.nextInt();
                    switch (userchoice) {
                        case 1 :

                            while(true) {
                                System.out.println("Please Enter Your UserName : ");
                                String userUsername = input.next();
                                boolean isExist = false;
                                for(int i = 0 ; i < Hogwarts.students.size() ; i++) {
                                    if(Hogwarts.students.get(i).getUsername() == userUsername) {
                                        isExist = true;
                                    }
                                }
                                while(isExist == true) {
                                    System.out.println("This username is already exist please try another one : ");
                                    userUsername = input.next();
                                    isExist = false;
                                    for(int i = 0 ; i < Hogwarts.students.size() ; i++) {
                                        if(Hogwarts.students.get(i).getUsername() == userUsername) {
                                            isExist = true;
                                        }
                                    }
                                }
                                System.out.println("Please Enter your password : ");
                                String userPassword = input.next();
                                Student student = new Student(userUsername , userPassword);
                                Hogwarts.students.add(student);
                                break;
                            }
                            break;
                        case 2 :
                            while(true) {
                                System.out.println("Please Enter your username : ");
                                String userUsername = input.next();
                                boolean isExist2 = false;
                                Student student = new Student("","");
                                for(int i = 0 ; i < Hogwarts.students.size() ; i++) {
                                    if(Hogwarts.students.get(i).getUsername() == userUsername) {
                                        student = Hogwarts.students.get(i);
                                        isExist2 = true;
                                    }

                                }
                                if(isExist2 == false) {
                                    System.out.println("This user is not found ...");
                                }
                                else {
                                    while(true) {
                                        System.out.println("Please enter your password : ");
                                        String userPassword = input.next();
                                        if(student.validatePassword(userPassword)) {
                                            studentMenu(student);
                                            break;
                                        }
                                        else{
                                            System.out.println("Your password is not correct!!!");
                                        }
                                    }
                                }
                            }
                    }
                    break;
                case 2 :
                    System.out.println("1.SignUp \n2.Login");
                    int user = input.nextInt();
                    switch(user){
                        case 1 :
                            while(true) {
                                System.out.println("Please Enter your username :");
                                String userUsername = input.next();
                                boolean isExist = false;
                                for(int i = 0 ; i < Hogwarts.teachers.size() ; i++) {
                                    if(Hogwarts.teachers.get(i).getUsername() == userUsername) {
                                        isExist = true;
                                    }
                                }
                                if(isExist == false){
                                    System.out.println("This user is already exist!!!");
                                }
                                else {
                                    System.out.println("Please Enter your password : ");
                                    String userPassWord = input.next();
                                    Teacher teacher = new Teacher(userUsername ,userPassWord);
                                    teacher.setPassword(userPassWord);
                                    Hogwarts.teachers.add(teacher);
                                    Assistant.tempTeacher.add(teacher);
                                    System.out.println("Successful..");
                                    break;
                               }
                            }
                            break;
                        case 2 :
                            while(true) {
                                System.out.println("Please Enter you username : ");
                                String userUserName = input.next();
                                boolean isExist = false;
                                Teacher teacher = new Teacher("", "");
                                for(int i = 0 ; i < Hogwarts.teachers.size() ; i++) {
                                    if(Hogwarts.teachers.get(i).getUsername() == userUserName) {
                                        teacher = Hogwarts.teachers.get(i);
                                        isExist = true;
                                    }

                                }
                                if(isExist == false) {
                                    System.out.println("This user is not found!!!");
                                }
                                else {
                                    while(true) {
                                        System.out.println("Please Enter your password : ");
                                        String userPass = input.next();
                                        if(teacher.validatePassword(userPass)) {
                                            teacherMenu(teacher);
                                            break;
                                        }
                                        else {
                                            System.out.println("this password in not correct!!!");
                                        }
                                    }
                                    break;
                                }

                            }
                            break;
                    }
                    break;
                case 3 :
                    while(true) {
                        System.out.println("Please Enter your username :");
                        String userusername = input.next();
                        boolean isExist = false;
                        Assistant assistant = new Assistant("" ,"");
                        for(int i = 0 ; i < Hogwarts.assistants.size() ; i++) {
                            if(Hogwarts.assistants.get(i).getUsername() == userusername) {
                                assistant = Hogwarts.assistants.get(i);
                                isExist = true;
                            }
                        }
                        if(isExist == false) {
                            System.out.println("this user in not exist!!");
                        }
                        else {
                            while(true) {
                                System.out.println("Please Enter your Password : ");
                                String userpass = input.next();
                                if(assistant.validatePassword(userpass)){
                                    assistantMenu(assistant);
                                    break;
                                }
                                else {
                                    System.out.println("Your password is not correct!!");
                                }
                            }
                            break;
                        }
                    }
                    break;
            }

        }
    }
}
