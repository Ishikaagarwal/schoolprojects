package com.company;

/**
 * Matador.java
 * In this game, the user will start with 200 dollars.
 * The user places a bet (a random number of dollars
 * from 1 to 10), then chooses a possible outcome for
 * the rolling of 3 6-sided dice:
 * (1) Any Triple (betting that all 3 dice will show the same number), at
 * 30 to 1 odds
 * (2) Go Big (betting that the sum of the dice will be 11 or higher, and
 * not a triple), at 1 to 1 odds
 * (3) Go Small (betting that the sum of the dice will be 10 or lower,
 * and not a triple), at 1 to 1 odds
 * (4) Go Extreme (betting that the sum of the dice will be less than 8
 * or greater than 12), at 1 to 1 odds
 * The dice are then rolled, and the player either wins or loses,
 * with the appropriate amount of money either added or subtracted
 * from the player's total.  The game is then repeated, and this
 * continues until the player winds up with 0 dollars.
 * The number of turns (games played) is then displayed
 * and the game terminates.
 *
 * @author Ishika
 * @version 1.0
 * @since 8/23/2016
 */
public class Matador {
    /**
     * Declare fields here.
     * int money will store the amount of money that the user has currently
     * int roundNum will store the round number
     * int wager will store the random number that is the wager of the user
     * String isTriple  will store whether or not a triple has been rolled
     * String gameType will store the type of game that will be played
     * Dice
     *  GameDieOne, GameDieTwo and GameDieThree are the dice used in the game (1 - 6)
     *  wagerDie is the dice rolled to find out the users wager (1 - 4)
     *  gameTypeDie is the dice rolled to find the type of game (1 - 10)
     */
    private int money, wager;
    private String isTriple, gameType;
    private Dice GameDieOne, GameDieTwo, GameDieThree, wagerDie, gameTypeDie;

    /**
     * Creates a Matador object, with three six-sided Dice, one
     * ten-sided die for the money bet, and a four-sided die
     * for the bet choice.  Sets the amount of money to 200 dollars.
     * Sets wager to zero
     */
    private Matador() {
        money = 200;
        wager = 0;
        isTriple = "NO";
        gameType = "";

        GameDieOne = new Dice();
        GameDieTwo = new Dice();
        GameDieThree = new Dice();
        wagerDie = new Dice(10);
        gameTypeDie = new Dice(4);

    }

    /**
     * Sets up and runs the rounds of Matador.
     *
     * @param args An array of String arguments (not used here).
     */
    public static void main(String[] args) {
        Matador run = new Matador();
        run.playGames();
    }

    /**
     * Plays all of the rounds of Matador, until the player has no money left.
     */
    private void playGames() {
        System.out.println("\n\n\n");
        do {
            System.out.println("+----------------------------------------------------------------+");
            System.out.printf("|  ROUND %5d                                                   |%n",GameDieOne.getRollCount());
            playASingleGame();
        }
        while (money > 0);
        System.out.println("+----------------------------------------------------------------+\n");
        System.out.println("\n\nSorry, but you know that the house always wins !\n\n\n\n\n ");
    }

    /**
     * Plays a single game of Matador.
     */
    private void playASingleGame() {
        findTypeOfGame();
        wager = findWager();
        int gameDieOne = GameDieOne.roll();
        int gameDieTwo = GameDieTwo.roll();
        int gameDieThree = GameDieThree.roll();
        String winStatus = findWinStatus(gameDieOne, gameDieTwo, gameDieThree);


        System.out.printf("|  Your money total:  $%4d                                      |%n",money);
        System.out.printf("|  Your wager      :  $%4d                                      |%n",wager);
        System.out.print("|  Your choice     :  ");
        System.out.println(gameType);
        //System.out.println("");
        //System.out.println("Go Small (sum <= 10, not a triple, 1 to 1) |");
        //System.out.println("Go Extreme (sum < 8 or sum > 12, 1 to 1)   |");
        System.out.printf("|  Roll            :%3d%3d%3d                                    |%n",gameDieOne, gameDieTwo, gameDieThree);
        System.out.printf("|  Sum             :  %-2d             +---------------+           |%n",gameDieOne + gameDieTwo + gameDieThree);
        System.out.print("|  A Triple        :  ");
        System.out.print(isTriple + "            ");
        //System.out.print("NO             ");
        System.out.println(winStatus);
        //System.out.println("|   YOU LOSE!   |           |");
        updateMoney(winStatus, wager);
        System.out.printf("|  New money total :  $%4d          +---------------+           |%n",money);
    }

