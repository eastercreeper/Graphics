package other;

import java.util.Scanner;

public class PasswordTester {

    public static void main(String[] args) {
        //create Scanner object called scanEa
        //this scanner reads from the console (System.in) - type inputs there
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter username");

        String username = scan.nextLine();


        System.out.println("Please enter your password");
        Scanner scan2 = new Scanner(System.in);
        String password = scan2.nextLine();
        UserAccount user = new UserAccount(username,password);


        while(!user.isPasswordComplex()) {




                System.out.println("bad password");
                System.out.println("Please renter your password");
            password = scan2.nextLine();
            user.setPassword(password);


        }
        System.out.println("Good password");
    }
}
