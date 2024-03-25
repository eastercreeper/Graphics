package other;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountHandler {
    ArrayList<UserAccount> UserAccounts;
    public AccountHandler() {
        UserAccounts = new ArrayList<UserAccount>();
    }

    public void addAccounts() {
        boolean continues = true;
        while(continues) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a username");
            String username = scanner.nextLine();
            System.out.println("Please enter a password");
            String password = scanner.nextLine();
            UserAccounts.add(new UserAccount(username, password));
            System.out.println("do you want to continue? No || Yes");
            String conties = scanner.nextLine();
           conties =  conties.toLowerCase();
            if(conties.equals("no")) {
                continues = false;
            }

        }
    }
    public void displayAccounts() {
        for (UserAccount userAccount : UserAccounts) {
            System.out.println(" ");
            System.out.print(userAccount.getUsername() + ":" + userAccount.getPassword());
        }
    }
    public void updatePassword(String username, String password) {
        for (UserAccount userAccount : UserAccounts) {
            if (userAccount.getUsername().equals(username)) {
                userAccount.setPassword(password);
                System.out.println("updated " + username + "password");
            }
        }
    }
    public ArrayList<String> auditPassword() {
        ArrayList<String> list = new ArrayList<String>();
        for (UserAccount userAccount : UserAccounts) {
            if (!userAccount.isPasswordComplex()) {
                list.add(userAccount.getUsername());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        AccountHandler handler = new AccountHandler();
        handler.addAccounts();
        handler.updatePassword("ronen", "Ro01nfsaWinsalon");
        handler.displayAccounts();

        System.out.println(" ");

        System.out.println("these people have bad passwords");

      System.out.println(handler.auditPassword());

    }
}
