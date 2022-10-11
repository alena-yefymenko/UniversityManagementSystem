import java.util.ArrayList;
import java.util.Scanner;

public class UniversityCommandLine {
    static InterfaceCoursesDB coursesDB = new CoursesDB();

    public static void main(String[] args) {
        printCommands();
        readCommands();
    }

    public static void printCommands() {
        System.out.println("Welcome to the University!");
        System.out.println();
        // System.out.println("1. Add Student");
        // System.out.println("2. Vew All students");
        // System.out.println("3. Vew Single Student info");
        //System.out.println("4. Enroll student in to the course");
        // System.out.println("5. View student Exams");
        // System.out.println("6. Delete student");
        System.out.println("7. Add Course");
        System.out.println("8. View All Courses");
        System.out.println("9. View Single Course info");
        System.out.println(" ---------------------- ");
        System.out.println("Choose the number for activity You would like to perform: ");
    }

    public static void readCommands() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i == 7) {
            addCourse();
        } else if (i == 8) {
            viewAllCourses();
        } else if (i == 9) {
            viewSingleCourseInfo();
        }
    }

    private static void viewAllCourses() {
        ArrayList<Course> courses;
        try {
            courses = coursesDB.getCourses();
            for (Course c : courses) {
                System.out.println(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void addCourse() {
        System.out.println("Enter course title:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println("Enter duration (hours): ");
        int duration = scanner.nextInt();
        try {
            coursesDB.addCourse(title, duration);
            System.out.println("New course has been added successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void viewSingleCourseInfo() {
        System.out.println("Enter course title:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        Course course;
        try {
          course =  coursesDB.getCourseByTitle(title);
          System.out.println(course);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}


