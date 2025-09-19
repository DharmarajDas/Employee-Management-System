import java.io.*;
import java.util.*;

public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    // ✅ Add Employee (prevent duplicate ID)
    public boolean addEmployee(Employee e) {
        for (Employee emp : employees) {
            if (emp.getId() == e.getId()) {
                System.out.println("❌ Employee with ID " + e.getId() + " already exists!");
                return false;
            }
        }
        employees.add(e);
        return true;
    }

    // ✅ Remove Employee
    public void removeEmployee(int id) {
        employees.removeIf(emp -> emp.getId() == id);
    }

    // ✅ Update Employee
    public boolean updateEmployee(int id, String name, int age, double salary, String dept) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(name);
                emp.setAge(age);
                emp.setSalary(salary);
                emp.setDepartment(dept);
                return true;
            }
        }
        return false;
    }

    // ✅ Display all Employees
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("⚠ No employees to display.");
            return;
        }
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    // ✅ Search by ID
    public Employee searchById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) return emp;
        }
        return null;
    }

    // ✅ Search by Name
    public List<Employee> searchByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getName().equalsIgnoreCase(name)) {
                result.add(emp);
            }
        }
        return result;
    }

    // ✅ Save employees to file
    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Employee emp : employees) {
                pw.println(emp.getId() + "," + emp.getName() + "," + emp.getAge() + "," +
                           emp.getSalary() + "," + emp.getDepartment());
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving to file: " + e.getMessage());
        }
    }

    // ✅ Load employees from file
    public void loadFromFile(String filename) {
        employees.clear();
        File file = new File(filename);
        if (!file.exists()) {
            return; // no saved file yet
        }
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                if (data.length == 5) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    double salary = Double.parseDouble(data[3]);
                    String dept = data[4];
                    employees.add(new Employee(id, name, age, salary, dept));
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error loading from file: " + e.getMessage());
        }
    }
}
