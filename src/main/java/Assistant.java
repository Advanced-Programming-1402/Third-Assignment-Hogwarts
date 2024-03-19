import java.util.*;
public class Assistant extends Account{

    public boolean signIn(String password , String teacherUsername){
        Teacher obj = new Teacher();
        if(obj.passwords.indexOf(password) == obj.usernames.indexOf(password)){
            System.out.println("Welcome to your profile !!");
            return true;
        }
        else{
            System.out.println("the password or username is wrong, Try again !!");
            return false;
        }
    }
}
