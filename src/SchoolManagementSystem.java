import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

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
            System.out.println("4. Calculate Fees (Mark Fees Paid)");
            System.out.println("5. Mark Attendance");
            System.out.println("6. Generate Report Card");
            System.out.println("7. Exit");
            System.out.println("8. Add Marks");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int roll = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter class name: ");
                    String className = sc.nextLine();
                    addStudentToClass(name, roll, className);
                    break;

                case 2:
                    System.out.print("Enter class name: ");
                    className = sc.nextLine();
                    viewStudentsByClass(className);
                    break;

                case 3:
                    GradeCalculator.calculateGrades(Arrays.asList(classes));
                    break;

                case 4:
                    System.out.print("Enter roll number to mark fees paid: ");
                    roll = Integer.parseInt(sc.nextLine());
                    markFeesPaid(roll);
                    break;

                case 5:
    			markAttendance();
    			break;

		case 6:
    			generateReportCard();
    			break;


                case 7:
                    System.out.println("Exiting... Goodbye!");
                    break;
		case 8:
    			sc.nextLine(); // clear buffer
    			addMarks();
    			break;


                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    }

    public static void addStudentToClass(String studentName, int rollNumber, String className) {
        String sql = "INSERT INTO students (name, roll_number, class_name) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentName);
            stmt.setInt(2, rollNumber);
            stmt.setString(3, className);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println(" Student added successfully!");
            }
        } catch (SQLException e) {
            System.out.println(" Error adding student: " + e.getMessage());
        }
    }

    public static void viewStudentsByClass(String className) {
        String sql = "SELECT id, name, roll_number, fees_paid FROM students WHERE class_name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, className);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("ID | Name | Roll No | Fees Paid");
                while (rs.next()) {
                    System.out.printf("%d | %s | %d | %s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("roll_number"),
                        rs.getBoolean("fees_paid") ? "Yes" : "No");
                }
            }
        } catch (SQLException e) {
            System.out.println(" Error fetching students: " + e.getMessage());
        }
    }

    public static void markFeesPaid(int rollNumber) {
        String sql = "UPDATE students SET fees_paid = TRUE WHERE roll_number = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, rollNumber);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println(" Fees marked as paid.");
            } else {
                System.out.println("⚠ No student found with that roll number.");
            }
        } catch (SQLException e) {
            System.out.println(" Error updating fees: " + e.getMessage());
        }
    }
	
	public static void markAttendance() {
    System.out.print("Enter roll number: ");
    int roll = Integer.parseInt(sc.nextLine());
    System.out.print("Enter class name: ");
    String className = sc.nextLine();
    System.out.print("Enter date (YYYY-MM-DD): ");
    String date = sc.nextLine();
    System.out.print("Enter status (Present/Absent): ");
    String status = sc.nextLine();

    String sql = "INSERT INTO attendance (roll_number, class_name, date, status) VALUES (?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, roll);
        stmt.setString(2, className);
        stmt.setString(3, date);
        stmt.setString(4, status);
        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println(" Attendance marked successfully.");
        }
    } catch (SQLException e) {
        System.out.println(" Error marking attendance: " + e.getMessage());
    }
}

public static void generateReportCard() {
    System.out.print("Enter roll number: ");
    int roll = Integer.parseInt(sc.nextLine());

    String sql = "SELECT subject, marks FROM marks WHERE roll_number = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, roll);
        try (ResultSet rs = stmt.executeQuery()) {
            System.out.println("Report Card for Roll Number: " + roll);
            int total = 0, count = 0;
            while (rs.next()) {
                String subject = rs.getString("subject");
                int mark = rs.getInt("marks");
                System.out.println(subject + ": " + mark);
                total += mark;
                count++;
            }
            if (count > 0) {
                System.out.println("Average: " + (total / count));
            } else {
                System.out.println("No marks found for this student.");
            }
        }
    } catch (SQLException e) {
        System.out.println(" Error generating report card: " + e.getMessage());
    }
}

public static void addMarks() {
    System.out.print("Enter roll number: ");
    int roll = Integer.parseInt(sc.nextLine());
    System.out.print("Enter subject: ");
    String subject = sc.nextLine();
    System.out.print("Enter marks: ");
    int marks = Integer.parseInt(sc.nextLine());

    String sql = "INSERT INTO marks (roll_number, subject, marks) VALUES (?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, roll);
        stmt.setString(2, subject);
        stmt.setInt(3, marks);
        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println(" Marks added successfully.");
        }
    } catch (SQLException e) {
        System.out.println(" Error adding marks: " + e.getMessage());
    }
}

}
