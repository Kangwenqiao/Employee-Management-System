package ncwu.kwq;
import ncwu.kwq.EmployeeManagementSystem;
import ncwu.kwq.ForgotPassword;
import ncwu.kwq.LoginSystem;
import ncwu.kwq.RegisterUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Employee Management System\n");

        while (true) {
            // User login, registration, and password reset menu
//            while (true) {
//                centerAlignPrint("1. Log in");
//                centerAlignPrint("2. Register");
//                centerAlignPrint("3. Forgot Password");
//                centerAlignPrint("0. Exit\n");
//                System.out.print("Please enter your choice: ");
//                int choosen = scanner.nextInt();
//                boolean flag = false; // Used to mark whether the user has successfully logged in
//
//                switch (choosen) {
//                    case 1:
//                        LoginSystem loginSystem = new LoginSystem();
//                        flag = loginSystem.login();
//                        break;
//                    case 2:
//                        RegisterUser registerUser = new RegisterUser();
//                        registerUser.regiserUser();
//                        break;
//                    case 3:
//                        ForgotPassword forgotPassword = new ForgotPassword();
//                        forgotPassword.ForgotPassword();
//                        break;
//                    case 0:
//                        System.exit(0);
//                    default:
//                        System.out.println("Please enter a valid number\n");
//                        break;
//                }
//                if (choosen == 1 && flag) break;
//            }

            // Employee management system menu
            while (true) {
                EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();
                centerAlignPrint("1. Add Employee");
                centerAlignPrint("2. Remove Employee");
                centerAlignPrint("3. Find Employee");
                centerAlignPrint("4. Edit Employee");
                centerAlignPrint("5. Clear Employees");
                centerAlignPrint("6. Exit\n");
                System.out.print("Please enter your choice: ");
                int choosen2 = scanner.nextInt();

                switch (choosen2) {
                    case 1:
                        employeeManagementSystem.addEmployee();
                        break;
                    case 2:
                        employeeManagementSystem.removeEmployee();
                        break;
                    case 3:
                        employeeManagementSystem.findEmployee();
                        break;
                    case 4:
                        employeeManagementSystem.editEmployee();
                        break;
                    case 5:
                        employeeManagementSystem.clearEmployee();
                        break;
                    case 6:
                        break;
                }
                if (choosen2 == 6) break;
            }
        }
    }

    // Center-align text for printing
    private static void centerAlignPrint(String text) {
        int consoleWidth = 80; // Adjust this value based on your console width
        int textWidth = text.length();
        int padding = (consoleWidth - textWidth) / 2;

        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }

        System.out.println(text);
    }
}
