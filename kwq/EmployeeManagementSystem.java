package ncwu.kwq;
import ncwu.kwq.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID number:");
        int id = scanner.nextInt();
        if (!isValidId(id)) {
            System.out.println("ID has already been used.");
            return;
        }
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        System.out.println("Enter address:");
        String address = scanner.next();
        Employee employee = new Employee(id, name, age, address);
        System.out.println(employee.toString());
        employeeList.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void view() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    public void removeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID number:");
        int id = scanner.nextInt();
        Employee employee = findEmployee(id);
        if (employee == null) {
            System.out.println("Invalid ID");
            return;
        }
        employeeList.remove(employee);
        System.out.println("Employee removed successfully.");
    }

    public void editEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID number:");
        int id = scanner.nextInt();
        Employee employee = findEmployee(id);
        if (employee == null) {
            System.out.println("Invalid ID");
            return;
        }
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        System.out.println("Enter address:");
        String address = scanner.next();
        employee.setName(name);
        employee.setAge(age);
        employee.setAddress(address);
        System.out.println("Employee edited successfully.");
        System.out.println(employee.toString());
    }

    public void findEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID number:");
        int id = scanner.nextInt();
        Employee employee = findEmployee(id);
        if (employee != null) {
            System.out.println(employee.toString());
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void clearEmployee() {
        employeeList.clear();
        view();
        System.out.println("All employee information has been cleared.");
    }

    private Employee findEmployee(int id) {
        for (Employee employee : employeeList) {
            if (id == employee.getID()) {
                return employee;
            }
        }
        return null;
    }

    private boolean isValidId(int id) {
        for (Employee emp : employeeList) {
            if (emp.getID() == id) {
                return false; // ID already exists, return false
            }
        }
        return true; // ID does not exist, return true
    }
}
