package ncwu.kwq;

import java.util.Random;

public class VerificationCodeGenerator {
    public static void main(String[] args) {
        String verificationCode = generateVerificationCode();
        System.out.println("Random Verification Code: " + verificationCode);
    }

    public static String generateVerificationCode() {
        // Define the character sets for letters (upper and lower case) and digits
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";

        StringBuilder codeBuilder = new StringBuilder();

        // Generate 4 random letters
        for (int i = 0; i < 4; i++) {
            char randomLetter = letters.charAt(new Random().nextInt(letters.length()));
            codeBuilder.append(randomLetter);
        }

        // Insert the digit at a random position (0 to 4)
        int position = new Random().nextInt(5);
        char randomDigit = digits.charAt(new Random().nextInt(digits.length()));
        codeBuilder.insert(position, randomDigit);

        return codeBuilder.toString();
    }
}

