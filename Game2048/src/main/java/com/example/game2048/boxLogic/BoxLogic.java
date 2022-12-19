package com.example.game2048.boxLogic;

import static com.example.game2048.enums.DirectionsEnum.*;

public class BoxLogic extends BoxMoveLogic implements BoxLogicInterface{

    private static BoxLogic instance;
    private BoxLogic(){}

    public static BoxLogic getInstance(){
        if (instance == null)
            instance = new BoxLogic();
        return instance;
    }

    public void moveRowsUp(){
        for (int y = 1; y < 4; y++){
            for (int x = 0; x < 4; x++){
                moveBox(UP,x,y);
            }
        }
    }

    public void moveRowsDown(){
        for (int y = 2; y >= 0; y--){
            for (int x = 0; x < 4; x++){
                moveBox(DOWN,x,y);
            }
        }
    }

    public void moveRowsLeft(){
        for (int y = 0; y < 4; y++){
            for (int x = 1; x < 4; x++){
                moveBox(LEFT,x,y);
            }
        }
    }

    public void moveRowsRight(){
        for (int y = 0; y < 4; y++){
            for (int x = 2; x >= 0; x--){
                moveBox(RIGHT,x,y);
            }
        }
    }

}
