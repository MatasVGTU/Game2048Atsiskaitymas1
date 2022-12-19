package com.example.game2048;
import com.example.game2048.display.DisplayController;
import com.example.game2048.enums.GameStatusEnum;
import com.example.game2048.gameStatus.GameOverCheck;
import com.example.game2048.gameStatus.GameStatusController;
import com.example.game2048.keyEvents.KeyEvents;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class GameApp extends Application {

    private GameOverCheck gameOverCheck = new GameOverCheck();
    private GameStatusController gameStatusController = GameStatusController.getInstance();
    private KeyEvents keyEvents;

    @Override
    public void start(Stage stage){
        gameStatusController.setGameStatusEnum(GameStatusEnum.MAIN_MENU);
        keyEvents = gameStatusController.getKeyEvent();
        DisplayController displayController = new DisplayController();

        Group root = new Group();
        Scene oScene = new Scene(root);
        stage.setScene(oScene);

        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        displayController.clearBoard(gc);
        displayController.displayStart(gc,canvas);
        stage.show();

            oScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {

                    gameOverCheck();
                    displayController.clearBoard(gc);

                    if (gameStatusController.getGameStatusEnum() == GameStatusEnum.MAIN_MENU ){

                        displayController.displayStart(gc,canvas);

                        switch (keyEvent.getCode()) {
                            case SPACE:
                                keyEvents.eventSPACE();
                            break;
                        }

                        displayController.clearBoard(gc);
                        displayController.displayBoard(gc);

                    }
                    else if (gameStatusController.getGameStatusEnum() == GameStatusEnum.ON_GOING){

                        switch (keyEvent.getCode()){
                            case UP:
                                keyEvents.eventUP();
                                break;
                            case DOWN:
                                keyEvents.eventDOWN();
                                break;
                            case RIGHT:
                                keyEvents.eventRIGHT();
                                break;
                            case LEFT:
                                keyEvents.eventLEFT();
                                break;
                            case SPACE:
                                keyEvents.eventSPACE();
                        }

                        displayController.displayBoard(gc);

                    }
                    else if (gameStatusController.getGameStatusEnum() == GameStatusEnum.GAME_OVER){

                        switch (keyEvent.getCode()){
                            case SPACE:
                                keyEvents.eventSPACE();
                        }

                        displayController.displayBoard(gc);
                        displayController.gameOver(gc,canvas);

                    }

                    keyEvents = gameStatusController.getKeyEvent();
                }
            });
    }

    public void gameOverCheck(){
        if (gameOverCheck.gameOver())
            gameStatusController.setGameStatusEnum(GameStatusEnum.GAME_OVER);
    }

    public static void main(String[] args) {
        launch(args);
    }

}