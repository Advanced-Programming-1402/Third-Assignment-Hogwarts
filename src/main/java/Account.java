import java.util.Scanner;
import java.util.UUID;

public class  Account implements AccountManagement{
    private String username;
    // TODO: Passwords should hashed

    private String password;
    private UUID accountID;

    public static String hash(String password) {
        long mod = 1000000007 , mabna = 457;
        long ans = 0 , ans2 = 0 , pow = 1 , pow2 = 1;
        for (int i = 0 ; i < password.length() ; i++) {
            int save = password.charAt(i) - '0';
            ans = (ans + (pow *save)) % mod;
            pow = (pow *mabna) % mod;

        }
        return String.valueOf(ans);
    }



    public  Account(String username, String password){
        this.username="";
        this.password=hash(password);
        this.accountID=UUID.randomUUID();
    }

    private String pass;
    public void SignUp(String pass) {
        this.password = hash(pass);

    }
    @Override
    public boolean validatePassword(String enteredPassword) {
        //TODO
        return hash(enteredPassword).equals(this.password);

    }

    @Override
    public void changeUsername(String newUsername) {
        //TODO
        this.username = newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        //TODO
        this.password = hash(newPassword);
    }

    public String getUsername(){
        Scanner username = new Scanner(System.in);
        this.username=username.nextLine();
        return null;
    }

    public UUID getAccountID(){
        return accountID;
    }
}
