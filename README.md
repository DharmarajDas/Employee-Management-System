# Employee Management System

A role-based **Employee Management System** built in **Java**.  
It allows administrators to manage employee records and normal users to view/search them.  
The system uses **file persistence** (`employees.txt`) to store data permanently and provides strong **input validation** to prevent invalid entries.  

---

## 🚀 Features

- 👨‍💼 **Role-Based Access**
  - **Admin**
    - Add Employee
    - Remove Employee
    - Update Employee
    - Search Employee
    - Display Employees
  - **Normal User**
    - Search Employee
    - Display Employees
- 🔑 **Admin Login**  
  - Default password: `admin123`
- ✅ **Input Validation**
  - Prevents negative age and salary  
  - Ensures Employee ID is positive and unique  
  - Checks for valid names and department values
- 💾 **File Persistence**
  - Saves all employee records to `employees.txt`  
  - Loads data automatically on startup
- 🔍 **Search Options**
  - Search employees by **ID**
  - Search employees by **Name**
- 🏢 **Department Management**
  - Each employee belongs to a department (HR, IT, Finance, etc.)

---

## 📂 Project Structure

EmployeeManagement/
│
├── Employee.java # Employee entity class
├── EmployeeService.java # Handles CRUD operations + file saving/loading
├── EmployeeManagementSystem.java # Main system logic & role-based menus
├── InputValidator.java # Input validation methods
├── Main.java # Entry point of the application
└── employees.txt # Data file (auto-generated at runtime)


---

## 🛠️ Technologies Used
- Java (Core, OOP)
- Collections (ArrayList)
- File Handling (TXT persistence)
- Console-based User Interface

---

## ▶️ How to Run

1. Clone the repository  
   ```bash
   git clone https://github.com/<your-username>/employee-management-system-java.git
   cd employee-management-system-java
   
2. Compile the project
   javac *.java
   
3. Run the program
   java Main

---

##🔑 Admin Login

Default Admin Password: admin123

Admins get full access (add/remove/update), while normal users can only view/search employees.

---

##📸 Sample Console Output

===== Employee Management System =====
Login as (admin/user): admin
Enter admin password: *****
✅ Login successful! Welcome, Admin.

===== Employee Management Menu =====
1. Add Employee
2. Remove Employee
3. Update Employee
4. Search Employee
5. Display Employees
6. Exit

---

## 🎯 Future Improvements

Export employee data to CSV/Excel

Add sorting/filtering (by salary, age, department)

GUI-based version with Swing/JavaFX

Database support (MySQL/PostgreSQL) instead of TXT file

---

## 📜 License

This project is open-source and available under the MIT License.

---

✅ You can copy this whole thing, save it as `README.md`, and push to GitHub.  

Do you also want me to create a **small GIF/diagram for the console output** so your README looks even cooler on GitHub?

