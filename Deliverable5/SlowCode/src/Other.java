public class Other {

    private int val;

    public Other(int val) {
        this.val = val;
    }

    public String levelifier(int val, String toReturn) {
        if (val < 1500) {
            return toReturn + this.levelifier(++val, toReturn + "2");
        } else {
            return "3";
        }
    }
    
    public String threatLevel(int val) {
        String toReturn = "Midnight";
        String conv = levelifier(val, toReturn).substring(0,  Math.abs(val));
        return conv;
    }
}
