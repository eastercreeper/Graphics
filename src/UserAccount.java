import javax.swing.*;
import java.util.Scanner;

public class UserAccount {
    private String username;
    private String password;

    public UserAccount(String username, String password) {
        this.username = username;
       this.password = password;
    }
    public  String getUsername() {
        return username;
    }

    public  String getPassword() {
        return password;
    }

    public  void setUsername(String username) {
        this.username = username;
    }

    public  void setPassword(String password) {
        this.password = password;
    }





    public  boolean isPasswordComplex() {
        boolean eightlong = false;

        boolean upcase = false;
        boolean lowercase = false;
        boolean hasPassword = false;
        boolean hasSpecialChar = false;
        if(password.length() >= 8){
            eightlong = true;
            for (int i = 0; i < password.length(); i++) {
                for (int j = 65; j < 90; j++) {
                    if (password.charAt(i) == j) {
                        upcase = true;
                        break;
                    }
                }
                for (int j = 97; j < 122; j++) {
                    if (password.charAt(i) == j) {
                        lowercase = true;
                        break;
                    }
                }
                for (int j = 33; j < 64; j++) {
                    if (password.charAt(i) == j) {
                        hasSpecialChar = true;
                        break;
                    }
                }
            }
        }
        if(password.contains("password") || password.contains("PASSWORD")) {
            hasPassword = true;
        }
        if(!upcase || !eightlong || !lowercase || hasPassword || !hasSpecialChar) {
            return false;
        }
        return true;
    }
}