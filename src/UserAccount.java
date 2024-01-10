import javax.swing.*;
import java.util.Scanner;

public class UserAccount {
    private static String username;
    private static String password;
    static boolean badPassword = true;

    public UserAccount(String username, String password) {
        UserAccount.username = username;
        UserAccount.password = password;
    }
    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setUsername(String username) {
        UserAccount.username = username;
    }

    public static void setPassword(String password) {
        UserAccount.password = password;
    }

    public static void setBadPassword(boolean badPassword) {
        UserAccount.badPassword = badPassword;
    }

    public static boolean isBadPassword() {
        return badPassword;
    }
    public static void main(String[] args) {
        //create Scanner object called scanEa
        //this scanner reads from the console (System.in) - type inputs there

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter username");

        username = scan.nextLine();


        System.out.println("Please enter your password");

        while(badPassword) {



            Scanner scan2 = new Scanner(System.in);
            password = scan2.nextLine();
            if(!isPasswordComplex()) {
                System.out.println("bad password");
                System.out.println("Please renter your password");
            } else {
                System.out.println("good password");
                badPassword = false;
            }

        }
    }
    public static boolean isPasswordComplex() {
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
