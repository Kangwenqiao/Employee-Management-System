package ncwu.kwq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterUser {
    private  static List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void regiserUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registration:");
        System.out.println("Enter a username: ");
        String usernames = scanner.next();
        if (isUsernameValid(usernames)) {
            System.out.print("Enter a password: ");
            String password1 = scanner.next();

            System.out.print("Re-enter the password: ");
            String password2 = scanner.next();

            if (password1.equals(password2)) {
                System.out.print("Enter your ID card number: ");
                String idCard = scanner.next();

                if (isIdCardValid(idCard)) {
                    System.out.print("Enter your phone number: ");
                    String phoneNumber = scanner.next();

                    if (isPhoneNumberValid(phoneNumber)) {
                        User user = new User(usernames, password1, idCard, phoneNumber);
                        userList.add(user);
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Invalid phone number.");
                    }
                } else {
                    System.out.println("Invalid ID card number.");
                }
            } else {
                System.out.println("Passwords do not match.");
            }
        } else {
            System.out.println("Invalid username.");
        }
    }

    private boolean isUsernameValid(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }

        if (username.length() >= 3 && username.length() <=+15) {
            for(char c:username.toCharArray())
                if(!((c>='a' && c<='z')||(c >= 'A' && c <= 'Z')||(c >= '0' && c <= '9')))
                    return false;
        }else {
            return false;
        }
        return true;
    }

    private boolean isIdCardValid(String ID){
        if(ID.length()!=18){
            return false;
        }
        if(ID.charAt(0)=='0'){
            return false;
        }
        for(int i=0;i<17;i++){
            char c=ID.charAt(i);
            if(c<'0'||c>'9'){
                return false;
            }
        }
        char lastChar=ID.charAt(ID.length()-1);
        if((lastChar<'0'||lastChar>'9') && lastChar!='X' &&lastChar!='x'){
            return false;
        }
        return true;
    }

    private boolean isPhoneNumberValid(String phoneNumber){
        if(phoneNumber.length()!=11)return false;
        if(phoneNumber.charAt(0)=='0')return false;
        for(int i=0;i<phoneNumber.length();i++){
            char c=phoneNumber.charAt(i);
            if(c<'0' && c>'9')return false;
        }
        return true;
    }
}
