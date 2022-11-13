package com.example.game2048;

import javafx.scene.paint.Color;

public class BoxColorManager {

    static Boxes oBox = new Boxes();

    public static Color getColor(int i, int j){
        int iBoxVal = oBox.getBoxVal(i,j);
        int iCol = log(iBoxVal,2);
        switch (iCol){
            case 1:
                return Color.GRAY;
            case 2:
                return Color.DARKGRAY;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.ORANGE;
            case 5:
                return Color.DARKORANGE;
            case 6:
                return Color.RED;
            case 7:
                return Color.DARKRED;
            case 8:
                return Color.PINK;
            case 9:
                return Color.DEEPPINK;
            case 10:
                return Color.PURPLE;
            case 11:
                return Color.MEDIUMPURPLE;
        }
        return Color.BLACK;
    }

    private static int log(int x, int b) {
        return (int) (Math.log(x) / Math.log(b));
    }

}
