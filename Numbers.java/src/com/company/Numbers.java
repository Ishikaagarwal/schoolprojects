package com.company;


/**
 *  Numbers.java
 *  The game of Numbers is played between a player and the
 *  computer.  First, the player chooses the maximum number of steps to be taken in
 *  each turn (chosen from 2 to 10).  Next, the player chooses the goal number
 *  (chosen from 5 times the max to 100).  The game then begins, with the player
 *  and computer alternating turns.  The starting number is 0.  The player advances
 *  the number from 1 to the max.  Then the computer advances the number from 1
 *  to the max.  This continues until the goal number is reached, and the player
 *  who arrives at the goal number is the loser.  See the sample game below.
 *
 *  Please enter the max value that a player can choose to move (from 2 to 10): 3
 *  Please enter the goal value (from 15 to 100): 26
 *  Position starts at 0.
 *  The player adds 3, moving to 3.  The computer adds 2, moving to 5.
 *  The player adds 1, moving to 6.  The computer adds 2, moving to 8.
 *  The player adds 3, moving to 11.  The computer adds 3, moving to 14.
 *  The player adds 3, moving to 17.  The computer adds 1, moving to 18.
 *  The player adds 2, moving to 20.  The computer adds 1, moving to 21.
 *  The player adds 2, moving to 23.  The computer adds 2, moving to 25.
 *  The player adds 1, moving to 26.  The computer is the winner.
 *
 *  @author Ishika
 *  @version 1.0
 *  @since 9/16/2016
 */

import java.util.Scanner;

public class Numbers
{
    /**    The goal value, to be entered by the user.  The player that arrives at this goal value loses.    */
    private int goal;

    /**    The maximum number of steps to be taken in a turn, to be chosen by the user.    */
    private int max;

    /**
     *  Creates a Numbers object, with goal and max initialized to 0.
     */
    public Numbers ( )
    {
        goal = max = 0;
    }

    /**
     *  Sets up and runs the game of Numbers.
     *  @param  args     An array of String arguments (not used here).
     */
    public static void main(String [] args)
    {
        Numbers play = new Numbers();
        play.getMaxRemove();
        play.getGoal();
        play.game();
    }

    /**
     *  Prompts the user for the max value that a player can move in a given turn.
     *  This input should be restricted from 2 to 10.
     */
    public void getMaxRemove ( )
    {
        do {
            try {
                max = Prompt.getInt("Please enter the max value that a player can choose to move", 2, 10);

//                Scanner myScan = new Scanner(System.in);
//                System.out.println("Please enter the max value that a player can choose to move (from 2 to 10): ");
//                max = myScan.nextInt();*/
            }
            catch(Exception e)
            {
            }
        } while(max < 2 || max > 10);
    }

    /**
     *  Prompts the user for the goal value, which is the "end value" for the game.
     *  This input should be restricted from (5 times the max) to 100.
     */
    public void getGoal ( )
    {

        do {
            try {
                goal = Prompt.getInt("Please enter the goal value", max * 5, 100);
//
//                Scanner myScan = new Scanner(System.in);
//                System.out.println("Please enter the goal value (from " + max * 5 + " to 100): ");
//                goal = myScan.nextInt();
            }
            catch(Exception e)
            {
            }
        } while(goal < max * 5 || goal > 100);
    }

    /**
     *  Plays a single game of Numbers.
     */
    public void game ( )
    {
        int num = 0, counter = 0;
        do
        {
            System.out.print("\nNumber: " + num + "\n");
            num += takePlayerTurn(num);
            counter++;
            if(num < goal)
            {
                num += takeComputerTurn(num);
                counter++;
            }
        }
        while(num < goal);
        declareWinner(counter);
    }

    /**
     *  The player takes a turn.  The number value is displayed, and the
     *  player is prompted to enter a number of steps to take, from 1 to
     *  the max (the player should not be allowed to add a value that would
     *  cause the number to exceed the goal).
     *  @param num        The current number value, to be increased by the player.
     *  @return           The new number value
     */
    public int takePlayerTurn(int num)
    {
        return Prompt.getInt("Enter a value to add to the total", 1, max);
    }

    /**
     *  The computer takes a turn.  The number value is displayed, and the
     *  computer chooses a number of steps to take, from 1 to
     *  the max (this number added should not cause the number to exceed the goal).
     *  @param num        The current number value, to be increased by the computer.
     *  @return           The new number value
     */
    public int takeComputerTurn(int num)
    {
        int returnValue = calculateUsingSuperSecretAlgorithm(num);

        System.out.print("\nNumber: " + num + "\n");
        System.out.println("Now, the computer takes a turn, and decides to add " + returnValue);
        return returnValue;
    }

    /**
     * This algorithm makes the best effort to make the computer win.
     * It tries to round up the remaining total to a multiple of max + 1
     *
     * @param num       The current total value of the game
     * @return          The number that the computer has derived from the algorithm
     **/
    private int calculateUsingSuperSecretAlgorithm(int num) {
        int returnValue = (goal - 1 - num) % (max + 1);

        if(returnValue == 0)
        {
            returnValue = 1;
        }
        return returnValue;
    }

    /**
     *  Declares the winner.
     *  @param counter        The number of turns (player + computer turns).
     */
    public void declareWinner(int counter)
    {
        if (counter % 2 == 0)
        {
            System.out.print("\n\nCONGRATULATIONS, you beat the computer!\n\n");
        }

        else
        {
            System.out.print("\n\nSorry, the computer won this time.  Better luck on your next try!\n\n");
        }
    }

}

