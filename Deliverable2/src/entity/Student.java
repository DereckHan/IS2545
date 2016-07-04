package entity;
/**
 * Created by Derek on 6/15/16.
 */
public class Student extends Visitor {
    public Student(int ID) {
        this.ID = ID;
        System.out.println("Visitor " + ID + " is a Student.");
        this.preference.put("The Cathedral of Learning",false);
        this.preference.put("Squirrel Hill",true);
        this.preference.put("The Point",true);
        this.preference.put("Downtown",true);
    }
}
