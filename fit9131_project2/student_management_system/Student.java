
/**
 * Write a description of class Student here.
 * 
 * @author (Dong Cai) 
 * @version (a version number or a date)
 */
import java.util.Arrays;
import java.util.regex.Pattern;

public class Student
{
    // instance variables - replace the example below with your own
    private final static int PHONE_NUM_LENGTH = 9;
    private final static char FIRST_PHONE_DIGIT = '9';
    private final static String NAME_PATTERN = "^[a-zA-Z]+? [a-zA-Z]+?$";
    private final static String PHONENUM_PATTERN = "^9\\d{8}$";
    private String name;
    private String phoneNum;
    private String subject;

    /**
     * Constructor for objects of class Student
     */
    public Student(String newName, String newPhoneNum, String newSubject)
    {
        setName(newName);
        setPhoneNum(newPhoneNum);
        setSubject(newSubject);
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPhoneNum()
    {
        return phoneNum;
    }
    
    public String getSubject()
    {
        return subject;
    }
    
    public boolean setName(String newName)
    {
            newName = newName.trim();
            if(isNameValidReg(newName)) 
            {
                name = newName;
                return true;
            } else  
                return false;
    }
    
    private static boolean isNameValidReg(String name)
    {
        return Pattern.matches(NAME_PATTERN, name);
    }
    
    public boolean setPhoneNum(String newPhoneNum)
    {
        if(isPhoneValidReg(newPhoneNum))
        {
            phoneNum = newPhoneNum;
            return true;
        } else {
            return false;
        }
   }
    
    private static boolean isPhoneValidReg(String phoneNum)
    {
        return Pattern.matches(PHONENUM_PATTERN, phoneNum);
    }
     
    public boolean setSubject(String newSubject)
    {
        if(isSubjectValid(newSubject)) {
            subject = newSubject;
            return true;
        } else
            return false;
    }
    
    private static boolean isSubjectValid(String subject)
    {
        String subjectUp = subject.toUpperCase();
        if(Arrays.asList(Subject.getSubjectOptions()).contains(subjectUp))
            return true;
        else
            return false;
    }
    
    public void displayInfo()
    {
        System.out.println(name + "," + phoneNum + "," + subject);
    }
    
    public String toString()
    {
        return name + "," + phoneNum + "," + subject;
    }
    
    public static boolean isArgumentValid(String newName, String newPhoneNum, String newSubject)
    {
        return isNameValidReg(newName) && isPhoneValidReg(newPhoneNum) && isSubjectValid(newSubject);
    }
}
