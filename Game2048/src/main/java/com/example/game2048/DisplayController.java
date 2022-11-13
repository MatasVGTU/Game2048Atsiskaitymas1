package com.example.game2048;


import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Camera;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class DisplayController {
    public Label lbl;
    Boxes oBox= new Boxes();
    BoxColorManager oBoxColorManager = new BoxColorManager();

   public void displayBoard(GraphicsContext gc){

       for (int y = 0; y < 4; y++){
           for (int x = 0; x < 4; x++){

               String lblstr = (Integer.toString(oBox.getBoxVal(x,y)));
               gc.setFill(oBoxColorManager.getColor(x,y));
               gc.setFont(Font.font(25));
               gc.fillText( lblstr, 50+y*100, 50+x*100);
           }
       }

   }

   public void clearBoard(GraphicsContext gc){
       gc.setFill( Color.BLACK);
       gc.fillRect(0,0, 512,512);
   }

   public void displayStart(GraphicsContext gc, Canvas canvas){
       gc.setFill(Color.WHITE);
       gc.setFont(Font.font(35));
       String greetingStr = "Press SPACE to start";
       gc.setTextAlign(TextAlignment.CENTER);
       gc.fillText( greetingStr, canvas.getWidth()/2 , canvas.getHeight()/2);
   }

    public void gameOver(GraphicsContext gc, Canvas canvas){
        gc.setFill(Color.RED);
        gc.setFont(Font.font(24));
        String greetingStr = "press SPACE to restart! Your score: " + Boxes.calcscore();
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText( greetingStr, canvas.getWidth()/2 , (canvas.getHeight()*7)/8);
    }

}
