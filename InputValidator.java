import java.util.Scanner;

public class InputValidator {
    public static int getValidInt(Scanner sc, String message, int min) {
        int value;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();
                if (value >= min) {
                    return value;
                } else {
                    System.out.println("❌ Value must be >= " + min);
                }
            } else {
                System.out.println("❌ Invalid input. Enter a number.");
                sc.nextLine();
            }
        }
    }

    public static double getValidDouble(Scanner sc, String message, double min) {
        double value;
        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                sc.nextLine();
                if (value >= min) {
                    return value;
                } else {
                    System.out.println("❌ Value must be >= " + min);
                }
            } else {
                System.out.println("❌ Invalid input. Enter a number.");
                sc.nextLine();
            }
        }
    }

    public static String getValidName(Scanner sc, String message) {
        String name;
        while (true) {
            System.out.print(message);
            name = sc.nextLine().trim();
            if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) {
                return name;
            } else {
                System.out.println("❌ Invalid name. Only letters allowed.");
            }
        }
    }

    public static String getValidDepartment(Scanner sc, String message) {
        String dept;
        while (true) {
            System.out.print(message);
            dept = sc.nextLine().trim();
            if (!dept.isEmpty() && dept.matches("[a-zA-Z ]+")) {
                return dept;
            } else {
                System.out.println("❌ Invalid department. Only letters allowed.");
            }
        }
    }
}
