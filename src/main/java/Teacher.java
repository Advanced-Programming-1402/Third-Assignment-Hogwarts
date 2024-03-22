import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Teacher {
    String teacher;
    String passWord;
    static UUID username1;
    static UUID username2;
    static UUID Username;
    static String UserName;
    static int hash1;
    static int hash2;

    public Teacher(String teacher,String passWord){
        this.teacher = teacher;
        this.passWord = passWord;
    }

    static ArrayList<String> Teacherslist = new ArrayList<>();
    public Teacher() {

    }

    public String getTeacher() {
        return teacher;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void username(String str) throws NoSuchMethodException {


        Teacher teacher1 = new Teacher("M!nerv@_mcG0N","19351004minerva");
        Teacher teacher2 = new Teacher("seri0usSeverus777","19600109severus");

        Teacherslist.add(teacher1.teacher);
        Teacherslist.add(teacher2.teacher);

        ArrayList<UUID> UUIDlist = new ArrayList<UUID>();
        username1 = UUID.nameUUIDFromBytes(teacher1.teacher.getBytes());
        username2 = UUID.nameUUIDFromBytes(teacher2.teacher.getBytes());

        UUIDlist.add(username1);
        UUIDlist.add(username1);


        hash1 = teacher1.passWord.hashCode();
        hash2 = teacher2.passWord.hashCode();


        System.out.println("Enter the username:");
        Scanner scanner = new Scanner(System.in);
        UserName = scanner.next();
        Username = UUID.nameUUIDFromBytes(UserName.getBytes());
        TheAccount userName = new TheAccount();
        TheAccount.Settings theusername = userName.new Settings();
        theusername.validateUsername(username1,username2,Username,hash1,hash2);
    }

    public void password(String str) throws NoSuchMethodException {


        System.out.println("Enter the password:");
        Scanner scanner = new Scanner(System.in);
        String passCode = scanner.next();

        TheAccount passcode = new TheAccount();
        TheAccount.Settings passcode2 = passcode.new Settings();
        passcode2.validatePassword(username1,username2,Username,str,passCode,hash1,hash2);

    }

    public static void teacher(){
        System.out.println("Here is the menu.Please choose:");
        ArrayList<String> menu = new ArrayList<>();
        menu.add("courses");
        menu.add("score");
        menu.add("enrollment");
        menu.add("teachers' rating");
        menu.add("changeUsername");
        menu.add("changePassword");
        //*demonstration  of subjects*/
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

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
}
