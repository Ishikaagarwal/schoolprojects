package com.company;


class TripleGame extends Game {
    @Override
    int play(int wager, int rollA, int rollB, int rollC){
        if(rollA == rollB && rollB == rollC){
            return 30 * wager;
        } else{
            return -1 * wager;
        }
    }

    TripleGame(){
        gameName = "Any Triple (30 to 1)                       |";
    }
}
