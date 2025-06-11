import java.util.*;

public class ClassRoom {
    private String name;
    private List<Student> students = new ArrayList<>();
    private static int rollCounter = 1;
    Scanner sc = new Scanner(System.in);

    public ClassRoom(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public List<Student> getStudents() { return students; }

    public void addStudent() {
        sc.nextLine();
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();
        students.add(new Student(rollCounter++, studentName));
        System.out.println("Student added to " + name);
    }

    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in " + name);
            return;
        }
        for (Student s : students) {
            s.displayInfo();
        }
    }
}