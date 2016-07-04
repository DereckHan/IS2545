package entity;

/**
 * Created by Derek on 6/15/16.
 */
public class Blogger extends Visitor {
    public Blogger(int ID){
        this.ID = ID;
        System.out.println("Visitor " + ID + " is a Blogger.");
        this.preference.put("The Cathedral of Learning",false);
        this.preference.put("Squirrel Hill",false);
        this.preference.put("The Point",false);
        this.preference.put("Downtown",false);
    }
}
