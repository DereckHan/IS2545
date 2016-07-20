import org.junit.Test;

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
        int number = random.nextInt(Integer.MAX_VALUE);
        assertEquals(panel.convertToIntPre(number), panel.convertToInt(number));
    }

    @Test
    public void testZero() {
        MainPanel panel = new MainPanel(15);
        assertEquals(panel.convertToIntPre(0), panel.convertToInt(0));
    }

    //Test the functionality of method runContinuous of MainPanel.class
    //Method runContinuous is difficult to unit test, because the method keeps calling,
    //There is no stable state for us to test and it's more easier to see from the console.
//    @Test
//    public void testRunning() {
//        MainPanel panel = new MainPanel(15);
//        panel.runContinuous();
//    }




}
