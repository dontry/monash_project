
/**
 * Write a description of class userInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class UserInput
{
    // instance variables - replace the example below with your own
    private Scanner in;

    /**
     * Constructor for objects of class userInput
     */
    public UserInput()
    {
        in = new Scanner(System.in);
    }

    public String getLine()
    {
        return in.nextLine();
    }
    
    public int getInt()
    {
        return in.nextInt();
    }
}
