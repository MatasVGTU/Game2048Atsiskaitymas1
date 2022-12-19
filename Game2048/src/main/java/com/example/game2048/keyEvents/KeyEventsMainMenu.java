package com.example.game2048.keyEvents;

import com.example.game2048.enums.GameStatusEnum;
import com.example.game2048.gameStatus.GameStatusController;

public class KeyEventsMainMenu extends KeyEvents {

    @Override
    public void eventSPACE(){
        boxes.resetBoxes();
        boxes.resetMergeStatus();
        boxes.generateNewBoxVal();

        GameStatusController gameStatusController = GameStatusController.getInstance();
        gameStatusController.setGameStatusEnum(GameStatusEnum.ON_GOING);
    }


}
