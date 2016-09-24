
/**
 * Write a description of class StudentCollection here.
 * 
 * @author (Dong Cai) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.HashMap;

public class StudentCollection
{
    // instance variables - replace the example below with your own
    private ArrayList<Student> studentList;

    /**
     * Constructor for objects of class StudentCollection
     */
    public StudentCollection()
    {
        // initialise instance variables
       studentList = new ArrayList<Student>();
    }

    public void add(Student stud)
    {
        // put your code here
        studentList.add(stud);
    }
    
    public boolean delete(String studName)
    {
        Student stud = findByName(studName);
        if(stud != null)
        {
            studentList.remove(stud);
        } else {
            return true;
        }
        return false;
    }
    
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
    
    public HashMap<String, ArrayList<Student>> listStudsBySubject()
    {
        HashMap<String, ArrayList<Student>> subjectList = new HashMap<String, ArrayList<Student>>();
        
        for(String subject: Subject.getSubjectOptions())
        {
            ArrayList<Student> studList = getStudsBySubject(subject);
            subjectList.put(subject, studList);
        }
        return subjectList;
    }
    
    
    public ArrayList<Student> getStudsBySubject(String subject)
    {
        ArrayList<Student> subjectStudList = new ArrayList<Student>();
        String subjectUp = subject.toUpperCase();
        for(Student curStud: studentList)
        {
            String curSubjectUp = curStud.getSubject().toUpperCase();
            if(curSubjectUp.equals(subjectUp))
                subjectStudList.add(curStud);
        }
        return subjectStudList;
    }
    
    public ArrayList<Student> listAll()
    {
        return studentList;
    }
}
