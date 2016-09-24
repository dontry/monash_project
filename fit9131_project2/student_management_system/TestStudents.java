
/**
 * Write a description of class TestStudents here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import static org.junit.Assert.*;

public class TestStudents
{
    private final static String MSG_CORRECT_NAME = "TEST: Correct student name.";
    private final static String MSG_BLANK_NAME =  "TEST: Invalid blank name.";
    private final static String MSG_ILLEGAL_DIGIT_NAME = "TEST: Invalid name contain illegal character.";
    private final static String MSG_NOSPACE_NAME = "TEST: Invalid name contains no space.";
    private final static String MSG_CORRECT_PHONUM = "TEST: Correct phone number.";
    private final static String MSG_BLANK_PHONUM = "TEST: Invalid blank phone number.";
    private final static String MSG_NOT_NUMERIC_PHONUM = "TEST: Invalid phone number not numeric.";
    private final static String MSG_LENGTH_PHONUM = "TEST: Invalid phone number is not equal to required length.";
    private final static String MSG_INITIAL_DIGIT_PHONUM = "TEST: Invalid phone number with incorrect initial digit.";
    private final static String MSG_CORRECT_SUBJECT = "TEST: Correct subject.";
    private final static String MSG_INCORRECT_SUBJECT = "TEST: Incorrect subject.";
    private final static String MSG_CORRECT_STUDENT = "TEST: Correct student.";
    private final static String MSG_TEST_PASSED = "  -- passed";
    private final static String MSG_TEST_FAILED = "  -- failed";
//  private final static String MSG_UNEXPECTED_OUTPUT = "Unexpected output.";
    /**
     * Constructor for objects of class TestStudents
     */
    Student student;
    public TestStudents() {
        clearTerminal();
        student = new Student("","","");
    }
   
    private void testStudNameCorrect()
    {
        String studName = "William Smith";
        try {
            assertTrue(MSG_CORRECT_NAME, student.setName(studName));
            System.out.println(MSG_CORRECT_NAME + MSG_TEST_PASSED);
        } catch(AssertionError err) {
            System.out.println(err.getMessage() + MSG_TEST_FAILED);
        }
    }
    
    private void testStudNameBlank()
    {
       String studName = "";
       try {
           assertFalse(MSG_BLANK_NAME, student.setName(studName));
           System.out.println(MSG_BLANK_NAME + MSG_TEST_PASSED);
       } catch(AssertionError err) {
           System.out.println(err.getMessage() + MSG_TEST_FAILED);
       }
    }
    
    private void testStudNameIllegalDigit()
    {
        String studName = "William123 Smith";
        try {
             assertFalse(MSG_ILLEGAL_DIGIT_NAME, student.setName(studName));
             System.out.println(MSG_ILLEGAL_DIGIT_NAME + MSG_TEST_PASSED);
        } catch(AssertionError err) {
            System.out.println(err.getMessage() + MSG_TEST_FAILED);
        }
       
    }
    
    private void testStudNameNoSpace()
    {
        String studName = "WilliamSmith";
        try {
            assertFalse(MSG_NOSPACE_NAME, student.setName(studName));
            System.out.println(MSG_NOSPACE_NAME + MSG_TEST_PASSED);
        } catch(AssertionError err) {
            System.out.println(err.getMessage() + MSG_TEST_FAILED);
        }
    }
    
    public void testName()
    {
        testStudNameCorrect();
        testStudNameBlank();
        testStudNameIllegalDigit();
        testStudNameNoSpace();     
    }
    
    private void testPhoneNumCorrect()
    {
        String phoneNum = "912345678";
        try {
            assertTrue(MSG_CORRECT_PHONUM, student.setPhoneNum(phoneNum));
            System.out.println(MSG_CORRECT_PHONUM + MSG_TEST_PASSED);
        } catch(AssertionError err) {
            System.out.println(err.getMessage() + MSG_TEST_FAILED);
        }
    }
    
    private void testPhoneNumBlank()
    {
        String phoneNum = "";
        try {
            assertFalse(MSG_BLANK_PHONUM, student.setPhoneNum(phoneNum));
            System.out.println(MSG_BLANK_PHONUM + MSG_TEST_PASSED);
        } catch(AssertionError err) {
            System.out.println(err.getMessage() + MSG_TEST_FAILED);
        }
    }
    
    private void testPhoneNumNumeric()
    {
        String phoneNum = "s13^22328";
        try {
            assertFalse(MSG_NOT_NUMERIC_PHONUM, student.setPhoneNum(phoneNum));
            System.out.println(MSG_NOT_NUMERIC_PHONUM + MSG_TEST_PASSED);
        } catch(AssertionError err) {
            System.out.println(err.getMessage() + MSG_TEST_FAILED);
        }
    }
    
    private void testPhoneNumLength()
    {
        String phoneNum = "92232";
        try {
            assertFalse(MSG_LENGTH_PHONUM, student.setPhoneNum(phoneNum));
            System.out.println(MSG_LENGTH_PHONUM + MSG_TEST_PASSED);
        } catch(AssertionError err) {
            System.out.println(err.getMessage() + MSG_TEST_FAILED);
        }
    }
    
    private void testPhoneNumInitial()
    {
        String phoneNum = "499994448";
        try {
            assertFalse(MSG_INITIAL_DIGIT_PHONUM, student.setPhoneNum(phoneNum));
            System.out.println(MSG_INITIAL_DIGIT_PHONUM + MSG_TEST_PASSED);
        } catch(AssertionError err) {
            System.out.println(err.getMessage() + MSG_TEST_FAILED);
        }
    }
    
    public void testPhoneNum()
    {
        testPhoneNumCorrect();
        testPhoneNumBlank();
        testPhoneNumNumeric();
        testPhoneNumLength();
        testPhoneNumInitial();
    }
    
    private void testSubjectCorrect()
    {
        String subject = "Math";
        try {
            assertTrue(MSG_CORRECT_SUBJECT, student.setSubject(subject));
            System.out.println(MSG_CORRECT_SUBJECT + MSG_TEST_PASSED);
        } catch(AssertionError err) {
            System.out.println(err.getMessage() + MSG_TEST_FAILED);
        }
    }
        
    private void testSubjectIncorrect()
    {
        String subject = "Art";
        try {
            assertFalse(MSG_INCORRECT_SUBJECT, student.setSubject(subject));
            System.out.println(MSG_INCORRECT_SUBJECT + MSG_TEST_PASSED);
        } catch(AssertionError err) {
            System.out.println(err.getMessage() + MSG_TEST_FAILED);
        }
    }
    
    public void testSubject()
    {
        testSubjectCorrect();
        testSubjectIncorrect();
    }
    
    public void testStudentCorrect()
    {
        String name = "William Smith";
        String phoneNum = "912345678";
        String subject = "Math";
        
        try {
            new Student(name, phoneNum, subject);
            System.out.println(MSG_CORRECT_STUDENT + MSG_TEST_PASSED);
        } catch(Exception ex) {
            System.out.println(ex.getMessage() + MSG_TEST_FAILED);
        }
    }
    
    public void overallTest()
    {
        testName();
        testPhoneNum();
        testSubject();
    }
    
    public void clearTerminal()
    {
        System.out.print('\u000C');
    }
}
