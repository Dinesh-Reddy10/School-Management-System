# 🏫 School Management System (Java + MySQL)

A simple **School Management System** built with **Java** and **MySQL** using **JDBC**.  
This project allows you to manage students, attendance, marks, and fees from a command-line menu.

---

## 📌 Features
- **Add Student** — Save student details in the database.
- **View Students by Class** — Fetch students based on class.
- **Mark Fees Paid** — Update fee status in the database.
- **Mark Attendance** — Store daily attendance records.
- **Add Marks** — Enter subject-wise marks for students.
- **Generate Report Card** — Display marks, calculate average.
- **Persistent Data** — All data is stored in a MySQL database.

---

## 🛠️ Tech Stack
- **Language:** Java (JDK 8+)
- **Database:** MySQL
- **Connector:** MySQL Connector/J (JDBC)
- **Tools:** Command Prompt, MySQL Workbench, GitHub

---

## 📂 Project Structure
src/<br>
    - Main.java<br>
    - SchoolManagementSystem.java<br>
    - DatabaseConnection.java<br>
    - ClassRoom.java<br>
    - Student.java<br>
    - GradeCalculator.java<br>
    - ReportCardGenerator.java<br>
    - FeeCalculator.java<br>
    - AttendanceManager.java<br>



---

## ⚙️ Setup Instructions

### 1️⃣ Install Requirements
- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

---

### 2️⃣ Create MySQL Database & Tables
Run in **MySQL Workbench**:
```sql
CREATE DATABASE school_db;
USE school_db;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    roll_number INT NOT NULL UNIQUE,
    class_name VARCHAR(50) NOT NULL,
    fees_paid BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE attendance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    roll_number INT NOT NULL,
    class_name VARCHAR(50) NOT NULL,
    date DATE NOT NULL,
    status ENUM('Present', 'Absent') NOT NULL,
    FOREIGN KEY (roll_number) REFERENCES students(roll_number)
);

CREATE TABLE marks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    roll_number INT NOT NULL,
    subject VARCHAR(50) NOT NULL,
    marks INT NOT NULL,
    FOREIGN KEY (roll_number) REFERENCES students(roll_number)
);
```
3️⃣ Compile the Project

Open Command Prompt inside your project folder:

mkdir out
javac -cp lib\mysql-connector-j-9.4.0.jar -d out src\*.java

4️⃣ Run the Project
java -cp "out;lib\mysql-connector-j-9.4.0.jar" Main



📋 Menu Options
1. Add Student to Class
2. View Students by Class
3. Calculate Grades
4. Calculate Fees (Mark Fees Paid)
5. Mark Attendance
6. Generate Report Card
7. Exit
8. Add Marks


🖥️ Example Usage and output screenshot<br>
===== School Management Menu =====<br>
Enter your choice: 1<br>
Enter student name: Alice<br>
Enter roll number: 101<br>
Enter class name: Class 5<br>
✅ Student added successfully!<br>
<br>
Enter your choice: 8<br>
Enter roll number: 101<br>
Enter subject: Math<br>
Enter marks: 95<br>
✅ Marks added successfully!<br>

<img width="1499" height="711" alt="image" src="https://github.com/user-attachments/assets/44146d0f-7b2e-433e-8fbb-153e3584bff3" />

<img width="1587" height="888" alt="image" src="https://github.com/user-attachments/assets/d997605e-6b6e-4fc1-8a30-2d486a994b89" />

📜 License

This project is open-source and available under the MIT License.

