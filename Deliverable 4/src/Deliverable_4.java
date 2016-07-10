

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;


/**
 * Created by Derek on 7/10/16.
 */
public class Deliverable_4 {
    static int arrayLength[] = generateNumber();
    static Random random = new Random();


    //Output array should have one more element than the input array
    @Test
    public void testSize() {
        for (int length : arrayLength) {
            int[] x = new int[length];
            Arrays.fill(x, 1);
            for (int i = 0; i < x.length; i++) {
                x[i] += random.nextInt(100);
            }
            int[] res = billify(x);
            assertEquals(res.length, x.length + 1);
        }
    }

    //for each element in the output array except the last one, the range should be 1~10000
    //for the last element of the output array, the range should be (length-1)*1~(length-1)*10000
    @Test
    public void testRange() {
        for (int length : arrayLength) {
            int[] x = new int[length];
            Arrays.fill(x, 1);
            for (int i = 0; i < x.length; i++) {
                x[i] += random.nextInt(100);
            }
            int[] res = billify(x);
            for (int i = 0; i < res.length - 1; i++) {
                if (res[i] > 10000 || res[i] < 1) {
                    fail();
                }
            }
            if (res[res.length - 1] > (res.length - 1) * 10000 || res[res.length - 1] < (res.length - 1) * 1)
                fail();
        }
    }

    //for Pure : running it twice on same input array should always result in same output
    @Test
    public void testPure() {
        for (int length : arrayLength) {
            int[] x = new int[length];
            Arrays.fill(x, 1);
            for (int i = 0; i < x.length; i++) {
                x[i] += random.nextInt(100);
            }
            int[] res = billify(x);
            int[] resTwice = billify(x);
            if(res.length!=resTwice.length)
                fail();
            for (int i = 0; i < res.length; i++) {
                if(res[i]!=resTwice[i])
                    fail();
            }

        }
    }


    public static int[] billify(int[] x) {
        int n = x.length;
        int[] ans = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            ans[i] = x[i] * x[i];
            sum += ans[i];
        }
        ans[n] = sum;
        return ans;
    }

    public static int[] generateNumber() {
        int[] temp = new int[100];
        int[] res = new int[100];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = i + 1;
        }
        Random random = new Random();
        int end = temp.length - 1;
        for (int j = 0; j < temp.length; j++) {
            int index = random.nextInt(end + 1);
            res[j] = temp[index];
            temp[index] = temp[end];
            end--;
        }

        return res;
    }
}
