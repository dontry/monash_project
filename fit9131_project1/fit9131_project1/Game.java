
/**
 * Write a description of class Game here.
 * This is a Guessing Lucky Number Project.
 * @author (Don) 
 * @version (0.8)
 */
import java.util.*;

public class Game
{
    // instance variables - replace the example below with your own
    private static final int TYPE_WON = 1;
    private static final int TYPE_CONSOLATION = 2;
    private static final int TYPE_LOSS = 3;
    private static final int MAX_NUM = 100;
    private static final int MIN_NUM =  1;

    /**
     * Constructor for objects of class Game
     */
    private int luckyNumber;
    private int guessNumber;
    private LuckyNumberGenerator generator;
    private Player player;
    private int round;
    private Scanner in;
    private boolean isDebug;
    
    
    public Game(boolean debugMode)
    {
        // initialise instance variables
       in = new Scanner(System.in);
       generator = new LuckyNumberGenerator(MIN_NUM, MAX_NUM);
       isDebug = debugMode;
    }
    
    
    public boolean startGame() {
        int option = 0;
        boolean isFirst = true;
        while(option != 5) {
            try {
                option = chooseOption(isFirst);
                isFirst = false;
                
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
                        System.out.println("Goodbye. Thank you for playing.");
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                }
            } catch(NullPointerException e) {
                if(player == null)
                System.out.println("Error: player has not been set up");
            }
        }
        return false;
    }
    
    
    private int chooseOption(boolean isInitial)
    {
        
        System.out.println("\n\nWelcome to the Guessing Game");
        System.out.println("================================");
        System.out.println("(1)Change(or Set up) New Player");
        System.out.println("(2)Play One Round");
        System.out.println("(3)Display Player Wins Statistics");
        System.out.println("(4)Display Game Help");
        System.out.println("(5)Exit Game");
        System.out.print("Choose an option:");
        return in.nextInt();
        
    }
   
    
    private void setNewPlayer() {
        System.out.print("Enter Player's Name:");
        in.nextLine();
        String name = in.nextLine();
        player = new Player(name);
    }
    
    private void playOneRound() {
        if(player == null) 
            throw new NullPointerException();
            
        luckyNumber = generator.createNumber();
        round = 3;
        boolean successful = false;
        
        System.out.print("\nEnter a number between 1-100(up to 3 guesses):");
        guessNumber = in.nextInt();
        round--;
        
        do {
         successful = determineNumber(guessNumber, luckyNumber);
         if(successful)
            break;
         guessNumber = in.nextInt();
         round--;
        }while(round > 0);
        
        getResult();
       
    }
    
    private boolean determineNumber(int number, int target) {
        if(isDebug)
            System.out.println("The luckyNumber is:" + target);
            
        if(number < MIN_NUM || number > MAX_NUM) {
            System.out.print("Sorry, only numbers between " + MIN_NUM + "- " +
                              MAX_NUM + " are valid. Try again:");
            return false;
        } else if(number < target) {
            System.out.print("Sorry, you need to go HIGHER:");
            return false;
        } else if(number > target) {
            System.out.print("Sorry, you need to go LOWER:");
            return false;
        } else if(number == target) {
           return true;
        }
        return false;
    }
    
    private void getResult(){
        System.out.println("\n\nThe Luck Number was:" + luckyNumber + ", your final guess was:" + guessNumber);
        int resultType = 0;
        int award = 0;
        if(Math.abs(luckyNumber - guessNumber) <= 5) {
            if(luckyNumber == guessNumber) {
                award = 10;
                resultType = TYPE_WON;
            }else {
                award = (int) (Math.random() * 5);
                resultType = TYPE_CONSOLATION;
            }
            player.incrementWin();
       }else {
            award = -1;
            player.incrementLoss();
            resultType = TYPE_LOSS;
        }
        player.addMoney(award);
        
        switch(resultType) {
            case TYPE_WON:
                   System.out.println("Congratulations: you WON $" + award);
                   break;
            case TYPE_CONSOLATION:
                   System.out.println("Congratulations: you WON a consolation of $" + award);
                   break;
            case TYPE_LOSS:
                   System.out.println("Sorry, better luck next time!");
        }
    }
    
    private void displayStatistics() {
        if(player == null) 
            throw new NullPointerException();
            
        System.out.println("\nPlayer " + player.getName() + " has " + player.getWin() + " win(s) and " + player.getLoss() +
                           " loss(es) ==> Winning Percentage = " + String.format("%.2f", player.getPercentage()) + "%" );
        System.out.println("Total Winnings: $" + player.getMoney());
    }
    
    private void displayHelp() {
        System.out.println("Game help.");
    }
}
