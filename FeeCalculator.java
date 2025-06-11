import java.util.*;

public class FeeCalculator {
    public static void calculateFees(List<ClassRoom> classes) {
        for (ClassRoom cls : classes) {
            for (Student s : cls.getStudents()) {
                double fee = 0;
                int avg = Arrays.stream(s.getMarks()).sum() / 5;
                if (avg >= 90) fee = 10000;
                else if (avg >= 75) fee = 15000;
                else fee = 20000;
                s.setFee(fee);
            }
        }
        System.out.println("Fees calculated.");
    }
}