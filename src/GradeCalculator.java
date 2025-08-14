import java.util.*;

public class GradeCalculator {
    public static void calculateGrades(List<ClassRoom> classes) {
        Scanner sc = new Scanner(System.in);
        for (ClassRoom cls : classes) {
            for (Student s : cls.getStudents()) {
                System.out.println("Enter 5 subject marks for " + s.getName() + ":");
                int[] marks = new int[5];
                int sum = 0;
                for (int i = 0; i < 5; i++) {
                    marks[i] = sc.nextInt();
                    sum += marks[i];
                }
                s.setMarks(marks);
                int avg = sum / 5;
                char grade = avg >= 90 ? 'A' : avg >= 75 ? 'B' : avg >= 60 ? 'C' : 'D';
                s.setGrade(grade);
            }
        }
        System.out.println("Grades calculated.");
    }
}
