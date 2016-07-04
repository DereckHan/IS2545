package entity;
/**
 * Created by Derek on 6/15/16.
 */
public class Professor extends Visitor {
    public Professor(int ID) {
        this.ID = ID;
        System.out.println("Visitor " + ID + " is a Professor.");
        this.preference.put("The Cathedral of Learning",true);
        this.preference.put("Squirrel Hill",true);
        this.preference.put("The Point",true);
        this.preference.put("Downtown",true);
    }
}
