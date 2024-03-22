import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;



public class Assistant {

    //*this method has objects for every user,including username and password*/

    String assistant;
    String passWord;
    static UUID username1;
    static UUID username2;
    static UUID Username;
    static String UserName;
    static int hash1;
    static int hash2;



    static ArrayList <String> waitingList = new ArrayList<>();

    public Assistant(String assistant,String passWord){
        this.assistant = assistant;
        this.passWord = passWord;
    }

    public Assistant() {

    }

    // Getter and setter for assistant
    public String getAssistant() {
        return assistant;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }


    //*the method gets the username of the user,creates objects for each user,creates a UUID for each username and converts passwords into hashes*/

    public void username(String str) throws NoSuchMethodException {

        Assistant assistant1 = new Assistant("Hagrid_TheBest","19281206hagrid");
        Assistant assistant2 = new Assistant("@AlbusTheHeadMaster","18810810albus");
        username1 = UUID.nameUUIDFromBytes(assistant1.assistant.getBytes());
        username2 = UUID.nameUUIDFromBytes(assistant2.assistant.getBytes());
        hash1 = assistant1.passWord.hashCode();
        hash2 = assistant2.passWord.hashCode();


        System.out.println("Enter the username:");
        Scanner scanner = new Scanner(System.in);
        UserName = scanner.next();
        Username = UUID.nameUUIDFromBytes(UserName.getBytes());
        TheAccount userName = new TheAccount();
        TheAccount.Settings theusername = userName.new Settings();
        theusername.validateUsername(username1,username2,Username,hash1,hash2);
    }



    //*the function that gets the password and verifies it*/
    public void password(String str) throws NoSuchMethodException {
        System.out.println("Enter the password:");
        Scanner scanner = new Scanner(System.in);
        String passCode = scanner.next();

        TheAccount passcode = new TheAccount();
        TheAccount.Settings passcode2 = passcode.new Settings();
        passcode2.validatePassword(username1,username2,Username,passCode,str,hash1,hash2);

    }


    //* in this method we show courses that are already created */
    public static void assistant(){
        System.out.println("Here is the menu.Please choose:");
        ArrayList<String> menu = new ArrayList<>();
        menu.add("courses");
        menu.add("students");
        menu.add("requests");
        menu.add("create a course");
        menu.add("changeUsername");
        menu.add("changePassword");



        for(String option : menu){
            System.out.println(option);
        }

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        if(str.equals("course")){
            subjects(str);
        }

        if(str.equals("requests")){
            Assistant obj = new Assistant();
            obj.requests();
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

    //* creating a subject */
    public static void subjects(String str){
        ArrayList<String> subjectList = new ArrayList<>();
        subjectList.add("Defense against the dark arts");
        subjectList.add("Potions");
        subjectList.add("addcourse");


        for(String option : subjectList){
            System.out.println(option);
        }

        System.out.println("please select the subject:");
        Scanner scanner = new Scanner(System.in);
        String str2 = scanner.next();

        if(str2.equals("Defense")){
            defense();
        }
    }

    public static void defense(){
        //*view the students who took this course*/
        //*view the teacher*/
    }

    public void requests(){


        for(String option : waitingList){
            System.out.println(option);
        }

        System.out.println("accept?");
        Scanner scannerr = new Scanner(System.in);
        String str2 = scannerr.next();

        if(str2.equals("accept")){
            Signin signin = new Signin();
            Signin.createAccount();
        }
    }

}
