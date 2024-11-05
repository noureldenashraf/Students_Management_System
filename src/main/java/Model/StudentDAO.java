package Model;
import Model.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO extends DbConnection {
    private static final Scanner sc = new Scanner(System.in);

    public static void getStudentById() {
        System.out.println("ENTER ID");
        int id = sc.nextInt();
        Student student = null;
        String query = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                student = new Student(
                        rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("age"),
                        rs.getString("gpa")
                );
                System.out.println(student.id);
                System.out.println(student.fname);
                System.out.println(student.age);
                System.out.println(student.gpa);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
            stmt.setString(1,fname);
            stmt.setString(2,lname);
            stmt.setInt(3,age);
            stmt.setDouble(4,gpa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                student = new Student(
                        rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("age"),
                        rs.getString("gpa")
                );
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}


