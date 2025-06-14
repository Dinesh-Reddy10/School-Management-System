# 🏫 School Management System (Java)

This is a Java-based console application simulating a real-world School Management System. It helps manage students across 10 predefined classes (Class 1 to Class 10) with features like:

- 🎓 Adding students to specific classes  
- 📊 Grade calculation based on 5 subjects  
- 💰 Fee calculation based on performance  
- 📆 Attendance tracking  
- 📋 Report card generation  

> Ideal for freshers and Java learners to practice OOP, collections, and modular project structure.

---

### 🛠 Tech Stack
- Java (OOP, Collections)
- Console I/O
- VS Code / IntelliJ

---

### ✅ Features Planned
- Teacher & subject management  
- Timetable generation  
- File export (CSV/TXT)  
- Authentication module  

---

### 📂 Project Structure
```bash
├── Main.java
├── SchoolManagementSystem.java
├── ClassRoom.java
├── Student.java
├── GradeCalculator.java
├── FeeCalculator.java
├── AttendanceManager.java
└── ReportCardGenerator.java


### Sample Input & Output
===== School Management Menu =====
1. Add Student to Class
2. View Students by Class
3. Calculate Grades
4. Calculate Fees
5. Mark Attendance
6. Generate Report Card
7. Exit
Enter your choice: 1

Enter class number (1-10): 3
Enter student name: Ravi Kumar
Student added to Class 3

===== School Management Menu =====
1. Add Student to Class
2. View Students by Class
3. Calculate Grades
4. Calculate Fees
5. Mark Attendance
6. Generate Report Card
7. Exit
Enter your choice: 3

Enter class number (1-10): 3

ID: 1 | Name: Ravi Kumar | Grade:  | Attendance: 0.0% | Fee: ₹0.0

===== School Management Menu =====
Enter your choice: 4

Enter 5 subject marks for Ravi Kumar:
85
90
78
88
92
Grades calculated.

===== School Management Menu =====
Enter your choice: 5
Fees calculated.

===== School Management Menu =====
Enter your choice: 5

Enter attendance % for Ravi Kumar: 94
Attendance marked.

===== School Management Menu =====
Enter your choice: 6

===== Report Cards =====

Class: Class 1
No students in Class 1

Class: Class 2
No students in Class 2

Class: Class 3
ID: 1 | Name: Ravi Kumar | Grade: B | Attendance: 94.0% | Fee: ₹15000.0

... (classes 4–10 skipped for brevity)

