//Mihir Naik
//115348123
//R04
import java.util.ArrayList;
import java.io.Serializable;

/**
 * The Student class represents a student with a web ID and a list of courses.
 * It provides methods to access and modify the student's web ID and courses.
 */
public class Student implements Serializable {

    private String webID;
    private ArrayList<Course> courses;

    /**
     * Constructs a new Student object with no web ID and an empty list of courses.
     */
    public Student() {}

    /**
     * Constructs a new Student object with the specified web ID and an empty list of courses.
     *
     * @param webID the web ID of the student
     */
    public Student(String webID) {
        this.webID = webID;
        courses = new ArrayList<>();
    }

    /**
     * Returns the web ID of the student.
     *
     * @return the web ID of the student
     */
    public String getWebID() {
        return webID;
    }

    /**
     * Returns the list of courses associated with the student.
     *
     * @return the list of courses associated with the student
     */
    public ArrayList<Course> getCourse() {
        return courses;
    }

    /**
     * Sets the web ID of the student.
     *
     * @param webID the new web ID of the student
     */
    public void setWebID(String webID) {
        this.webID = webID;
    }

    /**
     * Sets the list of courses associated with the student.
     *
     * @param courses the new list of courses associated with the student
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}

