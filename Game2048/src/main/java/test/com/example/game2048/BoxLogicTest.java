package test.com.example.game2048;

import com.example.game2048.Boxes;
import com.example.game2048.boxLogic.BoxLogic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BoxLogicTest {

    private Boxes boxes;
    private BoxLogic boxLogic;

    @BeforeEach
    void befEachSetup(){
        boxes = Boxes.getInstance();
        boxLogic = BoxLogic.getInstance();
    }

    @Test
    void moveBoxUpTest() {

        int[][] result= {
                {2,4,4,2},
                {0,4,2,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        int[][] testdata= {
                {0,0,0,0},
                {0,2,4,0},
                {2,2,2,2},
                {0,4,0,0}
        };

        boxes.setCurrBox(testdata);
        boxLogic.moveRowsUp();
        assertArrayEquals(result, boxes.getCurrBox());
    }


    @Test
    void moveBoxDownTest() {

        int[][] result= {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,16},
                {32,4,8,2}
        };

        int[][] testdata= {
                {16,2,0,0},
                {16,0,0,16},
                {0,2,8,2},
                {0,0,0,0}
        };

        boxes.setCurrBox(testdata);
        boxLogic.moveRowsDown();
        assertArrayEquals(result, boxes.getCurrBox());
    }

    @Test
    void moveBoxRightTest() {

        int[][] result= {
                {0,0,0,2},
                {0,0,0,16},
                {0,0,16,2},
                {0,128,2,128}
        };

        int[][] testdata= {
                {2,0,0,0},
                {8,0,8,0},
                {0,16,0,2},
                {128,2,0,128}
        };

        boxes.setCurrBox(testdata);
        boxLogic.moveRowsRight();
        assertArrayEquals(result, boxes.getCurrBox());
    }

    @Test
    void moveBoxLeftTest() {

        int[][] result= {
                {4,4,0,0},
                {8,0,0,0},
                {2,8,0,0},
                {16,0,0,0}
        };

        int[][] testdata= {
                {2,2,2,2},
                {0,4,0,4},
                {0,0,2,8},
                {0,0,0,16}
        };

        boxes.setCurrBox(testdata);
        boxLogic.moveRowsLeft();
        assertArrayEquals(result, boxes.getCurrBox());
    }
}