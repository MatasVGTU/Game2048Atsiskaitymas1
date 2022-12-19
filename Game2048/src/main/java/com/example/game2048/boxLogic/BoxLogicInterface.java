package com.example.game2048.boxLogic;

import com.example.game2048.Boxes;

public interface BoxLogicInterface {

    Boxes boxes = Boxes.getInstance();
    public int[][] currBox = boxes.getCurrBox();
    public boolean[][] merged = boxes.getMerged();

}
