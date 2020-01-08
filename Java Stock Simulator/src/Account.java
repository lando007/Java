public class Account {

     String sPassword = "123";

     String sUsername = "123";

    public boolean isValidLogin(String password) {

        return this.sPassword.equals(password);
    }

    public String getUsername() {

        return sUsername;
    }

}
