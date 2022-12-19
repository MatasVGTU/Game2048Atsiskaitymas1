package com.example.game2048.gameStatus;

import com.example.game2048.enums.GameStatusEnum;
import com.example.game2048.keyEvents.KeyEvents;
import com.example.game2048.keyEvents.KeyEventsGameOver;
import com.example.game2048.keyEvents.KeyEventsInGame;
import com.example.game2048.keyEvents.KeyEventsMainMenu;

public class GameStatusController {

    private static GameStatusController instance;
    private static GameStatusEnum gameStatusEnum;
    public KeyEvents keyEvent = null;

    private GameStatusController(){}

    public static GameStatusController getInstance(){
        if (instance == null)
            instance = new GameStatusController();
        return instance;
    }

    public void setGameStatusEnum(GameStatusEnum ipGameStatusEnum) {
        gameStatusEnum = ipGameStatusEnum;
        switch (gameStatusEnum){
            case ON_GOING:
                keyEvent = new KeyEventsInGame();
                break;
            case MAIN_MENU:
                keyEvent = new KeyEventsMainMenu();
                break;
            case GAME_OVER:
                keyEvent = new KeyEventsGameOver();
                break;
        }
    }

    public KeyEvents getKeyEvent() {
        return keyEvent;
    }
    public GameStatusEnum getGameStatusEnum() {
        return gameStatusEnum;
    }

}
