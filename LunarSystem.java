//Mihir Naik
//115348123
//R04
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*; 
public class LunarSystem {

    private static HashMap<String, Student> database;
    public static void main(String[] args) {
        
        Scanner enter = new Scanner(System.in);
		boolean control = true;
        Student student;
        database = new HashMap<String, Student>();
        System.out.println("Welcome to the Lunar System, a second place course registration system for second rate courses at a second class school.");
        serializeStudent();
        while(control){

        System.out.println("Menu:");
        System.out.println("L)Login");
        System.out.println("X)Save state and quit");
        System.out.println("Q)Quit without saving state.");

        String input = enter.nextLine();

        if(input.isEmpty()){
            continue;
        }
        char UpperOption = Character.toUpperCase(input.charAt(0));
        switch(UpperOption){
            case'L':
            System.out.println("Please enter webid: ");
            String input1 = enter.nextLine();
            boolean L = true;

            if(input1.toUpperCase().equals("REGISTRAR")) {
                
                    System.out.println("Welcome Registrar.");
                    System.out.println("Options:");
                    System.out.println("R) Register a student");
                    System.out.println("D) De-register a student");
                    System.out.println("E) View course enrollment");
                    System.out.println("L) Logout");

                    while(L){
                    boolean p = false;
                    if(!p){
                        System.out.println("Please select an option: ");
                    }
                    String registrarOption = enter.nextLine();
                    if(registrarOption.isEmpty()) {
                        continue;
                    }
                    char UpperOption2 = Character.toUpperCase(registrarOption.charAt(0));
                    switch(UpperOption2) {

                        case 'R':
                            System.out.println("Please enter a webid for the new student: ");
                            String webid = enter.nextLine();
                            Student student3 = new Student(webid);
                            database.put(webid, student3);
                            System.out.println(student3.getWebID()+" registered.");
                            break;

                        case 'D':
                            System.out.println("Please enter a webid for the student to be deregistered: ");
                            String deregistarID = enter.nextLine();
                            if(!database.containsKey(deregistarID)){
                                System.out.println("Error: Could not find student in database");
                                return;
                            }    
                            for(String stu: database.keySet()) {
                                if(stu.equals(deregistarID)) {
                                    database.remove(stu);
                                }
                            }
                            System.out.println(deregistarID+ " deregistered.");
                            break;

                        case 'E':
                            System.out.println("Please enter course: ");
                            String enrolledC = enter.next();
                            System.out.println("Please enter course Number: ");
                            int cNumber = enter.nextInt();
                            System.out.println("Student    Semester");
                            System.out.println("--------------------");
                            for(String students : database.keySet()){
                                Student student1 = database.get(students);
                                ArrayList<Course> courses = student1.getCourse();
                                for(Course eachCourse : courses){
                                    if(eachCourse.getDepartment().equals(enrolledC)){
                                        if(eachCourse.getNumber() == cNumber){
                                            System.out.println(student1.getWebID()+" "+eachCourse.getSemester());
                                        }
                                    }
                                }
                            }

                            break;
                        case 'L':
                            L = false;
                            System.out.println("Registrar logged out.");
                            break;
        
                    }
                    }
                }
            
            else{
                if(database.containsKey(input1)){
                    student = database.get(input1);
                }else{
                    System.out.println("Could not find User");
                    return;
                }
                System.out.println("Welcome "+input1);
                while(L){
                System.out.println("Options:");
                System.out.println("A)Add a class");
                System.out.println("D)Drop a class");
                System.out.println("C)View your classes sorted by course name/department");
                System.out.println("S)View your courses sorted by semester");
                String studentOptions = enter.nextLine();
                if(studentOptions.isEmpty()){
                    continue;
                }
                char UpperOption3 = Character.toUpperCase(studentOptions.charAt(0));
                switch(UpperOption3){

                    case 'A':
    
                    System.out.print("Please enter course name: ");
                    String cName = enter.next();
                    System.out.print("Please enter the course number: ");
                    String cNumberString = enter.next(); 
                    int cNumber = Integer.parseInt(cNumberString);  
                    System.out.print("Please select a semester: ");
                    String cYear = enter.next();
                    Course course = new Course(cName, cNumber, cYear);
                    student.getCourse().add(course);
                    database.put(input1, student) ;
                    String firstChar = cYear.substring(0 ,1);                     
                    if (firstChar.equalsIgnoreCase("S")) {
                        String year = cYear.substring(1);
                        System.out.println("Added course " + cName + " " + cNumber + " for semester Spring " + year);
                    } else {
                        String year = cYear.substring(1);
                        System.out.println("Added course " + cName + " " + cNumber + " for semester Fall " + year);
                    }
                    break;
                
                    case'D':
                    System.out.println("Please enter course name: ");
                    String dropClass = enter.nextLine();
                    System.out.println("Please enter course Number: ");
                    int dropNumber = enter.nextInt();
                    ArrayList<Course> courses = student.getCourse();

                    for(Course Dropclass : courses){
                        if(Dropclass.getDepartment().equals(dropClass)){
                            if(Dropclass.getNumber() == dropNumber){
                                System.out.println("removed 1 course(s) from student "+student.getWebID());
                                courses.remove(Dropclass);
                                return;
                            }
                        }
                        else{
                            System.out.println("removed 0 course(s) from student "+student.getWebID());
                        }
                    }
                    break;

                    case'C':
                    ArrayList<Course> printcourse = student.getCourse();
                    printByCourseName(printcourse);
                    break;

                    case'S':
                    ArrayList<Course> printBySem = student.getCourse();
                    printBySemester(printBySem);
                    break;

                    case 'L':
                    L = false;
                    System.out.println(student.getWebID()+" logged out.");
                    break;
                }

            }
        }
            break;

            case'X':
            control = false;
            serializeStudent();
            System.out.println("System state saved, system shut down for maintenance.");

            break;

            case'Q':
            control = false;
            System.out.println("Good bye, please pick the right SUNY next time!");
            break;
        }
    }
} 
@SuppressWarnings("unchecked")
public static void printByCourseName(ArrayList<Course> printcourse){
        System.out.println("Dept. Course Semester");
        System.out.println("----------------------");
        int courseC = 1;
        for(int i = 0; i<printcourse.size()-1; i++){
            if(printcourse.get(i).getDepartment().equals(printcourse.get(i+1).getDepartment())){
                courseC++;
            } 
        }
        if(courseC != printcourse.size()){
            Collections.sort(printcourse, new CourseNameComparator());
            for(Course course : printcourse){
                System.out.println(course.getDepartment()+" "+course.getNumber()+"  "+course.getSemester());
            }
        }
        else{
            Collections.sort(printcourse, new CourseNumberComparator());
            for(Course course : printcourse){
                System.out.println(course.getDepartment()+" "+course.getNumber()+"  "+course.getSemester());
            }
        }
}

@SuppressWarnings("unchecked")
public static void printBySemester(ArrayList<Course> printBySem){
        System.out.println("Dept. Course Semester");
        System.out.println("----------------------");
        Collections.sort(printBySem, new SemesterComparator());
        for(Course course : printBySem){
            System.out.println(course.getDepartment()+" "+ course.getNumber()+" "+course.getSemester());
        }
}

public static void serializeStudent() {

    File file = new File("storeData.obj");
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
        out.writeObject(database);
        out.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
   }
}
