package com.example.game2048.boxLogic;

import com.example.game2048.enums.DirectionsEnum;
import static com.example.game2048.enums.DirectionsEnum.*;

public class BoxMoveLogic extends BoxMergeLogic{

    protected void moveBox(DirectionsEnum dir, int x, int y){

        if (dir == UP){
            moveBoxUp(x, y);
        }
        else if (dir == DOWN){
            moveBoxDown(x, y);
        }
        else if (dir == LEFT){
            moveBoxLeft(x, y);
        }
        else if (dir == RIGHT){
            moveBoxRight(x, y);
        }

    }

    protected void moveBoxUp(int x, int y) {

        while (y > 0){
            if (currBox[y -1][x] == 0){
                currBox[y -1][x] = currBox[y][x];
                currBox[y][x] = 0;
                y--;
            }
            else if(currBox[y -1][x] == currBox[y][x]){
                mergeBoxes(UP, x, y);
                break;
            }
            else break;
        }

    }

    protected void moveBoxDown(int x, int y) {

        while (y < 3){
            if (currBox[y +1][x] == 0){
                currBox[y +1][x] = currBox[y][x];
                currBox[y][x] = 0;
                y++;
            }
            else if(currBox[y +1][x] == currBox[y][x]){
                mergeBoxes(DOWN, x, y);
                break;
            }
            else break;
        }

    }

    protected void moveBoxLeft(int x, int y) {

        while (x > 0){
            if (currBox[y][x -1] == 0){
                currBox[y][x -1] = currBox[y][x];
                currBox[y][x] = 0;
                x--;
            }
            else if(currBox[y][x -1] == currBox[y][x]){
                mergeBoxes(LEFT, x, y);
                break;
            }
            else break;
        }

    }

    protected void moveBoxRight(int x, int y) {

        while(x < 3){
            if (currBox[y][x +1] == 0){
                currBox[y][x +1] = currBox[y][x];
                currBox[y][x] = 0;
                x++;
            }
            else if(currBox[y][x +1] == currBox[y][x]){
                mergeBoxes(RIGHT, x, y);
                break;
            }
            else break;
        }

    }

}
