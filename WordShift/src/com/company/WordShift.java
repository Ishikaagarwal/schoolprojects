package com.company;

/**
 * WordShift.java
 * Plays the game of WordShift(TM).  First, the user is prompted
 * for two words of the same length (from 3 to 8 characters long).
 * These words are checked for length (3 to 8, and same length),
 * and to make sure that they are words (contain letters only and
 * exist in words.txt).  Then, the user is asked to attempt to
 * take steps to move from the first word to the second word, by
 * creating new words, changing only one letter at a time to
 * create a new word.  Each time the user enters a word, it should
 * be checked.  For example, the user may enter the words "cat"
 * and "dog", and then progress from "cat" to "cot", then "cot"
 * to "dot", and finally "dot" to "dog" to complete the shift.
 * Some other examples include:
 * tame to gift, tame -> take -> lake -> like -> life -> lift -> gift
 * tray to grin, tray -> trap -> trip -> grip -> grin
 * @author Ishika
 * @version 1.0
 * @since 9/13/2016
 */

public class WordShift extends OpenFile
{
    /**  The starting String. */
    private String start;

    /**  The current String. */
    private String current;

    /** Stores all the words from words.txt into this String*/
    private String dictionary;

    /**
     * Creates a WordShift object, creating
     * default String objects for the words to
     * be used in the game.
     */
    private WordShift ( ) {

        try {
            dictionary = " " + OpenFile.readFile("words.txt") + " ";
        } catch(Exception e){
            System.out.println("words.txt could not be read, or even found.");
        }

        /*  The ending String. */
        String end;
        do {
            start = findString("\nPlease enter the starting word, from 3 to 8 letters long        -> ");
            end = findString("\nPlease enter the ending word, and it must be " + start.length() + " letters long     -> ");
        }
        while(!isValidInput(start, end));
        current = start;
        String trail = start;
        int round = 1;

        do {
            System.out.print("\n\nRound " + round + ",  Current Word: " + current + "\n\n");
            String transition = getTransition();
            current = transition;
            trail += " -> " + transition;
            round++;
        }while(!current.equals(end) && round <= 25);

        if(round > 25)
        {
            System.out.println("Sorry, but you weren't able to complete the shifts in 25 steps.\n");
        }

        else
        {
            System.out.println(trail);
            System.out.println("Congratulations, you completed the word shift in " + (round - 1) + " steps!");
        }
    }

    private String getTransition() {
        String transition;
        do {
            transition = findString("Enter a new word, differing by one letter from the current word -> ");
        } while(!isTransitionValid(transition));
        return transition;
    }

    private boolean isValidInput(String start, String end) {
        return isValid(start) && isValid(end) && (start.length() == end.length());
    }

    /**
     *  Sets up and runs the game of WordShift.
     *  @param  args     An array of String arguments (not used here).
     */
    public static void main (String [] args)
    {
        new WordShift();
    }

    private static String findString(String askPhrase)
    {
        return Prompt.getString(askPhrase);
    }

    private boolean isValid(String word)
    {
        if (word.length() < 3 || word.length() > 8) {
            return false;
        }

        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) < 'a' || word.charAt(i) > 'z')
            {
                return false;
            }
        }

        if (dictionary.indexOf(" " + word + " ") < 0){
            return false;
        }

        return true;
    }

    private boolean isTransitionValid(String transition) {
        if (!isValid(transition) || transition.length() != start.length()){
            return false;
        }

        int counter = 0;
        for(int i = 0; i < current.length(); i++)
        {
            if(current.charAt(i) != transition.charAt(i))
            {
                counter++;
            }
        }
        return counter == 1;
    }
}