//Mihir Naik
//115348123
//R04
import java.util.Comparator;
import java.io.Serializable;
public class CourseNumberComparator implements Comparator, Serializable {
    /**
     * Compares two Course objects based on their course numbers.
     *
     * @param left  the first Course object to be compared
     * @param right the second Course object to be compared
     * @return a negative integer, zero, or a positive integer if the first Course object is less than, equal to, or greater than the second Course object, respectively, based on their course numbers
     * @throws ClassCastException if the specified objects are not instances of the Course class
     */


    public int compare(Object left, Object right){
        Course leftC = (Course) left;
        Course rightC = (Course) right;

        int leftnum = leftC.getNumber();
        int rightnum = rightC.getNumber();

        if(leftnum < rightnum){
            return -1;
        }
        else if(leftnum > rightnum){
            return 1;
        }
        else{
            return 0;
        }
    }
    
}
