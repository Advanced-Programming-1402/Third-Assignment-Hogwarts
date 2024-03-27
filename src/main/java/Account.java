import java.util.*;
public class Account implements AccountManagement{

    private String username;
    // TODO: Passwords should be hashed
    private String password;
    private UUID accountID;
    static ArrayList<String> usernames;
    static ArrayList<String> passwords;

    public Account(String password, String username) {
        this.username = username;
        this.password = hash(password);
        this.accountID = UUID.randomUUID();
    }
    public void signUp(String passWord) {
        this.password = hash(passWord);
    }

    public static String hash(String password) {
        String tempPassword = "This is my password : " + password ; //salt
        long tempMod = 50000047;
        long base = 761;
        long result = 0;
        long power = 1;
        for(int i = 0 ; i < password.length() ; i++) {
            int temp = password.charAt(i) - '0';//ascii code
            result = (result + (power * temp)) % tempMod;
            power = (power * base) % tempMod;
        }
        return String.valueOf(result);
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public boolean validatePassword(String thePassword) {
        if(hash(thePassword) == this.password)
            return true;
        return false;
    }

    @Override
    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password = hash(newPassword);
    }


    public UUID getAccountID() {
        return accountID;
    }
}
