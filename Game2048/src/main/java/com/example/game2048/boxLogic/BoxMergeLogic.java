package com.example.game2048.boxLogic;

import com.example.game2048.enums.DirectionsEnum;
import static com.example.game2048.enums.DirectionsEnum.*;

public class BoxMergeLogic implements BoxLogicInterface{

    public void mergeBoxes(DirectionsEnum dir, int x, int y) {

        if (dir == UP)
            mergeBoxesUp(x, y);
        else if (dir == DOWN)
            mergeBoxesDown(x, y);
        else if (dir == LEFT)
            mergeBoxesLeft(x, y);
        else if (dir == RIGHT)
            mergeBoxesRight(x, y);

    }

    private void mergeBoxesUp(int x, int y) {

        if (currBox[y][x] == currBox[y - 1][x] && !merged[y - 1][x]){
            merged[y - 1][x] = true;
            currBox[y - 1][x] *= 2;
            currBox[y][x] = 0;
        }

    }

    private void mergeBoxesDown(int x, int y) {

        if (currBox[y][x] == currBox[y + 1][x] && !merged[y + 1][x]){
            merged[y + 1][x] = true;
            currBox[y + 1][x] *= 2;
            currBox[y][x] = 0;
        }

    }

    private void mergeBoxesLeft(int x, int y) {

        if (currBox[y][x] == currBox[y][x - 1] && !merged[y][x - 1]){
            merged[y][x - 1] = true;
            currBox[y][x - 1] *= 2;
            currBox[y][x] = 0;
        }

    }

    private void mergeBoxesRight(int x, int y) {

        if (currBox[y][x] == currBox[y][x + 1] && !merged[y][x + 1]){
            merged[y][x + 1] = true;
            currBox[y][x + 1] *= 2;
            currBox[y][x] = 0;
        }

    }

    public boolean canMergeBoxes(DirectionsEnum dir, int x, int y){

        switch (dir){
            case UP:
                if (currBox[y][x] == currBox[y - 1][x] && !merged[y - 1][x]){
                    return true;
                }
                break;
            case DOWN:
                if (currBox[y][x] == currBox[y + 1][x] && !merged[y + 1][x]){
                    return true;
                }
                break;
            case LEFT:
                if (currBox[y][x] == currBox[y][x - 1] && !merged[y][x - 1]){
                    return true;
                }
                break;
            case RIGHT:
                if (currBox[y][x] == currBox[y][x + 1] && !merged[y][x + 1]){
                    return true;
                }
                break;
        }
        return false;
    }

}
