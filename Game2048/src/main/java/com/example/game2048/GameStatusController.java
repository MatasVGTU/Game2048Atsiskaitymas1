package com.example.game2048;

public class GameStatusController {

    private static GameStatusEnum gameStatusEnum;

    public static GameStatusEnum getGameStatusEnum() {
        return gameStatusEnum;
    }

    public static void setGameStatusEnum(GameStatusEnum ipGameStatusEnum) {
        gameStatusEnum = ipGameStatusEnum;
    }
}
