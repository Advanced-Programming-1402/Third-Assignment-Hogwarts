import java.util.UUID;

public class Account {
    private String username;
    // TODO: Passwords should hashed
    private String password;
    private UUID accountID;

//    @Override
    public boolean validatePassword(String enteredPassword) {
        //TODO
        return false;
    }

//    @Override
    public void changeUsername(String newUsername) {
        username=newUsername;
    }

//    @Override
    public void changePassword(String newPassword) {
        password=newPassword;
    }

}

