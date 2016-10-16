package com.company;

class SmallGame extends Game {
    int play(int wager, int rollA, int rollB, int rollC){
        if(rollA + rollB + rollC <= 10 && !(rollA == rollB && rollB == rollC)){
            return wager;
        } else{
            return -1 * wager;
        }
    }


    SmallGame(){
        gameName = "Go Small (sum <= 10, not a triple, 1 to 1) |";
    }
}
