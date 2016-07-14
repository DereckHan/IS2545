public class Chirp {
    public static int schnirpyLevel(int n) {
        int toReturn = 0;
        for (int j = n; j < Integer.MAX_VALUE; j++) {
            if (j % 2 == 0) {
                toReturn++;
            }
        }
        return toReturn % 10;
    }
}
