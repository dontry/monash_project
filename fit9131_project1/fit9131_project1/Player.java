
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
    private int money;

    /**
     * Constructor for objects of class Player
     */
    public Player(String playerName)
    {
        // initialise instance variables
        win = 0;
        loss = 0;
        money = 0;
        name = playerName;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
    public int getLoss() 
    {
        return loss;
    }
    
    public int getWin()
    {
        return win;
    }
    
    public double getPercentage() 
    {
        if( win + loss == 0) 
            return 0;
        else 
            return ((double)win / (win + loss)) * 100;
    }
    
    public int getMoney()
    {
        return money;
    }
    
    public void incrementLoss()
    {
        loss++;
    }
    
    public void incrementWin()
    {
        win++;
    }
    
    public void addMoney(int m)
    {
        money += m;
        if(money < 0) {
            money = 0;
        }
    }
    
    
}
