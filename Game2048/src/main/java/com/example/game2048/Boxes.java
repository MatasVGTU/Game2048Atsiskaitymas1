package com.example.game2048;
import com.example.game2048.enums.GameStatusEnum;
import com.example.game2048.gameStatus.GameStatusController;

import java.util.concurrent.ThreadLocalRandom;

public class Boxes {

    private static Boxes instance;
    private Boxes(){}
    private int currBox[][] = {
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
    };
    private int prevBox[][] = {
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
    };
    private boolean merged[][] = {
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false}
    };

    public boolean generateNewBoxVal(){

        boolean bFreeSpaceExists = emptyBoxExists();

        if (!bFreeSpaceExists){
            GameStatusController gameStatusController = GameStatusController.getInstance();
            gameStatusController.setGameStatusEnum(GameStatusEnum.GAME_OVER);
        }

        while (bFreeSpaceExists){
            int randomX = ThreadLocalRandom.current().nextInt(0, 4);
            int randomY = ThreadLocalRandom.current().nextInt(0, 4);

            if (currBox[randomX][randomY] == 0){
                currBox[randomX][randomY] = 2;
                break;
            }
        }
        return bFreeSpaceExists;
    }

    public void resetBoxes(){
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                currBox[y][x] = 0;
            }
        }
    }

    public void resetMergeStatus(){

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                merged[i][j] = false;
            }
        }
    }

    public int calcscore(){
        int score = 0;

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                score += currBox[y][x];
            }
        }
        return score;
    }

    public boolean boxesValueChangeAfterMove(){

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                 if (prevBox[y][x] != currBox[y][x])
                    return true;
            }
        }
        return false;

    }

    public void savePrevBox(){
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                prevBox[y][x] = currBox[y][x];
            }
        }
    }

    public boolean emptyBoxExists(){

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (currBox[y][x] == 0)
                    return true;
            }
        }

        return false;
    }

    public void setCurrBox(int[][] currBox) {
        this.currBox = currBox;
    }

    public int[][] getCurrBox() {
        return currBox;
    }

    public boolean[][] getMerged() {
        return this.merged;
    }

    public int getBoxVal(int x, int y) {
        return currBox[x][y];
    }

    public static Boxes getInstance(){
        if (instance == null)
            instance = new Boxes();
        return instance;
    }

}
