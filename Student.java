public class Student {
    private int id;
    private String name;
    private int[] marks = new int[5];
    private double attendancePercentage;
    private double fee;
    private char grade;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int[] getMarks() { return marks; }
    public void setMarks(int[] marks) { this.marks = marks; }
    public void setGrade(char grade) { this.grade = grade; }
    public void setAttendance(double att) { this.attendancePercentage = att; }
    public void setFee(double fee) { this.fee = fee; }

    public void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | Grade: " + grade +
                           " | Attendance: " + attendancePercentage + "% | Fee: ₹" + fee);
    }
}
