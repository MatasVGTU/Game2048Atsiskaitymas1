package com.example.game2048.display;
import com.example.game2048.Boxes;
import com.example.game2048.display.BoxColorManager;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class DisplayController {
    Boxes boxes = Boxes.getInstance();
    BoxColorManager boxColorManager = new BoxColorManager();

   public void displayBoard(GraphicsContext gc){

       for (int y = 0; y < 4; y++){
           for (int x = 0; x < 4; x++){
               String labelText = (Integer.toString(boxes.getBoxVal(x,y)));
               gc.setFill(boxColorManager.getColor(x,y));
               gc.setFont(Font.font(25));
               gc.fillText(labelText, 60+y*100, 60+x*100);

               gc.setLineWidth(4);
               gc.setStroke(Color.WHITE);
               gc.strokeRect(10+y*100, 10+x*100, 100, 100);
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
        String greetingStr = "press SPACE to restart! Your score: " + boxes.calcscore();
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText( greetingStr, canvas.getWidth()/2 , (canvas.getHeight()*7)/8);

    }

}
