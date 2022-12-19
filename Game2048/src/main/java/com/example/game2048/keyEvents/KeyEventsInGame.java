package com.example.game2048.keyEvents;
import com.example.game2048.boxLogic.BoxLogic;

public class KeyEventsInGame extends KeyEvents {
    private BoxLogic boxLogic = BoxLogic.getInstance();
    @Override
    public void eventUP(){
        boxes.savePrevBox();
        boxLogic.moveRowsUp();
        boxes.resetMergeStatus();
        if (boxes.boxesValueChangeAfterMove())
            boxes.generateNewBoxVal();
    }
    @Override
    public void eventDOWN() {
        boxes.savePrevBox();
        boxLogic.moveRowsDown();
        boxes.resetMergeStatus();
        if (boxes.boxesValueChangeAfterMove())
            boxes.generateNewBoxVal();
    }
    @Override
    public  void eventLEFT(){
        boxes.savePrevBox();
        boxLogic.moveRowsLeft();
        boxes.resetMergeStatus();
        if (boxes.boxesValueChangeAfterMove())
            boxes.generateNewBoxVal();
    }
    @Override
    public void eventRIGHT(){
        boxes.savePrevBox();
        boxLogic.moveRowsRight();
        boxes.resetMergeStatus();
        if (boxes.boxesValueChangeAfterMove())
            boxes.generateNewBoxVal();
    }
    @Override
    public void eventSPACE(){
        boxes.resetBoxes();
        boxes.generateNewBoxVal();
    }

}
