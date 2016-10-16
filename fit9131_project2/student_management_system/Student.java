import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * A class to maintain student profile
 * 
 * @author Dong Cai 
 * @version 2016.10.4
 */
public class Student
{

    private final static int PHONE_NUM_LENGTH = 9;  //required phone number length
    private final static char FIRST_PHONE_DIGIT = '9'; //the first digit of phone number should be 9
    private final static String NAME_PATTERN = "^[a-zA-Z]+? [a-zA-Z]+?$"; //required student name regular expression: only consists of letters
    private final static String PHONENUM_PATTERN = "^9\\d{8}$"; //required phone number regular expression: 9 digits, first digit is 9
    private String name;
    private String phoneNum;
    private SubjectCollection subjects;

    /**
     * Constructor for objects of class Student
     * Provide an empty student subject, if no argument.
     */
    public Student()
    {
        name = "";
        phoneNum = "";
        subjects = new SubjectCollection();
    }

    /**
     * Initializing Student profile with validations.
     * Throw exception, if invalid argument exists.
     */
    public Student(String newName, String newPhoneNum, String newSubjects) throws InvalidArgumentException
    {
        subjects = new SubjectCollection();

        if(!setName(newName))
            throw new InvalidArgumentException("student name");

        if(!setPhoneNum(newPhoneNum))
            throw new InvalidArgumentException("phone number");

        if(!setSubject(newSubjects))
            throw new InvalidArgumentException("subject");
    }

    /**
     * Get student name.
     * @return student name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get phone number.
     * @return phone number in string.
     */
    public String getPhoneNum()
    {
        return phoneNum;
    }

    /**
     * Get subjects.
     * @return subjects in string.
     */
    public String getSubjects()
    {

        return subjects.toString();
    }

    /**
     * Set student name.
     * @param student name
     * @return true if set name successful, false otherwise.
     */
    public boolean setName(String newName)
    {
        newName = newName.trim();
        if(!isNameValidReg(newName))  
            return false;

        name = capitalise(newName);
        return true;
    }

    /**
     * Validate student name with regular expression.
     * @param student name.
     * @return true ife name is valid, false otherwise.
     */
    private static boolean isNameValidReg(String name)
    {
        return Pattern.matches(NAME_PATTERN, name);
    }

    /**
     * Set phone number.
     * @param phone number
     * @return true set phone number successful, false otherwise.
     */
    public boolean setPhoneNum(String newPhoneNum)
    {
        if(!isPhoneValidReg(newPhoneNum))
            return false;

        phoneNum = newPhoneNum;
        return true;
    }

    /**
     * Validate phone number with regular expression.
     * @param phone number.
     * @return true if phone number is valid, false otherwise.
     */
    private static boolean isPhoneValidReg(String phoneNum)
    {
        return Pattern.matches(PHONENUM_PATTERN, phoneNum);
    }

    /**
     * Set subjects.
     * @param subjects in string.
     * @return true set subjects successful, false otherwise.
     */
    public boolean setSubject(String newSubjects)
    {
        newSubjects = newSubjects.trim();
        String[] newSubjectsArray = newSubjects.split(" ");
        for(String newSubject: newSubjectsArray)
        {
            if(!isSubjectValid(newSubject)) 
                return false;              
            if(!addSubject(newSubject))
            {
                System.out.println(newSubject +" already exists");
            }
        }
        return true;
    }

    /**
     * Add subject to subject collection
     * @param subjects in Array.
     */
    public boolean addSubject(String newSubject) 
    {
        return subjects.add(new Subject(newSubject));
    }

    /**
     * Determine if subject is in subject collection.
     * @param subject name.
     * @return true if subject in collection, false otherwise.
     */
    public boolean hasSubject(String subjectName)
    {
        String subjNameUp = subjectName.toUpperCase();
        for(Subject subject: subjects.getAll())
        {        
            if(subject.getName().toUpperCase().equals(subjNameUp))
                return true;
        }
        return false;
    }

    /**
     * Validate subject.
     * @param subject name.
     * @return true if subject is valid, false otherwise.
     */
    private static boolean isSubjectValid(String subject)
    {
        if(SubjectCollection.exist(subject))
            return true;
        else
            return false;
    }

    /**
     * Display student profile
     */
    public void displayInfo()
    {
        System.out.println(toString());
    }

    public String toString()
    {
        return name + "," + phoneNum + "," + subjects.toString();
    }
    
    
    /**
     * Capitalise name
     */
    private String capitalise(String name)
    {
        String capName="";
        String[] partialName = name.trim().split(" ");
        for(int i = 0; i < partialName.length; i++)
        {
                capName += partialName[i].substring(0,1).toUpperCase() + partialName[i].substring(1).toLowerCase();
                if(i < partialName.length-1)
                    capName += " ";                
        }
        return capName;
    }

//     public static boolean isArgumentValid(String newName, String newPhoneNum, String newSubject)
//     {
//         return isNameValidReg(newName) && isPhoneValidReg(newPhoneNum) && isSubjectValid(newSubject);
//     }
}
