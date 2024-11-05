import Model.Student;
import Model.StudentDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import static Model.StudentDAO.addStudent;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        System.out.println("SELECT THE OPTION U WANT TO DO");
        System.out.println("1- ADD NEW STUDENT");
        System.out.println("2- VIEW ALL STUDENTS");
        System.out.println("3- FIND STUDENT BY ID");
        int sw = sc.nextInt();
        switch (sw){
            case 1:{
            StudentDAO.addStudent();
             break;
            }

            case 2:
            case 3:{
                StudentDAO.getStudentById();
                break;
            }
        }

    }
}
