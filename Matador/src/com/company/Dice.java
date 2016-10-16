package com.company;

/**
 *  Dice.java
 *  Simulates a single die.  An instance of the Dice class
 *  has a number of sides, a roll count, and a face value
 *  (last rolled value).  Two constructors are included,
 *  along with getter and setter methods.
 *  @author Ishika
 *  @version 1.0
 *  @since 8/20/2015
 */
class Dice
{
    /**  The number of sides for the Dice object. */
    private int numSides;


    /**
     *  Creates a Dice object, with 6 sides, roll count
     *  set to 0, and value set to flag of -1.
     */
    Dice ()
    {
        this(6);
    }

    /**
     *  Creates a Dice object, with n sides, roll count
     *  set to 0, and value set to flag of -1.
     *  @param n        The number of sides for this Dice object.
     */
    Dice (int n)
    {
        numSides = n;
    }

    /**
     *  Rolls the die (Dice object).  The roll count is increased by 1,
     *  and the value is set equal to a random int value from 1 to numSides.
     *  @return         The new face value rolled.
     */
    int roll ( )
    {
        return (int)(Math.random() * numSides) + 1;
    }
}
