import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class to maintain an arbitrary number of Student profile
 * 
 * @author Dong Cai
 * @version 2016.10.4
 */

public class StudentCollection
{
    private ArrayList<Student> studentList;

    /**
     * Constructor for objects of class StudentCollection.
     * Perform any initialization for the address book.
     */
    public StudentCollection()
    {
        // initialise instance variables
        studentList = new ArrayList<Student>();
    }

    /**
     * Add student to student list.
     * @param student
     */
    public void add(Student stud)
    {
        // put your code here
        studentList.add(stud);
    }

    /**
     * Delete student from student list.
     * @param student.
     * @return true if student exists and remove successful, false otherwise.
     */
    public boolean delete(Student stud)
    {
        try {
            studentList.remove(stud);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Find student by student name.
     * @param student name.
     * @return student.
     */
    public Student findByName(String studName)
    {
        String studNameUp = studName.toUpperCase();
        for(Student curStud: studentList)
        {
            String curStudNameUp = curStud.getName().toUpperCase();
            if(curStudNameUp.equals(studNameUp))
                return curStud;
        }
        return null;
    }

    /**
     * Retrieving all student.
     * @return student arrayList.
     */
    public ArrayList<Student> getAll()
    {
        return studentList;
    }

    public ArrayList<Student> searchBySubjects(String[] subjects)
    {
        ArrayList<Student> studlist = new ArrayList<Student>();
        for(Student stud: studentList)
        {   
            boolean isMatch = true;
            for(String subj: subjects)
            {
                if(stud.hasSubject(subj) == false)
                {
                    isMatch = false;
                }
            }
            if(isMatch)
                studlist.add(stud);
        }
        return studlist;
    }
}
