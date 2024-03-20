import java.util.*;
public class Main {
    public static void main(String[] args) {
        Assistant assistant = new Assistant("" ,"");
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
                                System.out.println(Hogwarts.teachers.get(userhoice1-1).getTeacherScore());


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
                                System.out.print(course.getCourseName() + "Teacher : " + course.courseTeacher.getUsername() + "Score : " + course.studentScore.get(Hogwarts.students.get(userchoice2).getUsername());
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
                            boolean isExist = false
                            for(int i = 0 ; i < Hogwarts.teachers.size() ; i++) {
                                if(Hogwarts.teachers.get(i).getUsername() == removingTeacherName) {
                                    isExist = true;
                                }
                            }
                            if(!isExist) {
                                System.out.println("Something went wrong, This user in not exist...");
                            }
                            else {
                                Teacher teacher = new Teacher(" " , removingTeacherName)
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
                        for(int j = 0 ; j < course.getStudents().size() ; j++) {
                            System.out.print(course.getStudents().get(j));
                        }
                        System.out.println();
                    break;
                case 6:
                    System.out.println("1.Change PassWord \n2.Change UserName");

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
                    break;
                case 8:
                    break;

            }
        }
    }

    public static void runMenu() {
        // TODO: Menu will be shown here...
    }
}
