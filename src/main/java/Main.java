import java.util.*;
public class Main {
    public static void main(String[] args) {
        Assistant assistant = new Assistant("" ,"");
        assistantMenu(assistant);
        Hogwarts.addAssistant(assistant);
        runMenu();
    }

    public static void assistantMenu(Assistant assistant) {
        System.out.println();
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Hi... Welcome To Our Platform :)  ");
            System.out.println("Please Enter the number of your desire option :  ");
            System.out.println("1.Check Profile");
            System.out.println("2.Teacher Request");
            System.out.println("3.Remove Student Or Teacher");
            System.out.println("4.Create A New Course");
            System.out.println("5.View The Courses");
            System.out.println("6.Log Out");
            int choice = input.nextInt();
            switch(choice){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;

            }
        }
    }

    public static void runMenu() {
        // TODO: Menu will be shown here...
    }
}
