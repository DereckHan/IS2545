import java.io.IOException;
import java.util.Random;
import entity.*;

/**
 * Created by Derek on 6/13/16.
 */
public class CitySim9002 {
    static String[] cityLocs = {"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown"};

    public static void main(String[] args) throws IOException {
        int seed = checkInput(args);
        if(seed == -1){
            System.out.println("Please enter one integer argument, seed");
            System.exit(-1);
        }
        System.out.println("Welcome to CitySim! Your seed is " + seed);
        Random random = new Random(seed);
        for (int i = 0; i < 5; i++) {
            int visitorIndex = randomNumber(random,4);
            int location = -1;
            String place="";
            Visitor visitor=selectVisitor(i,visitorIndex);
            while (location != 4) {
                if (visitor.firstVisit) {
                    location = randomNumber(random,4);
                    visitor.firstVisit = false;
                } else {
                    location = randomNumber(random,5);
                }
                if(location!=4){
                    place = selectLocation(location);
                    visitor.visitPlace(place);
                }
            }
            visitor.leaveCity();
        }

    }

    public static Visitor selectVisitor(int i, int visitorIndex) {
        Visitor visitor = new Visitor();
        switch (visitorIndex){
            case 0:
                visitor = new Student(i+1);
                break;
            case 1:
                visitor = new Professor(i+1);
                break;
            case 2:
                visitor = new BusinessPerson(i+1);
                break;
            case 3:
                visitor = new Blogger(i+1);
                break;
        }
        return visitor;
    }

    public static int checkInput(String[] input) {
        int seed = -1;
        if(input==null||input.length!=1){
            return seed;
        }
        try {
            seed = Integer.parseInt(input[0]);
        } catch (NumberFormatException e) {
            return seed;
        }
        return seed;
    }
    public static String selectLocation(int num) {

        return cityLocs[num];
    }

    public static int randomNumber(Random random, int bound) {
        return random.nextInt(bound);
    }
}