    /**
     *  Split the work up into smaller methods.  Don't write all of your code in
     *  playASingleGame if you are looking to earn full credit.
     */


    /**
     * Will find out the type of game that the user will be betting for
     */

    private void findTypeOfGame() {
        int roll = gameTypeDie.roll();

        if (roll == 1) {
            gameType = "Any Triple (30 to 1)                       |";
            isTriple = "YES";
        } else if (roll == 2) {
            gameType = "Go Big (sum >= 11, not a triple, 1 to 1)   |";
            isTriple = "NO ";
        } else if (roll == 3) {
            gameType = "Go Small (sum <= 10, not a triple, 1 to 1) |";
            isTriple = "NO ";
        } else {
            gameType = "Go Extreme (sum < 8 or sum > 12, 1 to 1)   |";
            isTriple = "NO ";
        }

    }

    /**
     * findWager() will find the random number between 1 -10
     * Using the roll() method in the dice class, we find a randomNumber
     * between 1 and 4
     */
    private int findWager() {
        return wagerDie.roll();
    }

    /**
     * This method will, using the values of the dice and the gameType,
     * determine
     * if the user has won
     *
     * @param gameDieOne            the integer value of the first game dice
     * @param gameDieTwo            the integer value of the second game dice
     * @param gameDieThree          the integer value of the third game dice
     */
    private String findWinStatus(int gameDieOne, int gameDieTwo, int gameDieThree) {
        String returnValue = "";
        int sum = gameDieOne + gameDieTwo + gameDieThree;
        boolean isTripleExist = gameDieOne == gameDieTwo && gameDieTwo == gameDieThree;


        if (gameType.equals("Any Triple (30 to 1)                       |") && isTripleExist) {
            returnValue = "|   YOU WIN!    |           |";
        } else if (gameType.equals("Go Big (sum >= 11, not a triple, 1 to 1)   |") && (sum >= 11 && !isTripleExist) ) {
            returnValue = "|   YOU WIN!    |           |";
        } else if (gameType.equals("Go Small (sum <= 10, not a triple, 1 to 1) |") && (sum <= 10 && !isTripleExist)) {
            returnValue = "|   YOU WIN!    |           |";
        } else if (gameType.equals("Go Extreme (sum < 8 or sum > 12, 1 to 1)   |") && (sum < 8 || sum > 12)) {
            returnValue = "|   YOU WIN!    |           |";
        } else {
            returnValue = "|   YOU LOSE!   |           |";
        }

        return returnValue;

    }

    /**
     * this method will update the money value after
     * the user has rolled the three game dice
     *
     * @param winStatus             String value of either "you win" or "you lose"
     * @param wager                 contains the integer value of the wager for the user
     */
    private void updateMoney(String winStatus, int wager) {
        int newMoney = wager;
        boolean isWin = false;

        if(winStatus.equals("|   YOU WIN!    |           |")){
            isWin = true;
        } else{
            isWin = false;
        }

        if (gameType.equals("Any Triple (30 to 1)                       |")) {
            if(isWin){
                newMoney = wager * 30;
            } else{
                newMoney = wager * -1;
            }
        }

        else if (gameType.equals("Go Big (sum >= 11, not a triple, 1 to 1)   |")){
            if(!isWin){
                newMoney = wager * -1;
            }
        }

        else if(gameType.equals("Go Small (sum <= 10, not a triple, 1 to 1) |")){
            if(!isWin){
                newMoney = wager * -1;
            }
        }

        else if(gameType.equals("Go Extreme (sum < 8 or sum > 12, 1 to 1)   |")){
            if(!isWin){
                newMoney = wager * -1;
            }
        }

        money += newMoney;

        if(money < 0){
            money = 0;
        }
    }


}

