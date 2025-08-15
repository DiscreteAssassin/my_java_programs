import java.util.ArrayList;
import java.util.Scanner;

// Employee class to hold employee details
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and setters for employee details
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
    }
}

public class Employee_Management_System {
    private ArrayList<Employee> employees;
    private Scanner scanner;

    public Employee_Management_System() {
        this.employees = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Method to add an employee
    public void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        String name = scanner.next();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, salary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    // Method to update an employee
    public void updateEmployee() {
        System.out.print("Enter ID of the employee to update: ");
        int id = scanner.nextInt();

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.print("Enter new Employee Name: ");
                String name = scanner.next();
                System.out.print("Enter new Employee Salary: ");
                double salary = scanner.nextDouble();

                employee.setName(name);
                employee.setSalary(salary);
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Method to remove an employee
    public void removeEmployee() {
        System.out.print("Enter ID of the employee to remove: ");
        int id = scanner.nextInt();

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("Employee removed successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Method to search for an employee
    public void searchEmployee() {
        System.out.print("Enter ID of the employee to search: ");
        int id = scanner.nextInt();

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("Employee found: " + employee);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Method to display all employees
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the list.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Employee_Management_System system = new Employee_Management_System();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    system.addEmployee();
                    break;
                case 2:
                    system.updateEmployee();
                    break;
                case 3:
                    system.removeEmployee();
                    break;
                case 4:
                    system.searchEmployee();
                    break;
                case 5:
                    system.displayEmployees();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
