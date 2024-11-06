package Model;
import Model.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO extends DbConnection {
    private static final Scanner sc = new Scanner(System.in);

    public static void getStudentById(int id) {
        Student student = null;
        String query = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                student = new Student(
                        rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("age"),
                        rs.getDouble("gpa")
                );
                System.out.println(student.id);
                System.out.println(student.fname);
                System.out.println(student.age);
                System.out.println(student.gpa);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("COULDN'T FIND STUDENT WITH THIS ID");
        }
    }

    public static void addStudent() {
        System.out.println("Enter First name");
        String fname = sc.next();
        System.out.println("Enter Last name");
        String lname = sc.next();
        System.out.println("Enter Age");
        int age = sc.nextInt();
        System.out.println("Enter Gpa");
        double gpa = sc.nextDouble();
        Student student = null;
        String query = "insert into students (fname,lname,age,gpa)" +
                "values (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.setInt(3, age);
            stmt.setDouble(4, gpa);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                student = new Student(
                        rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("age"),
                        rs.getDouble("gpa")
                );
                getStudentById(rs.getInt("id")); // fix later
            }
        } catch (SQLException ex) {
            throw new RuntimeException("ERROR WHILE ADDING NEW STUDENT");
        }
    }

    public static void viewAllStudents() {
        Student student = null;
        ArrayList<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("age"),
                        rs.getDouble("gpa")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("ID : "+list.get(i).id);
            System.out.println("FIRST NAME : "+list.get(i).fname);
            System.out.println("LAST NAME : " + list.get(i).lname);
            System.out.println("AGE : "+list.get(i).age);
            System.out.println("GPA : "+list.get(i).gpa);
            System.out.println("------------------------------------------");
        }
    }
}


