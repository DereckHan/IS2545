package entity;
import java.util.HashMap;

/**
 * Created by Derek on 6/15/16.
 */
public class Visitor {
    public int ID;
    public boolean firstVisit = true;
    public HashMap<String, Boolean> preference = new HashMap<String, Boolean>();

    public boolean visitPlace(String place) {
        System.out.println("Visitor " + ID + " is going to " + place + ".");
        if (this.preference.get(place)) {
            System.out.println("Visitor " + ID + " did like " + place);
            return true;
        } else {
            System.out.println("Visitor " + ID + " did not like " + place);
            return false;
        }
    }

    public void leaveCity() {
        System.out.println("Visitor " + ID + " has left the city");
        System.out.println("***");
    }
}
