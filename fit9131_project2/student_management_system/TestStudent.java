
/**
 * Write a description of class TestStudent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestStudent
{
    /**
     * Constructor for objects of class TestStudent
     */
    Student s1;
    public TestStudent()
    {
        try {
            Student s = new Student();
            s1 = new Student("William Smith", "987654321", "Maths English");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
