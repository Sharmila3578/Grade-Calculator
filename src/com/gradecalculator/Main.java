import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GradeCalculator gc = new GradeCalculator();
        Scanner scanner = new Scanner(System.in);
        String option;

        System.out.println("=== Student Grade Calculator ===");

        do {
            System.out.println("\nOptions: add | view | exit");
            System.out.print("Choose: ");
            option = scanner.nextLine();

            switch (option) {
                case "add":
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter marks: ");
                    int marks = Integer.parseInt(scanner.nextLine());
                    gc.addStudent(name, marks);
                    break;
                case "view":
                    gc.displayStudents();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (!option.equals("exit"));
    }
}
