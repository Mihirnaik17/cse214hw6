//Mihir Naik
//115348123
//R04
import java.io.Serializable;
import java.util.Comparator;
public class SemesterComparator implements Comparator, Serializable {

    /**
     * Compares two Course objects based on their semesters.
     *
     * @param left  the first Course object to be compared
     * @param right the second Course object to be compared
     * @return a negative integer, zero, or a positive integer if the first Course object is less than, equal to, or greater than the second Course object, respectively, based on their semesters
     * @throws ClassCastException if the specified objects are not instances of the Course class
     */


    public int compare(Object left, Object right){

        Course leftC = (Course) left;
        Course rightC = (Course) right;

        String leftCourse = leftC.getSemester();
        String rightCourse = rightC.getSemester();
        String leftSub = leftCourse.substring(1);
        String rightSub = rightCourse.substring(1);
        int leftYear = Integer.parseInt(leftSub);
        int rightYear = Integer.parseInt(rightSub);

        if(leftYear < rightYear){
            return -1;
        }
        else if(leftYear > rightYear){
            return 1;
        }
        else{
            if (leftCourse.charAt(0) == 'S' && rightCourse.charAt(0) == 'F') {
                return -1;
            }else if(leftCourse.charAt(0) == 'F' && rightCourse.charAt(0) == 'S'){
                return 1;
            }
            return 0;
        }
    
    }
    
}
