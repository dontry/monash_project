
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Increment loss count
     */
    public void incrementLoss()
    {
        loss++;
    }
    
    /**
     * Increment win count
     */
    public void incrementWin()
    {
        win++;
    }
    
    /**
     * Change player's award according to result
     */
    public void addAward(int a)
    {
        award += a;
        if(award < 0) {
            award = 0;
        }
    }
    
    
}
