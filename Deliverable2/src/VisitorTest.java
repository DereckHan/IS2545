import org.junit.Test;
import entity.*;


import static org.junit.Assert.*;

/**
 * Created by Derek on 6/15/16.
 */
public class VisitorTest {


    private Student student = new Student(1);
    private Professor professor = new Professor(1);
    //a visitor student, check the visitor's preference of "The Cathedral of Learning"
    //return false
    @Test
    public void visitPlaceStudent() throws Exception {
        assertEquals(false,student.visitPlace("The Cathedral of Learning"));
    }


    //a visitor professor, check the visitor's preference of "The Cathedral of Learning"
    //return true
    @Test
    public void visitPlaceProfessor() throws Exception {
        assertEquals(true,professor.visitPlace("The Cathedral of Learning"));
    }


}