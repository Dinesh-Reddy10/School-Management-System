import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        // Step 1: Test database connection before starting the program
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println(" Wooohoo! Database connected successfully!");
        } catch (SQLException e) {
            System.out.println(" Sorry! Database connection failed: " + e.getMessage());
            return; // Stop program if DB connection fails
        }

        // Step 2: Start the School Management Menu
        SchoolManagementSystem.start();
    }
}
