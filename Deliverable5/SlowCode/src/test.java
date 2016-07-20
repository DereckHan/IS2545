import java.util.*;

/**
 * Created by Derek on 7/18/16.
 */
public class test {
    public static void main(String[] args) {
        int n = 10;
        int[][] ans = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + ",");
            }
            System.out.println();
        }

    }

    public static void print(int[][] ans) {
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                System.out.print(ans[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] ans ={};
        if (n <= 0) {
            return ans;
        }
        ans = new int[n][n];
        int number = 1;
        int startX = 0;
        int startY = 0;
        int endX = n - 1;
        int endY = n - 1;
        while (number <= n * n) {
            for (int i = startY; i <= endY; i++) {
                ans[startX][i] = number++;
//                number++;
            }
            startX++;

            for (int i = startX; i <= endX; i++) {
                ans[i][endY] = number++;
//                number++;
            }
            endY--;
            for (int i = endY; i >= startY; i--) {
                ans[endX][i] = number++;
//                number++;
            }
            endX--;
            for (int i = endX; i >= startX; i--) {
                ans[i][startY] = number++;
//                number++;
            }
            startY++;
        }
        return ans;
    }

}
