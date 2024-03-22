import java.util.List;
import java.util.Scanner;

public class Signin {
    public static void createAccount(){

        System.out.println("enter a username and password:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Teacher.Teacherslist.add(str);

    }
}
