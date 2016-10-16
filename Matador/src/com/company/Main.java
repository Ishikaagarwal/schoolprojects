package com.company;

public class Main {

    public static void main(String[] args) {
        int money = 200;
        Dice gameDieOne = new Dice();
        Dice gameDieTwo = new Dice();
        Dice gameDieThree = new Dice();
        Dice wagerDie = new Dice(10);
        Dice gameTypeDie = new Dice(4);

        Game[] games = {new TripleGame(), new SmallGame(), new ExtremeGame(), new BigGame()};

        int gameType, wager;
        int roundNum = 1;
        int rollA, rollB, rollC;

        while(money > 0){
            gameType = gameTypeDie.roll() - 1;
            wager = wagerDie.roll();

            if(wager > money){
                wager = money;
            }

            rollA = gameDieOne.roll();
            rollB = gameDieTwo.roll();
            rollC = gameDieThree.roll();

            int moneyWon = games[gameType].play(wager, rollA, rollB, rollC);

            print(roundNum, money, wager, games[gameType].gameName, rollA, rollB, rollC, moneyWon);

            money += moneyWon;
            roundNum++;

        }
    }

    private static void print(int round, int money, int wager, String game, int roll1, int roll2, int roll3, int moneyWon){
        System.out.println("+----------------------------------------------------------------+");
        System.out.printf("|  ROUND %5d                                                   |%n",round);
        System.out.printf("|  Your money total:  $%4d                                      |%n",money);
        System.out.printf("|  Your wager      :  $%4d                                      |%n",wager);
        System.out.print("|  Your choice     :  ");
        System.out.println(game);
        System.out.printf("|  Roll            :%3d%3d%3d                                    |%n",roll1, roll2, roll3);
        System.out.printf("|  Sum             :  %-2d             +---------------+           |%n",roll1 + roll2 + roll3);

        if(roll1 == roll2 && roll2 == roll3){
            System.out.print("|  A Triple        :  YES            ");
        } else{
            System.out.print("|  A Triple        :  NO             ");
        }


        if(moneyWon < 0){
            System.out.println("|   YOU LOSE!   |           |");
        } else{
            System.out.println("|   YOU WIN!    |           |");
        }

        System.out.printf("|  New money total :  $%4d          +---------------+           |%n",money + moneyWon);


        if(money + moneyWon <= 0) {
            System.out.println("+----------------------------------------------------------------+\n");
            System.out.println("\n\nSorry, but you know that the house always wins !\n\n\n\n\n ");
        }
    }
}
