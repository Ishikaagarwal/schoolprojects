package com.company;


class ExtremeGame extends Game {

    int play(int wager, int rollA, int rollB, int rollC){

        int sum = rollA + rollB + rollC;

        if(sum < 8 || sum > 12){
            return wager;
        } else{
            return -1 * wager;
        }
    }


    ExtremeGame(){
        gameName = "Go Extreme (sum < 8 or sum > 12, 1 to 1)   |";
    }
}
