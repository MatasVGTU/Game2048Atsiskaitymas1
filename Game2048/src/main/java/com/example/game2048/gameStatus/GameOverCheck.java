package com.example.game2048.gameStatus;

import com.example.game2048.Boxes;
import com.example.game2048.boxLogic.BoxMergeLogic;

import static com.example.game2048.enums.DirectionsEnum.*;
import static com.example.game2048.enums.DirectionsEnum.RIGHT;

public class GameOverCheck extends BoxMergeLogic {

    Boxes boxes = Boxes.getInstance();

    public boolean gameOver(){

        if (boxes.emptyBoxExists())
            return false;
        else{
            if (canMergeUp())
                return false;
            if (canMergeDown())
                return false;
            if (canMergeRight())
                return false;
            if (canMergeLeft())
                return false;
        }
        return true;

    }

    private boolean canMergeUp(){

        for (int y = 1; y < 4; y++){
            for (int x = 0; x < 4; x++){
                if (canMergeBoxes(UP,x,y)) return true;
            }
        }

        return false;
    }

    private boolean canMergeDown(){

        for (int y = 2; y >= 0; y--){
            for (int x = 0; x < 4; x++){
                if (canMergeBoxes(DOWN,x,y)) return true;
            }
        }

        return false;
    }

    private boolean canMergeLeft(){

        for (int y = 0; y < 4; y++){
            for (int x = 1; x < 4; x++){
                if (canMergeBoxes(LEFT,x,y)) return true;
            }
        }

        return false;
    }

    private boolean canMergeRight(){

        for (int y = 0; y < 4; y++){
            for (int x = 2; x >= 0; x--){
                if (canMergeBoxes(RIGHT,x,y)) return true;
            }
        }

        return false;
    }



}
