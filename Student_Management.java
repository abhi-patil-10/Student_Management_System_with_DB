import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

class Student_Management {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    static void loadFromDB() {
        students.clear();
        try {
            ResultSet rs = DBUtils.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                String name = rs.getString("name");
                int roll_no = rs.getInt("roll_number");
                float marks = rs.getFloat("marks");

                students.add(new Student(name, roll_no, marks));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add_student() {
        System.out.println("Enter your name:");
        String user_name = sc.next();

        System.out.println("Enter your Roll Number:");
        int user_roll_no = sc.nextInt();

        System.out.println("Enter your marks:");
        float user_marks = sc.nextFloat();

        String query = "INSERT INTO students VALUES(" +
                user_roll_no + ",'" +
                user_name + "'," +
                user_marks + ")";

        DBUtils.executeUpdate(query);

        students.add(new Student(user_name, user_roll_no, user_marks));

        System.out.println("Student added successfully!");
    }

    public static void display_students() {
        for (Student s : students) {
            s.display();
        }
    }

    public static void remove_students() {
        System.out.println("Enter Roll Number to delete:");
        int user_roll_no = sc.nextInt();

        String query = "DELETE FROM students WHERE roll_number=" + user_roll_no;

        DBUtils.executeUpdate(query);

        System.out.println("Student removed from database.");
    }

    public static void update_students() {
        System.out.println("Enter your roll number for name update:");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.get_roll_no() == roll) {
                System.out.println("Enter your new name:");
                String temp_name = sc.next();
                s.setName(temp_name);

                String query = "UPDATE students SET name='" + temp_name +
                        "' WHERE roll_number=" + roll;

                DBUtils.executeUpdate(query);

                System.out.println("Name updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    public static void main(String[] args) {

        boolean exit = true;

        while (exit) {

            System.out.println("\n##### MENU #####");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Remove Student");

            System.out.println("4. Exit");
            System.out.print("Enter your Choice: ");

            char choice = sc.next().charAt(0);

            switch (choice) {

                case '1':
                    add_student();
                    break;

                case '2':
                    loadFromDB();
                    display_students();
                    break;

                case '3':
                    remove_students();
                    break;


                case '4':
                    System.out.println("Exited......");
                    exit = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
