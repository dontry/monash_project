
/**
 * A class extends from exception which is for invalid argument exception.
 * 
 * @author Dong Cai
 * @version 2016.10.5
 */
public class InvalidArgumentException extends Exception
{
    // instance variables - replace the example below with your own
    private String argument;

    /**
     * Constructor for objects of class InvalidArgumentException
     * Perform initialization of invalid argument name.
     */
    public InvalidArgumentException(String arg)
    {
        // initialise instance variables
        argument = arg;
    }

    /**
     * Get exception message.
     * @return message.
     */
    public String getMessage() {
        return "The argument " + argument + " is invalid.";
    }
}
