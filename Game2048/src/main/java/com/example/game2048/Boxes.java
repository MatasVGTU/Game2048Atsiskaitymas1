package com.example.game2048;

import java.util.concurrent.ThreadLocalRandom;

import static com.example.game2048.DirectionsEnum.*;

public class Boxes {

    private static int currBox[][] = {{0,0,0,0}, {0,0,0,0} , {0,0,0,0}, {0,0,0,0}};
    private static int prevBox[][] = {{0,0,0,0}, {0,0,0,0} , {0,0,0,0}, {0,0,0,0}};
    private static boolean wasMerged[][] = {{false, false, false, false},{false, false, false, false},{false, false, false, false},{false, false, false, false}};

    public static int getBoxVal(int x, int y) {
        return currBox[x][y];
    }

    public static boolean generateNewBoxVal(){

        boolean bFreeSpaceExists = false;
        boolean bLoop = true;

        //check if there is new slot
        for (int i = 0 ; i < 4; i++){
            for (int j = 0 ; j < 4; j++){
                if (currBox[i][j] == 0){
                    bFreeSpaceExists = true;
                    break;
                }
            }
        }

        if (!bFreeSpaceExists) GameStatusController.setGameStatusEnum(GameStatusEnum.ENDED);

        while (bLoop && bFreeSpaceExists){
            int randomX = ThreadLocalRandom.current().nextInt(0, 4);
            int randomY = ThreadLocalRandom.current().nextInt(0, 4);

            if (currBox[randomX][randomY] == 0){
                currBox[randomX][randomY] = 2;
                bLoop = false;
            }

        }

        return bFreeSpaceExists;

        //printAllBoxes();
    }

    public static void printAllBoxes() {
        System.out.print("\n");
        System.out.print("---------------------------\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(currBox[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("---------------------------\n");
    }

    public static void resetBoxes(){
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                currBox[y][x] = 0;
            }
        }
    }

    public static void mergeBoxes(DirectionsEnum dir, int x, int y ){
        switch (dir){
            case UP:
                if (currBox[y][x] == currBox[y - 1][x] && !wasMerged[y - 1][x]){
                    wasMerged[y - 1][x] = true;
                    currBox[y - 1][x] *= 2;
                    currBox[y][x] = 0;

                }
            break;
            case DOWN:
                if (currBox[y][x] == currBox[y + 1][x] && !wasMerged[y + 1][x]){
                    wasMerged[y + 1][x] = true;
                    currBox[y + 1][x] *= 2;
                    currBox[y][x] = 0;

                }
            break;
            case LEFT:
                if (currBox[y][x] == currBox[y][x - 1] && !wasMerged[y][x - 1]){
                    wasMerged[y][x - 1] = true;
                    currBox[y][x - 1] *= 2;
                    currBox[y][x] = 0;

                }
            break;
            case RIGHT:
                if (currBox[y][x] == currBox[y][x + 1] && !wasMerged[y][x + 1]){
                    wasMerged[y][x + 1] = true;
                    currBox[y][x + 1] *= 2;
                    currBox[y][x] = 0;

                }
            break;
        }

    }

    public static void resetMergeStatus(){

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                wasMerged[i][j] = false;
            }
        }

    }

    public static void moveBox(DirectionsEnum dir, int x, int y){
        if (dir == UP){

            while (y > 0){
                if (currBox[y-1][x] == 0){
                    currBox[y-1][x] = currBox[y][x];
                    currBox[y][x] = 0;
                    y--;
                }
                else if(currBox[y-1][x] == currBox[y][x]){
                    mergeBoxes(UP, x,y);
                    break;
                }
                else break;
            }

        }
        else if (dir == DOWN){

            while (y < 3){
                if (currBox[y+1][x] == 0){
                    currBox[y+1][x] = currBox[y][x];
                    currBox[y][x] = 0;
                    y++;
                }
                else if(currBox[y+1][x] == currBox[y][x]){
                    mergeBoxes(DOWN, x,y);
                    break;
                }
                else break;
            }

        }
        else if (dir == LEFT){

            while (x > 0){
                if (currBox[y][x-1] == 0){
                    currBox[y][x-1] = currBox[y][x];
                    currBox[y][x] = 0;
                    x--;
                }
                else if(currBox[y][x-1] == currBox[y][x]){
                    mergeBoxes(LEFT, x,y);
                    break;
                }
                else break;
            }


        }
        else if (dir == RIGHT){

            while(x < 3){
                if (currBox[y][x+1] == 0){
                    currBox[y][x+1] = currBox[y][x];
                    currBox[y][x] = 0;
                    x++;
                }
                else if(currBox[y][x+1] == currBox[y][x]){
                    mergeBoxes(RIGHT, x,y);
                    break;
                }
                else break;
            }

        }
    }

    public static int calcscore(){
        int score = 0;

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                score += currBox[y][x];
            }
        }

        return score;
    }

    public static boolean boxesValueChangeAfterMove(){

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                 if (prevBox[y][x] != currBox[y][x])
                    return true;
            }
        }
        return false;

    }

    public static void savePrevBox(){
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                prevBox[y][x] = currBox[y][x];
            }
        }
    }

    public static boolean emptyBoxExists(){


        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (currBox[y][x] == 0)
                    return true;
            }
        }

        return false;
    }

    public static boolean canMergeBoxes(DirectionsEnum dir, int x, int y){

        switch (dir){
            case UP:
                if (currBox[y][x] == currBox[y - 1][x] && !wasMerged[y - 1][x]){
                    return true;
                }
                break;
            case DOWN:
                if (currBox[y][x] == currBox[y + 1][x] && !wasMerged[y + 1][x]){
                    return true;
                }
                break;
            case LEFT:
                if (currBox[y][x] == currBox[y][x - 1] && !wasMerged[y][x - 1]){
                    return true;
                }
                break;
            case RIGHT:
                if (currBox[y][x] == currBox[y][x + 1] && !wasMerged[y][x + 1]){
                    return true;
                }
                break;
        }
        return false;
    }







}
