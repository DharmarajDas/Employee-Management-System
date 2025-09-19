import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String role = "";
        while (true) {
            System.out.print("Login as (admin/user): ");
            role = sc.nextLine().trim().toLowerCase();

            if (role.equals("admin")) {
                System.out.print("Enter admin password: ");
                String password = sc.nextLine().trim();
                if (password.equals("admin123")) {   // ✅ password check
                    System.out.println("✅ Admin login successful!");
                    break;
                } else {
                    System.out.println("❌ Wrong password. Try again.\n");
                }
            } else if (role.equals("user")) {
                System.out.println("✅ User login successful!");
                break;
            } else {
                System.out.println("❌ Invalid role. Please enter 'admin' or 'user'.\n");
            }
        }

        // Pass role to EmployeeManagementSystem
        EmployeeManagementSystem.run(role, sc);

        sc.close();
    }
}
