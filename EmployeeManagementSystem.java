import java.util.*;

public class EmployeeManagementSystem {
    public static void run(String role, Scanner sc) {
        EmployeeService ems = new EmployeeService();
        ems.loadFromFile("employees.txt"); // load saved employees

        int choice = 0;
        while (true) {
            System.out.println("\n===== Employee Management Menu =====");

            if (role.equals("admin")) {
                System.out.println("1. Add Employee");
                System.out.println("2. Remove Employee");
                System.out.println("3. Update Employee");
                System.out.println("4. Search Employee");
                System.out.println("5. Display Employees");
                System.out.println("6. Exit");
            } else { // Normal user
                System.out.println("1. Search Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Exit");
            }

            System.out.print("Enter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("❌ Invalid choice. Enter a number.");
                sc.nextLine();
                continue;
            }
            choice = sc.nextInt();
            sc.nextLine();

            if (role.equals("admin")) {
                switch (choice) {
                    case 1: // Add
                        int id = InputValidator.getValidInt(sc, "Enter Employee ID: ", 1);
                        String name = InputValidator.getValidName(sc, "Enter Name: ");
                        int age = InputValidator.getValidInt(sc, "Enter Age: ", 18);
                        double salary = InputValidator.getValidDouble(sc, "Enter Salary: ", 0);
                        String dept = InputValidator.getValidDepartment(sc, "Enter Department: ");

                        Employee e = new Employee(id, name, age, salary, dept);
                        if (ems.addEmployee(e)) {
                            System.out.println("✅ Employee added!");
                            ems.saveToFile("employees.txt");
                        }
                        break;

                    case 2: // Remove
                        int removeId = InputValidator.getValidInt(sc, "Enter Employee ID to remove: ", 1);
                        ems.removeEmployee(removeId);
                        ems.saveToFile("employees.txt");
                        System.out.println("✅ Employee removed!");
                        break;

                    case 3: // Update
                        int updateId = InputValidator.getValidInt(sc, "Enter Employee ID to update: ", 1);
                        String newName = InputValidator.getValidName(sc, "Enter new name: ");
                        int newAge = InputValidator.getValidInt(sc, "Enter new age: ", 18);
                        double newSalary = InputValidator.getValidDouble(sc, "Enter new salary: ", 0);
                        String newDept = InputValidator.getValidDepartment(sc, "Enter new department: ");
                        if (ems.updateEmployee(updateId, newName, newAge, newSalary, newDept)) {
                            System.out.println("✅ Employee updated!");
                            ems.saveToFile("employees.txt");
                        } else {
                            System.out.println("❌ Employee not found!");
                        }
                        break;

                    case 4: // Search
                        searchMenu(sc, ems);
                        break;

                    case 5: // Display
                        ems.displayEmployees();
                        break;

                    case 6:
                        System.out.println("💾 Saving & exiting...");
                        ems.saveToFile("employees.txt");
                        return;

                    default:
                        System.out.println("❌ Invalid choice.");
                }
            } else { // Normal User
                switch (choice) {
                    case 1: // Search
                        searchMenu(sc, ems);
                        break;

                    case 2: // Display
                        ems.displayEmployees();
                        break;

                    case 3:
                        System.out.println("💾 Exiting...");
                        return;

                    default:
                        System.out.println("❌ Invalid choice.");
                }
            }
        }
    }

    // ✅ Search Menu (only ID & Name now)
    private static void searchMenu(Scanner sc, EmployeeService ems) {
        System.out.println("1. By ID\n2. By Name");
        int searchChoice = sc.nextInt();
        sc.nextLine();
        if (searchChoice == 1) {
            int searchId = InputValidator.getValidInt(sc, "Enter ID: ", 1);
            Employee emp = ems.searchById(searchId);
            System.out.println(emp != null ? emp : "❌ Not found");
        } else if (searchChoice == 2) {
            String searchName = InputValidator.getValidName(sc, "Enter Name: ");
            List<Employee> list = ems.searchByName(searchName);
            list.forEach(System.out::println);
            if (list.isEmpty()) System.out.println("❌ Not found");
        } else {
            System.out.println("❌ Invalid choice.");
        }
    }
}
