import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Derek on 7/19/16.
 */
public class pinningTest {

    //Test the functionality of method convertToInt of MainPanel.class
    //Because of the original convertToIntPre, we can not use the negative number to test.
    @Test
    public void testMaxValue() {
        MainPanel panel = new MainPanel(15);
        assertEquals(panel.convertToIntPre(Integer.MAX_VALUE - 1), panel.convertToInt(Integer.MAX_VALUE - 1));
    }

    @Test
    public void testRandomValue() {
        MainPanel panel = new MainPanel(15);
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int number = random.nextInt(Integer.MAX_VALUE);
            assertEquals(panel.convertToIntPre(number), panel.convertToInt(number));
        }
    }

    @Test
    public void testZero() {
        MainPanel panel = new MainPanel(15);
        assertEquals(panel.convertToIntPre(0), panel.convertToInt(0));
    }

    //Test the functionality of method runContinuous of MainPanel.class
    //Method runContinuous is difficult to unit test, because the method keeps calling,
    // There is no stable state for us to test and it's more easier to see from the console.
    //    @Test
    //    public void testRunning() {
    //        MainPanel panel = new MainPanel(15);
    //        panel.runContinuous();
    //    }


    //    Test the functionality of method backup() of MainPanel.class
    //    It's difficult to use unit test to test backup(), so we use manual test to test
    //    we assign a boolean cells_equal_backupCells in MainPanel.class to check whether _cells equals _backupCells or not
    //    when we call the backup() method

    @Test
    public void testBackUp() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int number = random.nextInt(100);
            MainPanel panel = new MainPanel(15);
            ArrayList<String> map = new ArrayList<String>();
            map.add("....X..X.......");
            map.add("..X.....X......");
            map.add("X.......X......");
            map.add(".X..X..........");
            map.add("..........X....");
            map.add("......X.X......");
            map.add(".X.............");
            map.add("....X..........");
            map.add("...............");
            map.add("......X..X.....");
            map.add("............X..");
            map.add("..............X");
            map.add(".............X.");
            map.add("..........X....");
            map.add(".......X.......");
            panel.load(map);
            while (number > 0) {
                panel.run();
                panel.backup();
                assertTrue(panel.cells_equal_backupCells);
                number--;
            }

        }
    }


}
