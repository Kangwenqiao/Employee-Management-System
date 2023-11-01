package ncwu.kwq;

import java.util.List;
import java.util.Scanner;

public class ForgotPassword {
    private static RegisterUser userRegistration = new RegisterUser();
    public static List<User> userList = userRegistration.getUserList();
    LoginSystem login=new LoginSystem();
    public void ForgotPassword(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Forgot Password");
        System.out.print("Enter your username: ");
        String username = scanner.next();
        if(!login.isUsernameValid(username)){
            System.out.println("Username is not registered. Please register first.");
            return;
        }
        User user=login.findUser(username);
        System.out.print("Enter your ID card number: ");
        String enteredIdCard = scanner.next();

        System.out.print("Enter your phone number: ");
        String enteredPhoneNumber = scanner.next();

        if (user.getIdCard().equals(enteredIdCard) && user.getPhoneNumber().equals(enteredPhoneNumber)) {
            System.out.print("Enter your new password: ");
            String newPassword = scanner.next();
            user.setPassword(newPassword);
            System.out.println("Password updated successfully!");
        } else {
            System.out.println("Account information does not match. Password update failed.");
        }
    }
}
