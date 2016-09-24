
/**
 * Player class stores the player info
 * including how many times the player wins or loses,
 * how much award the player wins.
 * Other objects can get access its info by 
 * invoke its getter or setter functions.
 * 
 * @author (Don) 
 * @version (1.0.1)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private int win;
    private int loss;
    private String name;
    private int award;

    /**
     * Constructor for objects of class Player
     */
    public Player(String playerName)
    {
        // initialise instance variables
        win = 0;
        loss = 0;
        award = 0;
        name = playerName;
    }

    /**
     * Player's name getter
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
    /**
     * Player's loss getter
     */
    public int getLoss() 
    {
        return loss;
    }
    
    /**
     * Player's win getter
     */
    public int getWin()
    {
        return win;
    }
    

    /**
     * Player's award getter
     */
    public int getAward()
    {
        return award;
    }
    
    /**
     * Set loss count
     */
    public void setWins(int w)
    {
        win = w;
    }
    
    /**
     * Set win count
     */
    public void setLosses(int l)
    {
        loss = l;
    }
    
    /**
     * Set player award
     */
    public void setAward(int a)
    {
        award = a;
    }
}
