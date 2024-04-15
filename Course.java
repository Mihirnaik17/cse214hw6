//Mihir Naik
//115348123
//R04
import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {

    private String department;
    private int number;
    private String semester;

    public Course(String department, int number, String semester){
        this.department = department;
        this.number = number;
        this.semester = semester;
    }

    /**
     * Getter for the department field.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Setter for the department field.
     *
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Getter for the number field.
     *
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Setter for the number field.
     *
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Getter for the semester field.
     *
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Setter for the semester field.
     *
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    


    
}
