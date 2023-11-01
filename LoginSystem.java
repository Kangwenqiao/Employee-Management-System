package ncwu.kwq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class LoginSystem {
    private static int maxLoginAttempts = 3;
    private static RegisterUser userRegistration = new RegisterUser();
    public static List<User> userList = userRegistration.getUserList();
    private VerificationCodeGenerator verificationCodeGenerator=new VerificationCodeGenerator();
    private static String validVerificationCode = VerificationCodeGenerator.generateVerificationCode();

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        int loginAttempts = 0;
        System.out.println("Welcome to the Login System");

        while (loginAttempts < maxLoginAttempts) {
            System.out.println("Enter a username: ");
            String username = scanner.next();

            if (!isUsernameValid(username)) {
                System.out.println("Username is not registered. Please register first.");
                return false;
            }

            User user = findUser(username);

            System.out.print("Enter your password: ");
            String enteredPassword = scanner.next();

            if (!enteredPassword.equals(user.getPassword())) {
                System.out.println("Incorrect password.");
            }
            System.out.println();
            System.out.println("verification code:"+validVerificationCode);
            System.out.println();
            System.out.print("Enter the verification code: ");
            String enteredVerificationCode = scanner.next();

            if (!enteredVerificationCode.equals(validVerificationCode)) {
                System.out.println("Incorrect verification code. Please try again.");
            } else {
                System.out.println("Login successful! Welcome, " + username);
                return true;
            }

            loginAttempts++;
        }

        System.out.println("Login failed. You have exceeded the maximum number of login attempts.");
        return false;
    }

    public User findUser(String username) {
        for (User user : userList) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }

    public boolean isUsernameValid(String username) {
        for (User user : userList) {
            if (username.equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }
}
