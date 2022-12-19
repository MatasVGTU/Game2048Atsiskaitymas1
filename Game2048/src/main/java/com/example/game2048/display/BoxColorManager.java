package com.example.game2048.display;

import com.example.game2048.Boxes;
import javafx.scene.paint.Color;

public class BoxColorManager {

    static Boxes oBox = Boxes.getInstance();

    public static Color getColor(int i, int j){
        int iBoxVal = oBox.getBoxVal(i,j);
        int iCol = log(iBoxVal,2);
        return switch (iCol) {
            case 1 -> Color.GRAY;
            case 2 -> Color.DARKGRAY;
            case 3 -> Color.YELLOW;
            case 4 -> Color.ORANGE;
            case 5 -> Color.DARKORANGE;
            case 6 -> Color.RED;
            case 7 -> Color.DARKRED;
            case 8 -> Color.PINK;
            case 9 -> Color.DEEPPINK;
            case 10 -> Color.PURPLE;
            case 11 -> Color.MEDIUMPURPLE;
            default -> Color.BLACK;
        };
    }

    private static int log(int x, int b) {
        return (int) (Math.log(x) / Math.log(b));
    }

}
