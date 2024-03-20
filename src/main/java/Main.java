
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Assistant assistant = new Assistant("ZAHRAMOGHADDASI", "13841384");
        Hogwarts.addAssistant(assistant);
        Assistant host = new Assistant("maasoom","123456");
        Hogwarts.addAssistant(host);
        runMenu();
    }

    public static void AssistantMenu(Assistant assistant) {
        System.out.print("\n\n");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("choose one Of Title: (1)logOut, 2)TeacherRequest, 3)RemoveUser, 4)CreateCourse, 5)CheckProfile, 6)ViewCourseDetail, 7)Setting)");
            String input = in.next();
            while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")
                    && !input.equals("5") && !input.equals("6") && !input.equals("7")) {
                System.out.print("enter correct input: ");
                input = in.next();
            }
            if (input.equals("1")) {
                break;
            }
            else if (input.equals("3")) {
                System.out.print("1)teacher , 2)student? ");
                input = in.next();
                while (!input.equals("1") && !input.equals("2")) {
                    System.out.print("enter correct input: ");
                    input = in.next();
                }
                if (input.equals("1")) {
                    Hogwarts.viewAllTeachers();
                    System.out.print("\n" + "enter teacher name: ");
                    String name = in.next();
                    boolean find = false;
                    while (true) {
                        name = in.next();
                        if (name.equals("back"))
                            break;
                        for (int i = 0; i < Hogwarts.Teachers.size(); i++) {
                            find |= Hogwarts.Teachers.get(i).getUsername().equals(name);
                        }
                        if (find)
                            break;
                        else {
                            System.out.println("enter correct input");
                        }
                    }
                    if (find) {
                        Teacher teacher = new Teacher("", "");
                        Teacher teacher2 = new Teacher("", "");
                        for (int i = 0; i < Hogwarts.Teachers.size(); i++) {
                            if (Hogwarts.Teachers.get(i).getUsername().equals(name)) {
                                teacher = Hogwarts.Teachers.get(i);
                            }
                        }
                        Hogwarts.Teachers.remove(teacher);
                        for (int i = 0; i < teacher.courses.size(); i++) {
                            teacher.courses.get(i).changeTeacher(teacher2);
                        }
                        for (int i = 0; i < Hogwarts.Courses.size(); i++) {
                            if (Hogwarts.Courses.get(i).courseTeacher.equals(teacher)) {
                                Hogwarts.Courses.get(i).changeTeacher(teacher2);
                            }
                        }
                        for (int i = 0; i < Hogwarts.Students.size(); i++) {
                            for (int j = 0; j < Hogwarts.Students.get(i).courses.size(); j++) {
                                if (Hogwarts.Students.get(i).courses.get(j).courseTeacher.equals(teacher)) {
                                    Hogwarts.Students.get(i).courses.get(j).changeTeacher(teacher2);
                                }

                            }
                        }
                    }

                }
                else {
                    Hogwarts.viewAllStudents();
                    System.out.print("\n" + "enter student name: ");
                    String name = in.next();
                    boolean find = false;
                    while (true) {
                        name = in.next();
                        if (name.equals("back-to-menu"))
                            break;
                        for (int i = 0; i < Hogwarts.Students.size(); i++) {
                            find |= Hogwarts.Students.get(i).getUsername().equals(name);
                        }
                        if (find)
                            break;
                        else {
                            System.out.println("enter correct input");
                        }
                    }
                    if (find) {
                        Student student = new Student("", "");
                        Student student2 = new Student("", "");
                        for (int i = 0; i < Hogwarts.Students.size(); i++) {
                            if (Hogwarts.Students.get(i).getUsername().equals(name)) {
                                student = Hogwarts.Students.get(i);
                            }
                        }
                        Hogwarts.Students.remove(student);
                        for (int i = 0; i < student.courses.size(); i++) {
                            student.courses.get(i).students.remove(name);
                        }
                        for (int i = 0; i < Hogwarts.Courses.size(); i++) {
                            Hogwarts.Courses.get(i).students.remove(name);
                        }
                        for (int i = 0; i < Hogwarts.Teachers.size(); i++) {
                            for (int j = 0; j < Hogwarts.Teachers.get(i).courses.size(); j++) {
                                Hogwarts.Teachers.get(i).courses.get(j).students.remove(name);
                            }
                        }
                    }
                }
            }
            else if (input.equals("2")) {
                assistant.teacherRegister();
            }
            else if (input.equals("4")) {
                System.out.print("enter name for course: ");
                input = in.next();
                System.out.print("enter course details: \n\nWhen the description is finished, type \"FINISH\" to return");
                String det = "";
                while (in.hasNext()) {
                    String input2 = in.next();
                    if (input2.equals("FINISH")) {
                        break;
                    }
                    det += input2 + ' ';
                }
                Teacher teacher = new Teacher("", "");
                Course course = new Course(teacher, input, det);
                Hogwarts.Courses.add(course);
            }
            else if (input.equals("5")) {
                System.out.println("Select profile with ID: ");
                for (int i = 0; i < Hogwarts.Students.size(); i++) {
                    System.out.println((i + 1) + " : " + Hogwarts.Students.get(i).getUsername());
                }
                for (int i = 0; i < Hogwarts.Teachers.size(); i++) {
                    System.out.println((i + Hogwarts.Students.size() + 1) + " : " + Hogwarts.Teachers.get(i).getUsername());
                }
                int num = in.nextInt();
                if (num > Hogwarts.Students.size()) {
                    System.out.println("userName : " + Hogwarts.Teachers.get(num - Hogwarts.Students.size() - 1).getUsername());
                    System.out.println("Courses : ");
                    System.out.print("\t");
                    for (int i = 0; i < Hogwarts.Teachers.get(num - Hogwarts.Students.size() - 1).courses.size(); i++) {
                        Course course = Hogwarts.Teachers.get(num - Hogwarts.Students.size() - 1).courses.get(i);
                        System.out.println(course.getCourseName() + " :");
                        for (int j = 0; j < course.getStudents().size(); j++) {
                            System.out.print(course.getStudents().get(j) + " - ");
                        }
                    }
                    System.out.print("\n");
                    Hogwarts.Teachers.get(num - Hogwarts.Students.size() - 1).getTeacherScore();
                    System.out.print("\n");
                }
                else {
                    System.out.println("userName : " + Hogwarts.Teachers.get(num - 1).getUsername());
                    System.out.println("Courses : ");
                    System.out.print("\t");
                    for (int i = 0; i < Hogwarts.Students.get(num - 1).courses.size(); i++) {
                        Course course = Hogwarts.Students.get(num - 1).courses.get(i);
                        System.out.print(course.getCourseName() + " With " + course.courseTeacher.getUsername() + ", score: ");
                        System.out.println(course.studentScore.get(Hogwarts.Students.get(num - 1).getUsername()));
                    }
                }
            }
            else if (input.equals("6")) {
                for (int i = 0; i < Hogwarts.Courses.size(); i++) {
                    Course course = Hogwarts.Courses.get(i);
                    System.out.println(course.getCourseName() + " : ");
                    System.out.println("\t" + course.getDetails() + "  " + course.courseTeacher.getUsername());
                    System.out.print("\t\t");
                    for (int j = 0; j < course.getStudents().size(); j++) {
                        System.out.print(course.getStudents().get(j) + " - ");
                    }
                    System.out.print("\n");
                }
            }
            else {
                System.out.print("choos one : (changePass, changeUserName :");
                input = in.next();
                while (!input.equals("changePass") && !input.equals("changeUserName")) {
                    System.out.print("enter correct input: ");
                    input = in.next();
                }
                if (input.equals("changePass")) {
                    System.out.print("enter new password: ");
                    input = in.next();
                    assistant.changePassword(input);
                }
                else {
                    while (true) {
                        System.out.print("enter new userName: ");
                        input = in.next();
                        if (!input.equals(assistant.getUsername())) {
                            boolean find = false;
                            for (int i = 0; i < Hogwarts.Assistants.size(); i++)
                                find |= Hogwarts.Assistants.get(i).getUsername().equals(input);
                            if (!find)
                                break;
                        }
                    }
                    assistant.changeUsername(input);
                }
            }
        }
    }
    public static void TeacherMenu(Teacher teacher) {
        System.out.print("\n\n");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("choose one: (1)logOut,2)CourseRequest, 3)MyCourses, 4)Scoring, 5)MyScore, 6)Setting)");
            String input = in.next();
            while (!input.equals("1") && !input.equals("2") && !input.equals("3")
                    && !input.equals("4") && !input.equals("5") && !input.equals("6") ) {
                System.out.print("enter correct input: ");
                input = in.next();
            }
            if (input.equals("1")) {
                break;
            }
            else if (input.equals("2")) {
                Hogwarts.courseRequest(teacher);
            }
            else if (input.equals("3")) {
                teacher.getStudent();
            }
            else if (input.equals("5")) {
                teacher.getTeacherScore();
            }
            else if (input.equals("4")) {
                Hogwarts.Scoring(teacher);
            }
            else {
                System.out.print("choos one : (changePass, changeUserName :");
                input = in.next();
                while (!input.equals("changePass") && !input.equals("changeUserName")) {
                    System.out.print("enter correct input: ");
                    input = in.next();
                }
                if (input.equals("changePass")) {
                    System.out.print("enter new password: ");
                    input = in.next();
                    teacher.changePassword(input);
                }
                else {
                    while (true) {
                        System.out.print("enter new userName: ");
                        input = in.next();
                        if (!input.equals(teacher.getUsername())) {
                            boolean find = false;
                            for (int i = 0; i < Hogwarts.Teachers.size(); i++)
                                find |= Hogwarts.Teachers.get(i).getUsername().equals(input);
                            if (!find)
                                break;
                        }
                    }
                    String lastUserName = teacher.getUsername();
                    teacher.changeUsername(input);
                    for (int i = 0; i < Hogwarts.Teachers.size(); i++) {
                        if (Hogwarts.Teachers.get(i).getAccountID().equals(teacher.getAccountID())) {
                            Hogwarts.Teachers.get(i).changeUsername(input);
                        }
                    }
                    for (int i = 0; i < Hogwarts.Courses.size(); i++) {
                        if (Hogwarts.Courses.get(i).getCourseTeacher().getAccountID().equals(teacher.getAccountID())) {
                            Hogwarts.Courses.get(i).changeTeacher(teacher);
                        }
                    }
                    for (int i = 0; i < Hogwarts.Students.size(); i++) {
                        Student student = Hogwarts.Students.get(i);
                        for (int j = 0; j < student.getTeachers().size(); j++) {
                            if (student.getTeachers().get(j).getAccountID().equals(teacher.getAccountID()))
                                student.getTeachers().get(j).changeUsername(input);
                        }
                        for (int j = 0; j < student.courses.size(); j++) {
                            if (student.courses.get(j).getCourseTeacher().getAccountID().equals(teacher.getAccountID())) {
                                student.courses.get(j).changeTeacher(teacher);
                            }
                        }
                    }
                    for (int i = 0; i < Assistant.teachersIswaiting.size(); i++) {
                        if  (Assistant.teachersIswaiting.get(i).getUsername().equals(lastUserName)) {
                            Assistant.teachersIswaiting.get(i).changeUsername(input);
                        }
                    }

                }
            }
        }
    }
    public static void StudentMenu(Student student) {
        System.out.print("\n\n");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("choose one: (1)logOut, 2)TakeCourse, 3)MyCourses, 4)MyTeachers, 5)ScoreTeachers, 6)Setting");
            String input = in.next();
            while (!input.equals("1") && !input.equals("2") && !input.equals("3")
                    && !input.equals("4") && !input.equals("5") && !input.equals("6") ) {
                System.out.print("enter correct input: ");
                input = in.next();
            }
            if (input.equals("1")) {
                break;
            }
            else if (input.equals("2")) {
                for (int i = 0; i < Hogwarts.Courses.size(); i++) {
                    Course course = Hogwarts.Courses.get(i);
                    System.out.println(i + " : " + course.getCourseName() + " - " + course.getCourseTeacher().getUsername() + " - " + course.getCourseID());
                }
                System.out.print("Enter number of course you want: ");
                int input2 = in.nextInt();
                if (input2 >= Hogwarts.Courses.size()) {
                    System.out.println("Access denied!");
                }
                else {
                    Course course = Hogwarts.Courses.get(input2);
                    boolean find = false;
                    for (int i = 0; i < student.courses.size(); i++) {
                        if (student.courses.get(i).getCourseID().equals(course.getCourseID())) {
                            find = true;
                        }
                    }
                    if (find) {
                        System.out.println("course has already exist.");
                    }
                    else {
                        student.addCourse(course);
                    }
                }
            }
            else if (input.equals("3")) {
                for (int i = 0; i < student.getCourses().size(); i++) {
                    System.out.print(student.getCourses().get(i).getCourseName() + " ");
                }
                System.out.print("\n");
            }
            else if (input.equals("4")) {
                for (int i = 0; i < student.getTeachers().size(); i++) {
                    System.out.print(student.getTeachers().get(i).getUsername() + " ");
                }
                System.out.print("\n");
            }
            else if (input.equals("5")) {
                System.out.println("select course for score teacher: ");
                for (int i = 0; i < student.courses.size(); i++) {
                    Course course = student.courses.get(i);
                    System.out.println(course.getCourseName() + " - " + course.getCourseTeacher().getUsername() + " - " + course.getCourseID());
                }
                System.out.print("Enter number of course you want: ");
                int input2 = in.nextInt();
                Course course = student.courses.get(input2);
                if (student.TeacherScore.get(course.getCourseID()) != null) {
                    System.out.print("enter Score: ");
                    Double score = in.nextDouble();
                    student.scoreTeacher(course.getCourseID(), score);
                }
                else {
                    System.out.println("you have already scored this teacher");
                }
            }
            else {
                System.out.print("choos one : (1)changePass, 2)changeUserName :");
                input = in.next();
                while (!input.equals("1") && !input.equals("2")) {
                    System.out.print("enter correct input: ");
                    input = in.next();
                }
                if (input.equals("1")) {
                    System.out.print("enter new password: ");
                    input = in.next();
                    student.changePassword(input);
                }
                else {
                    String lastUserName = student.getUsername();
                    while (true) {
                        System.out.print("enter new userName: ");
                        input = in.next();
                        if (!input.equals(student.getUsername())) {
                            boolean find = false;
                            for (int i = 0; i < Hogwarts.Students.size(); i++)
                                find |= Hogwarts.Students.get(i).getUsername().equals(input);
                            if (!find)
                                break;
                        }
                    }
                    input = in.next();
                    student.changeUsername(input);
                    for (int i = 0; i < Hogwarts.Courses.size(); i++) {
                        Course course = Hogwarts.Courses.get(i);
                        for (int j = 0; j < course.getStudents().size(); j++) {
                            if (course.getStudents().get(j).equals(lastUserName))
                                course.getStudents().get(j).equals(input);
                        }
                        course.studentScore.put(lastUserName, course.studentScore.get(lastUserName));
                        course.studentScore.remove(lastUserName);
                    }
                }
            }
        }
    }
    public static void runMenu() {
        Scanner in = new Scanner(System.in);
        while (true) {
          //  System.out.println("enter back-to-menu for going to menu");
            System.out.println("select your profile: (1)student, 2)teacher, 3)assistant)");
            String input = in.next();
            while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
                System.out.print("enter correct input : ");
                input = in.next();
            }
            //Student
            if (input.equals("1")) {
                System.out.println("1)signup or 2)login or 3)back-to-menu?");
                input = in.next();
                while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
                    System.out.print("enter correct input : ");
                    input = in.next();
                }
                if (input.equals("1")) {
                    while (true) {
                        System.out.print("enter userName: ");
                        input = in.next();
                        boolean find = false;
                        for (int i = 0; i < Hogwarts.Students.size(); i++) {
                            find |= Hogwarts.Students.get(i).getUsername().equals(input);
                        }
                        if (find) {
                            System.out.println("username already exist!");
                        }
                        else {
                            System.out.print("enter passWord: ");
                            String pass = in.next();
                            Student student = new Student(input, pass);
                            Hogwarts.Students.add(student);
                            break;
                        }
                    }
                }
                else if (input.equals("2")) {
                    while (true) {
                        System.out.print("enter userName: ");
                        input = in.next();
                        if (input.equals("back-to-menu"))
                            break;
                        boolean find = false;
                        Student student = new Student("", "");
                        for (int i = 0; i < Hogwarts.Students.size(); i++) {
                            if (Hogwarts.Students.get(i).getUsername().equals(input)) {
                                student = Hogwarts.Students.get(i);
                            }
                            find |= Hogwarts.Students.get(i).getUsername().equals(input);
                        }
                        if (!find) {
                            System.out.println("username not found!");
                        }
                        else {
                            while (true) {
                                System.out.print("enter passWord: ");
                                String pass = in.next();
                                if (pass.equals("back"))
                                    break;
                                if (student.validatePassword(pass)) {
                                    StudentMenu(student);
                                    break;
                                }
                                else {
                                    System.out.println("incorrect password!");
                                }
                            }
                            break;
                        }
                    }
                }
            }
            //teacher
            else if (input.equals("2")) {
                System.out.println("1)signup or 2)login or 3)back-to-menu?");
                input = in.next();
                while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
                    System.out.print("enter correct input : ");
                    input = in.next();
                }
                if (input.equals("1")) {
                    while (true) {
                        System.out.print("enter userName: ");
                        input = in.next();
                        boolean find = false;
                        for (int i = 0; i < Hogwarts.Teachers.size(); i++) {
                            find |= Hogwarts.Teachers.get(i).getUsername().equals(input);
                        }
                        if (find) {
                            System.out.println("username already exist!");
                        }
                        else {
                            System.out.print("enter passWord: ");
                            String pass = in.next();
                            Teacher newTeacher = new Teacher(input, input);
                            newTeacher.setPass(pass);
                            Hogwarts.Teachers.add(newTeacher);
                            Assistant.teachersIswaiting.add(newTeacher);
                            System.out.println("please wait to verify your access.");
                            break;
                        }
                    }
                }
                else if (input.equals("2")) {
                    while (true) {
                        System.out.print("enter userName: ");
                        input = in.next();
                        if (input.equals("back"))
                            break;
                        boolean find = false;
                        Teacher teacher = new Teacher(input, input);
                        for (int i = 0; i < Hogwarts.Teachers.size(); i++) {
                            if (Hogwarts.Teachers.get(i).getUsername().equals(input)) {
                                teacher = Hogwarts.Teachers.get(i);
                            }
                            find |= Hogwarts.Teachers.get(i).getUsername().equals(input);
                        }
                        if (!find) {
                            System.out.println("username not found!");

                            if(input.equals("3")){
                                break;
                            }
                        }
                        else {
                            while (true) {
                                System.out.print("enter passWord: ");
                                String pass = in.next();
                                if (pass.equals("back"))
                                    break;
                                if (teacher.validatePassword(pass)) {
                                    TeacherMenu(teacher);
                                    break;
                                }
                                else {
                                    System.out.println("incorrect password!");
                                }
                            }
                            break;
                        }
                    }
                }
            }
            else {
                while (true) {
                    System.out.print("enter userName: ");
                    input = in.next();
                    if (input.equals("back-to-menu"))
                        break;
                    boolean find = false;
                    Assistant assistant = new Assistant("", "");
                    for (int i = 0; i < Hogwarts.Assistants.size(); i++) {
                        if (Hogwarts.Assistants.get(i).getUsername().equals(input)) {
                            assistant = Hogwarts.Assistants.get(i);
                        }
                        find |= Hogwarts.Assistants.get(i).getUsername().equals(input);
                    }
                    if (!find) {
                        System.out.println("username not found!");
                    }
                    else {
                        while (true) {
                            System.out.print("enter passWord: ");
                            String pass = in.next();
                            if (pass.equals("back-to-menu"))
                                break;
                            if (assistant.validatePassword(pass)) {
                                AssistantMenu(assistant);
                                break;
                            }
                            else {
                                System.out.println("incorrect password!");
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
