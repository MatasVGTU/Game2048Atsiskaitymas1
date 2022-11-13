package com.example.game2048;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class GameApp extends Application {
    @Override
    public void start(Stage stage){
        GameStatusController.setGameStatusEnum(GameStatusEnum.MAIN_MENU);

        DisplayController displayController = new DisplayController();
        KeyEvents oKeyEvents = new KeyEvents();

        Group root = new Group();
        Scene oScene = new Scene(root);
        stage.setScene(oScene);

        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add( canvas );
        GraphicsContext gc = canvas.getGraphicsContext2D();
        displayController.clearBoard(gc);
        displayController.displayStart(gc,canvas);
        stage.show();

            oScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {

                    if (GameOverCheck.gameOver()) GameStatusController.setGameStatusEnum(GameStatusEnum.ENDED);

                    if (GameStatusController.getGameStatusEnum() == GameStatusEnum.MAIN_MENU ){

                        displayController.clearBoard(gc);
                        displayController.displayStart(gc,canvas);

                        switch (keyEvent.getCode()) {
                            case SPACE:
                                oKeyEvents.startNewGame();
                                break;
                        }

                    }

                    else if (GameStatusController.getGameStatusEnum() == GameStatusEnum.ON_GOING){
                        displayController.clearBoard(gc);
                        displayController.displayBoard(gc);
                        Boxes.printAllBoxes();

                        switch (keyEvent.getCode()){
                            case UP:
                                oKeyEvents.eventUP();
                                break;
                            case DOWN:
                                oKeyEvents.eventDOWN();
                                break;
                            case RIGHT:
                                oKeyEvents.eventRIGHT();
                                break;
                            case LEFT:
                                oKeyEvents.eventLEFT();
                                break;
                            case SPACE:
                                oKeyEvents.eventSPACE();
                        }
                        displayController.clearBoard(gc);
                        displayController.displayBoard(gc);
                    }

                    else if (GameStatusController.getGameStatusEnum() == GameStatusEnum.ENDED){
                        displayController.clearBoard(gc);
                        displayController.displayBoard(gc);
                        displayController.gameOver(gc,canvas);
                        switch (keyEvent.getCode()){
                            case SPACE:
                                oKeyEvents.startNewGame();
                        }

                    }

                }
            });



    }

    public static void main(String[] args)
    {
        launch(args);
    }
}