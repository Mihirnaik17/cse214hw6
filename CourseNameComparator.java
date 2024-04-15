//Mihir Naik
//115348123
//R04
import java.util.Comparator;
import java.io.Serializable;

public class CourseNameComparator implements Comparator<Course>, Serializable {

    /**
     * Compares two Course objects based on their department names.
     *
     * @param o1 the first Course object to be compared
     * @param o2 the second Course object to be compared
     * @return a negative integer, zero, or a positive integer if the first Course object is less than, equal to, or greater than the second Course object, respectively, based on their department names
     * @throws ClassCastException if the specified objects are not instances of the Course class
     */
    @Override
    public int compare(Course o1, Course o2) { // 
        Course leftCourse = o1;
        Course rightCourse = o2;
        return leftCourse.getDepartment().compareTo(rightCourse.getDepartment());
    }
}