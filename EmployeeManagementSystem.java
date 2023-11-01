package ncwu.kwq;
import ncwu.kwq.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private List<Employee> employeeList = new ArrayList<>();

    // Get the list of employees
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    // Add an employee
    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID number:");
        int id = scanner.nextInt();

        if (!isValidId(id)) {
            System.out.println("ID has already been used.");
            return;
        }

        String name = getValidInput("Enter name:");
        int age = getValidAge("Enter age:");
        String address = getValidInput("Enter address:");

        Employee employee = new Employee(id, name, age, address);
        employeeList.add(employee);
        System.out.println("Employee added successfully.");
    }

    // Find an employee
    public void findEmployee() {
        int id = getValidIdInput("Enter ID number:");
        Employee employee = findEmployee(id);

        if (employee != null) {
            System.out.println(employee.toString());
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Remove an employee
    public void removeEmployee() {
        int id = getValidIdInput("Enter ID number:");
        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Invalid ID");
            return;
        }

        employeeList.remove(employee);
        System.out.println("Employee removed successfully.");
    }

    // Edit employee information
    public void editEmployee() {
        int id = getValidIdInput("Enter ID number:");
        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Invalid ID");
            return;
        }

        String name = getValidInput("Enter name:");
        int age = getValidAge("Enter age:");
        String address = getValidInput("Enter address:");

        employee.setName(name);
        employee.setAge(age);
        employee.setAddress(address);

        System.out.println("Employee edited successfully.");
        System.out.println(employee.toString());
    }

    // Clear the employee list
    public void clearEmployee() {
        employeeList.clear();
        System.out.println("All employee information has been cleared.");
    }

    // Find an employee by ID
    private Employee findEmployee(int id) {
        for (Employee employee : employeeList) {
            if (id == employee.getID()) {
                return employee;
            }
        }
        return null;
    }

    // Check if an ID is valid
    private boolean isValidId(int id) {
        for (Employee emp : employeeList) {
            if (emp.getID() == id) {
                return false; // ID already exists, return false
            }
        }
        return true; // ID does not exist, return true
    }

    // Get valid user input as a string
    private String getValidInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }

    // Get valid age input
    private int getValidAge(String message) {
        int age;
        while (true) {
            try {
                age = Integer.parseInt(getValidInput(message));
                if (age >= 0 && age <= 150) {
                    return age;
                }
                System.out.println("Invalid age. Please enter a valid age.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Get valid ID input
    private int getValidIdInput(String message) {
        int id;
        while (true) {
            try {
                id = Integer.parseInt(getValidInput(message));
                return id;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
