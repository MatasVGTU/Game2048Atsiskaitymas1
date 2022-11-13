package com.example.game2048;

import static com.example.game2048.DirectionsEnum.*;

public class BoxLogic {
    public void moveRowsUp(){
        for (int y = 1; y < 4; y++){
            for (int x = 0; x < 4; x++){
                Boxes.moveBox(UP,x,y);
            }
        }
    }

    public void moveRowsDown(){
        for (int y = 2; y >= 0; y--){
            for (int x = 0; x < 4; x++){
                Boxes.moveBox(DOWN,x,y);
            }
        }
    }

    public void moveRowsLeft(){
        for (int y = 0; y < 4; y++){
            for (int x = 1; x < 4; x++){
                Boxes.moveBox(LEFT,x,y);
            }
        }
    }

    public void moveRowsRight(){
        for (int y = 0; y < 4; y++){
            for (int x = 2; x >= 0; x--){
                Boxes.moveBox(RIGHT,x,y);
            }
        }
    }

}
