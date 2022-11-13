package com.example.game2048;

public class KeyEvents {
    BoxLogic oBoxLogic = new BoxLogic();
    public void eventUP(){
        Boxes.savePrevBox();
        oBoxLogic.moveRowsUp();
        Boxes.resetMergeStatus();
        if (Boxes.boxesValueChangeAfterMove()) Boxes.generateNewBoxVal();
    }

    public void eventDOWN() {
        Boxes.savePrevBox();
        oBoxLogic.moveRowsDown();
        Boxes.resetMergeStatus();
        if (Boxes.boxesValueChangeAfterMove()) Boxes.generateNewBoxVal();
    }

    public  void eventLEFT(){
        Boxes.savePrevBox();
        oBoxLogic.moveRowsLeft();
        Boxes.resetMergeStatus();
        if (Boxes.boxesValueChangeAfterMove()) Boxes.generateNewBoxVal();
    }

    public void eventRIGHT(){
        Boxes.savePrevBox();
        oBoxLogic.moveRowsRight();
        Boxes.resetMergeStatus();
        if (Boxes.boxesValueChangeAfterMove()) Boxes.generateNewBoxVal();
    }

    public void eventSPACE(){
        Boxes.resetBoxes();
        Boxes.generateNewBoxVal();
    }

    public void startNewGame() {
        Boxes.resetBoxes();
        Boxes.resetMergeStatus();
        Boxes.generateNewBoxVal();
        GameStatusController.setGameStatusEnum(GameStatusEnum.ON_GOING);

    }
}
