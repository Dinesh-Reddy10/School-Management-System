import java.util.*;

public class AttendanceManager {
    public static void markAttendance(List<ClassRoom> classes) {
        Scanner sc = new Scanner(System.in);
        for (ClassRoom cls : classes) {
            for (Student s : cls.getStudents()) {
                System.out.print("Enter attendance % for " + s.getName() + ": ");
                double att = sc.nextDouble();
                s.setAttendance(att);
            }
        }
        System.out.println("Attendance marked.");
    }
}
