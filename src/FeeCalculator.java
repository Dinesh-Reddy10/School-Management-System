import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeeCalculator {

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
}
