import java.lang.String;

public class Students implements IStudents {

    private int courseId;
    private String fullName;
    private int dateOfBirth;
    private String email;

    public Students() {

    }


    public String setFullName(String fullName) {
        this.fullName = fullName;
        return fullName;
    }


    public int setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return dateOfBirth;
    }


    public int setCourseId(int courseId) {
        this.courseId = courseId;
        return courseId;
    }

    @Override
    public String toString() {
        return String.format("StudentsId %d  Students full_name: \"%s\" --- date_of_birth: %d ", fullName, dateOfBirth);
    }

    @Override
    public void addStudent() {

    }

    @Override
    public void viewAllStudents() {
    }

    @Override
    public void viewStudentInfo() {
    }
}