
/**
 * A class of subject detail.
 * 
 * @author Dong Cai
 * @version 2016.10.5
 */
public class Subject
{
    String subjectName;

    /**
     * Constructor for objects of class Subject.
     * Initializing subject name.
     */
    public Subject(String newSubjectName)
    {
        subjectName = capitalise(newSubjectName);
    }

    /**
     * Get subject name.
     * @return subject name.
     */
    public String getName()
    {
        return subjectName;
    }

    /**
     * Set subject name.
     */
    public void setName(String newSubjectName)
    {
        subjectName = newSubjectName;
    }
    
    /**
     * Capitalise subject name.
     */
    private String capitalise(String subjectName)
    {
        return subjectName.substring(0,1).toUpperCase() + subjectName.substring(1).toLowerCase();
    }
}
