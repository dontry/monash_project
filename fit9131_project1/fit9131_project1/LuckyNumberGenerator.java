
/**
 * LuckNumberGenerator class is mainly
 * used for generating lucky number in 
 * the Game.
 * 
 * @author (Don) 
 * @version (0.9.2)
 */
import java.util.Random;

public class LuckyNumberGenerator
{
    private Random rand;
    private int min;
    private int max;
    /**
     * Constructor for objects of class LuckyNumberGenerator
     */
    public LuckyNumberGenerator()
    {
        // initialise instance variable
    }
    
    public LuckyNumberGenerator(int newMin, int newMax)
    {
        min = newMin;
        max = newMax;
        rand = new Random();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int createNumber()
    {
       int randomNum = rand.nextInt((max - min) + 1) + min;
       return randomNum;
    }
}
