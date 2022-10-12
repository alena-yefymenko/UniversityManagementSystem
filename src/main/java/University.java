
import java.sql.*;
import java.util.Scanner;

public class University {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/University", "root", "root");
            Students newStudents = new Students();
            newStudents.addStudent();
            addStudent(connection, newStudents);
            // setCourseToStudent(connection, 2, 2);

            //viewAllStudents(connection);
            //viewStudentInfo(connection, 5);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void viewStudents(Connection connection) {

        String geAllStudentsQuery = "SELECT * FROM University.Students";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(geAllStudentsQuery);

            while (resultSet.next()) {
                System.out.print("Student's id: " + resultSet.getString(1));
                System.out.print(" Name and surname: " + resultSet.getString(2));
                System.out.println(" Date of birth: " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(Connection connection, Students students) {
        Scanner k = new Scanner(System.in);

        System.out.println("Please enter student's full name: ");
        String studentName = k.nextLine();

        System.out.println("Enter student's date of birth by pattern yyyymmdd");
        int studentDateOfBirth = k.nextInt();

        k.close();


        String addStudentQuery = "INSERT INTO University.Students(full_name, date_of_birth ) VALUES (?,?);";

        try {

            PreparedStatement pStatement = connection.prepareStatement(addStudentQuery);
            pStatement.setString(1, students.setFullName(studentName));
            pStatement.setInt(2, students.setDateOfBirth(studentDateOfBirth));


            pStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewStudentInfo(Connection connection, int id) {

        String getUserQuery = "SELECT * FROM University.Students WHERE id = " + id;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getUserQuery);

            while (resultSet.next()) {
                System.out.println("Student's id: " + resultSet.getString(1));
                System.out.println("Name and surname: " + resultSet.getString(2));
                System.out.println("Email: " + resultSet.getString(3));
                System.out.println("Date of birth: " + resultSet.getString(4));
                System.out.println("Course id: " + resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setCourseToStudent(Connection connection, int id, int course_id) {
        String updateStudentQuery = "UPDATE University.Students SET course_id = ? WHERE id = ?";

        try {
            PreparedStatement pStatement = connection.prepareStatement(updateStudentQuery);

            pStatement.setInt(1, course_id);
            pStatement.setInt(2, id);

            pStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}