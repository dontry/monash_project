import java.util.ArrayList;

/**
 * A class of subject collection to maintain an aribitrary number of subject detail.
 * 
 * @author Dong Cai
 * @version 2016.10.4
 */
public class SubjectCollection
{
    private static String[] subjectOptions;
    private ArrayList<Subject> subjectList;
    /**
     * Perform any initialization of the subject collection.
     */
    public SubjectCollection()
    {
        // initialise instance variables
        subjectList = new ArrayList<Subject>();
    }

    /**
     * Add new subject to collection.
     * @param new subject.
     */
    public boolean add(Subject subject)
    {
        if(!contains(subject.getName()))
        {
            subjectList.add(subject);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Delete subject from collection.
     * @param subject.
     */
    public boolean delete(Subject subject)
    {
        if(contains(subject.getName()))
        {
            subjectList.remove(subject);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Get all subjects in an ArrayList form.
     * @return subject list.
     */
    public ArrayList<Subject> getAll()
    {
        return subjectList;
    }
    
    /**
     * Determine if collection has certain subject.
     * @return true if collection contain the subject, false otherwise.
     */
    public boolean contains(String subjectName) 
    {
        String subjectNameUp = subjectName.toUpperCase();
        for(Subject subject: subjectList)
        {
            if(subject.getName().toUpperCase().equals(subjectNameUp))
                return true;
        }
        return false;
    }
    
    /**
     * Change subject collection info into string format.
     * @return all sujbects in a string.
     */
    public String toString()
    {
        String subjectString = "";
        for(Subject subject: subjectList)
        {
            subjectString += subject.getName() + " ";
        }
        return subjectString;
    }
    
    /**
     * Get all valid subject options
     * @return subject options
     */
    public static String[] getAllSubjectOptions()
    {
        return subjectOptions;
    }
    
    /**
     * Determine if input subject is valid subject option.
     * @return true if subject is valid, false otherwise.
     */
    public static boolean exist(String subject)
    {
        for(String option: subjectOptions)
        {
            if(option.equals(subject.toUpperCase()))
                return true;
        }
        return false;
    }
    
    public static void initSubjectOption(ArrayList<String> subjectOpt)
    {
        subjectOptions = subjectOpt.toArray(new String[subjectOpt.size()]);
    }
}
