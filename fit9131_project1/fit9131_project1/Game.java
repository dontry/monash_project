
/**
 * Write a description of class Game here.
 * This is a Guessing Lucky Number Project.
 * @author (Don) 
 * @version (0.8)
 */
import java.util.*;

public class Game
{
    /**
     * Class constants
     */
    private static final int RESULT_WON = 1;   //RESULT_WON means player make a correct guess.
    private static final int RESULT_CONSOLATION = 2; //RESULT_CONSOLATION means player's final guess is within 5 of lucky number
    private static final int RESULT_LOSS = 3;   //RESULT_LOSS means player's make a wrong guess.
    private static final int MAX_NUM = 100;  //The maximum number of lucky number
    private static final int MIN_NUM =  1;  //The minimun number of lucky number
    private static final int ROUND_COUNT = 3;   //The rounds player can play

    /**
     * Instance attributes
     */
    private LuckyNumberGenerator generator;
    private Player player;
    private Scanner in;
    private boolean isDebug; //Debug mode config 
    
    
    /**
     * Constructor for objects of class Game
     */
    public Game(boolean debugMode)  //The debug mode shows the luckyNumber
    {
        // initialise instance variables
       player = null;
       generator = new LuckyNumberGenerator(MIN_NUM, MAX_NUM);  
       in = new Scanner(System.in);
       isDebug = debugMode;
    }
    
    /**
     * The main body of Game
     */
    public boolean startGame() 
    {
        int option = 0;     //initialise the option
 
        clearTerminal();
        while (option != 5) {      //If the selected option is 5, then exit the game
            try{
                option = chooseOption();                
                switch(option){
                    case 1:
                        setNewPlayer();
                        break;
                    case 2:
                        playOneRound();
                        break;
                    case 3:
                        displayStatistics();
                        break;
                    case 4:
                        displayHelp();
                        break;
                    case 5:
                        exitGame();
                        System.out.println("Goodbye. Thank you for playing.");
                        break;
                    default:
                        System.out.println("Invalid choices. Please try again.");
                }
            }catch(NullPointerException e){
                if(player == null || player.getName().equals(""))
                    System.out.println(e.getMessage());
            }
        }
        return false;
    }
    
    /**
     * Display the options and get user's input
     */
    private int chooseOption()
    {
        
        System.out.println("\n\nWelcome to the Guessing Game");
        System.out.println("================================");
        System.out.println("(1)Change(or Set up) New Player");
        System.out.println("(2)Play One Round");
        System.out.println("(3)Display Player Wins Statistics");
        System.out.println("(4)Display Game Help");
        System.out.println("(5)Exit Game");
        System.out.print("Choose an option:");
        
        return in.nextInt();  //what if I want to deal with MismatchException ?
    }
   
    /**
     * Set up the new player
     */
    private void setNewPlayer() {
        System.out.print("Enter Player's Name:");
        in.nextLine();
        String name = in.nextLine();
        player = new Player(name);
    }
    

    /**
     * Option 2: play one round
     */
    private void playOneRound() 
    {
        if (player == null || player.getName().equals("")) 
            throw new NullPointerException("Error: player has not been set up!");
            
        LuckyNumberGenerator generator = new LuckyNumberGenerator(MIN_NUM, MAX_NUM);
        int luckyNumber = generator.createNumber();
        int round = ROUND_COUNT;
        int guessNumber = -999;
        boolean successful = false;
        
        do {
         if(round == ROUND_COUNT) {
            System.out.print("\nEnter a number between 1-100(up to 3 guesses):");
         }
         else {
            successful = checkNumber(luckyNumber, guessNumber);
         }
         guessNumber = in.nextInt();
         round--;
        } while(round > 0 && !successful);
        
        getResult(luckyNumber, guessNumber);
       
    }
    
    /**
     * check if the value of guessing number is equal to lucky number
     */
    private boolean checkNumber(int luckyNum, int guessNum) 
    {
        if(isDebug)
            System.out.println("The luckyNumber is:" + luckyNum);
            
        if(guessNum < MIN_NUM || guessNum > MAX_NUM) {
            System.out.print("Sorry, only numbers between " + MIN_NUM + "- " +
                              MAX_NUM + " are valid. Try again:");
            return false;
        } else if(guessNum < luckyNum) {
            System.out.print("Sorry, you need to go HIGHER:");
            return false;
        } else if(guessNum > luckyNum) {
            System.out.print("Sorry, you need to go LOWER:");
            return false;
        } else if(guessNum == luckyNum) {
           return true;
        }
        return false;
    }
    
    
    /**
     * Get the final guess result and gain award accordingly
     */
    private void getResult(int luckyNum, int guessNum)
    {
        System.out.println("\n\nThe Luck Number was:" + luckyNum + ", your final guess was:" + guessNum);
        int result;
        int award = 0;
        
        
        if(luckyNum == guessNum) {
                award = 10;
                result = RESULT_WON;
                player.incrementWin();
        }else if(Math.abs(luckyNum - guessNum) <= 5) {
                award = (int) (Math.random() * 5);
                result = RESULT_CONSOLATION;
                player.incrementWin();
       }else {
            award = -1;
            player.incrementLoss();
            result = RESULT_LOSS;
        }
        player.addAward(award);
        
        /**
         * Display the result depending on different situations
         */
        switch(result) {
            case RESULT_WON:
                   System.out.println("Congratulations: you WON $" + award);
                   break;
            case RESULT_CONSOLATION:
                   System.out.println("Congratulations: you WON a consolation of $" + award);
                   break;
            case RESULT_LOSS:
                   System.out.println("Sorry, better luck next time!");
        }
    }
    
    /**
     * Display the player statistics
     */
    private void displayStatistics() 
    {
        if(player == null || player.getName().equals("")) 
            throw new NullPointerException("Error: player has not been set up!");
            
        System.out.println("\nPlayer " + player.getName() + " has " + player.getWin() + " win(s) and " + player.getLoss() +
                           " loss(es) ==> Winning Percentage = " + String.format("%.2f", getWinPercentage()) + "%" );
        System.out.println("Total Winnings: $" + player.getAward());
    }
    
    /**
     * Display the game help
     */
    private void displayHelp() 
    {
        System.out.println("==================================");
        System.out.println("         Game help");
        System.out.println("a player to guess a number between 1-100, which will then be compared to a number (also between 1-100) randomly generated by the computer.\n"
          + "For each \"round\" of the game, the player will have 3 chances to guess the number. Correct guesses will win some money, while incorrect guesses will attract some penalties.");
    }
    
    /**
     * Exit the game and clear the data;
     */
    private void exitGame()
    {
        player = null;
        generator = null;
        clearTerminal();
    }
    
    /**
     * Caculate the player's winning percentage
     */
    private double getWinPercentage() 
    {
        int win = player.getWin();
        int loss = player.getLoss();
        
        if( win + loss == 0) 
            return 0;
        else 
            return ((double)win / (win + loss)) * 100;
    }
    
    private void clearTerminal()
    {
        System.out.print('\u000C');
    }
}
