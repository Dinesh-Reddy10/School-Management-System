import java.util.*;

public class ReportCardGenerator {
    public static void generateReport(List<ClassRoom> classes) {
        System.out.println("\n===== Report Cards =====");
        for (ClassRoom cls : classes) {
            System.out.println("\n" + cls.getName());
            cls.showAllStudents();
        }
    }
}
