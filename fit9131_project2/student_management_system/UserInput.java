import java.util.Scanner;

/**
 * A class to handle user input
 * 
 * @author Dong Cai
 * @version 2016.10.4
 */


public class UserInput
{
    private Scanner in;

    /**
     * Constructor for objects of class userInput
     * Initializing scanner object
     */
    public UserInput()
    {
        in = new Scanner(System.in);
    }

    /**
     * Get user input line.
     * @return user input line.
     */
    public String getLine()
    {
        return in.nextLine();
    }
    
    /**
     * Get user input integer.
     * @return user input integer.
     */
    public int getInt()
    {
        return in.nextInt();
    }
}
