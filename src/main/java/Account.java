import java.util.UUID;

public class Account implements AccountManagement {
    private String username;
    private String password;
    private UUID accountID;

    public static String hashingPassword(String pass){
        long hashmod = 527733233;
        long hashmabna = 701;
        long ans = 0 ;
        long power = 1;
        for(int i = 0 ; i < pass.length() ; i++){
            int save = pass.charAt(i) - '0';
            ans = (ans + ( power * save ) ) % hashmod;
            power = (power * hashmabna ) % hashmod ;
        }
        return String.valueOf(ans);
    }
    public Account(String username , String password ){
        this.username = username ;
        this.password =hashingPassword (password) ;
        this.accountID = UUID.randomUUID();
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        return hashingPassword(enteredPassword).equals(this.password);
    }

    @Override
    public void changeUsername(String newUsername) {

        this.username = newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password = hashingPassword(newPassword) ;
    }
    public String getUsername () {
        return username;
    }
    public UUID getAccountID(){
        return accountID;
    }
    public void SignUp(String pass){
        this.password = hashingPassword(pass);
    }
}
