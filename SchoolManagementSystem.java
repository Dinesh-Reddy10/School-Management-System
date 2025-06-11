import java.util.*;

public class SchoolManagementSystem {
    private static Scanner sc = new Scanner(System.in);
    private static ClassRoom[] classes = new ClassRoom[10];

    static {
        for (int i = 0; i < 10; i++) {
            classes[i] = new ClassRoom("Class " + (i + 1));
        }
    }

    public static void start() {
        int choice;
        do {
            System.out.println("\n===== School Management Menu =====");
            System.out.println("1. Add Student to Class");
            System.out.println("2. View Students by Class");
            System.out.println("3. Calculate Grades");
            System.out.println("4. Calculate Fees");
            System.out.println("5. Mark Attendance");
            System.out.println("6. Generate Report Card");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudentToClass(); break;
                case 2: viewStudentsByClass(); break;
                case 3: GradeCalculator.calculateGrades(Arrays.asList(classes)); break;
                case 4: FeeCalculator.calculateFees(Arrays.asList(classes)); break;
                case 5: AttendanceManager.markAttendance(Arrays.asList(classes)); break;
                case 6: ReportCardGenerator.generateReport(Arrays.asList(classes)); break;
                case 7: System.out.println("Exiting... Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    }

    private static void addStudentToClass() {
        System.out.print("Enter class number (1-10): ");
        int num = sc.nextInt();
        if (num < 1 || num > 10) {
            System.out.println("Invalid class number.");
            return;
        }
        classes[num - 1].addStudent();
    }

    private static void viewStudentsByClass() {
        System.out.print("Enter class number (1-10): ");
        int num = sc.nextInt();
        if (num < 1 || num > 10) {
            System.out.println("Invalid class number.");
            return;
        }
        classes[num - 1].showAllStudents();
    }
}
