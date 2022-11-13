package com.example.game2048;

import static com.example.game2048.DirectionsEnum.*;
import static com.example.game2048.DirectionsEnum.RIGHT;

public class GameOverCheck {

    public static boolean gameOver(){
        if (Boxes.emptyBoxExists())
            return false;
        else{
            if (canMergeUp()) return false;
            if (canMergeDown()) return false;
            if (canMergeRight()) return false;
            if (canMergeLeft()) return false;
        }
        return true;
    }

    private static boolean canMergeUp(){

        for (int y = 1; y < 4; y++){
            for (int x = 0; x < 4; x++){
                if (Boxes.canMergeBoxes(UP,x,y)) return true;
            }
        }

        return false;
    }

    private static boolean canMergeDown(){

        for (int y = 2; y >= 0; y--){
            for (int x = 0; x < 4; x++){
                if (Boxes.canMergeBoxes(DOWN,x,y)) return true;
            }
        }

        return false;
    }

    private static boolean canMergeLeft(){

        for (int y = 0; y < 4; y++){
            for (int x = 1; x < 4; x++){
                if (Boxes.canMergeBoxes(LEFT,x,y)) return true;
            }
        }

        return false;
    }

    private static boolean canMergeRight(){

        for (int y = 0; y < 4; y++){
            for (int x = 2; x >= 0; x--){
                if (Boxes.canMergeBoxes(RIGHT,x,y)) return true;
            }
        }

        return false;
    }



}
