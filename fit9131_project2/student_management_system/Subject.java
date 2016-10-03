
/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Subject
{
    // instance variables - replace the example below with your own
    private static final String[] SUBJECT_OPTIONS = new String[] {"MATHS", "COMPUTING", "ENGLISH"};

    /**
     * Constructor for objects of class Subject
     */
    public Subject()
    {
        // initialise instance variables
       super();
    }
    
    public static String[] getSubjectOptions()
    {
        return SUBJECT_OPTIONS;
    }
    
    public static boolean contains(String subject)
    {
        for(String option: SUBJECT_OPTIONS)
        {
            if(option.equals(subject.toUpperCase()))
                return true;
        }
        return false;
    }
}
