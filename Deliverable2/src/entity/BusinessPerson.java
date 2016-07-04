package entity;
/**
 * Created by Derek on 6/15/16.
 */
public class BusinessPerson extends Visitor {
    public BusinessPerson(int ID){
        this.ID = ID;
        System.out.println("Visitor " + ID + " is a Business Person.");
        this.preference.put("The Cathedral of Learning",false);
        this.preference.put("Squirrel Hill",true);
        this.preference.put("The Point",false);
        this.preference.put("Downtown",true);
    }
}
