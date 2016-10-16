package com.company;

class BigGame extends Game {

    int play(int wager, int rollA, int rollB, int rollC){
        if(rollA + rollB + rollC >= 11 && !(rollA == rollB && rollB == rollC)){
            return wager;
        } else{
            return -1 * wager;
        }
    }

    BigGame(){
        gameName = "Go Big (sum >= 11, not a triple, 1 to 1)   |";
    }
}
