import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import entity.*;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Derek on 6/15/16.
 */
public class CitySim9002Test {
    @SuppressWarnings("unchecked")

    @Mock
    CitySim9002 mockedCitySim9002 = Mockito.mock(CitySim9002.class);
    Random mockedRandom = Mockito.mock(Random.class);
    Student mockedStudent = Mockito.mock(Student.class);
    Professor mockedProfessor = Mockito.mock(Professor.class);

    @Before
    public void setUp() throws Exception {
        // If you use @Mock, you need to do this
        MockitoAnnotations.initMocks(mockedCitySim9002);
        MockitoAnnotations.initMocks(mockedRandom);
        MockitoAnnotations.initMocks(mockedStudent);
        MockitoAnnotations.initMocks(mockedProfessor);

    }


    //check valid input 9
    //return correct number
    @Test
    public void checkInputValid() throws Exception {
        String[] args = {"9"};
        assertEquals(9,mockedCitySim9002.checkInput(args));
    }


    //check invalid input {"9","12"}
    // pass more than one argument, return -1
    @Test
    public void checkInputMoreArguments() throws Exception {
        String[] args = {"9","12"};
        assertEquals(-1,mockedCitySim9002.checkInput(args));
    }

    //check invalid input {}
    //pass no argument, return -1
    @Test
    public void checkNoInput() throws Exception {
        String[] args = {};
        assertEquals(-1,mockedCitySim9002.checkInput(args));
    }


    //check input is not a Integer {"s2,1"}
    //return -1;
    @Test
    public void checkInputDouble() throws Exception {
        String[] args = {"s2,1"};
        assertEquals(-1,mockedCitySim9002.checkInput(args));
    }


    //Using random get a random number 0≤result≤bound
    //return true
    @Test
    public void checkRandomNumber() throws Exception {
        boolean flag = false;
        int bound = 100;
        int result = mockedCitySim9002.randomNumber(mockedRandom,bound);
        if(result<bound&&result>=0){
            flag = true;
        }
        assertEquals(true,flag);
    }


    //mock the random number select, set the number as 0
    //the index 0 of location is The Cathedral of Learning, Not equal, return true;
    @Test
    public void checkLocation0() {
        Mockito.when(mockedCitySim9002.randomNumber(mockedRandom,4)).thenReturn(0);
        assertNotEquals("The Point", mockedCitySim9002.selectLocation(mockedCitySim9002.randomNumber(mockedRandom,4)));
    }


    //mock the random number select, set the number as 0
    //the index 0 of location is The Cathedral of Learning, Equal, return true;
    @Test
    public void checkLocation1() {
        Mockito.when(mockedCitySim9002.randomNumber(mockedRandom,4)).thenReturn(0);
        assertEquals("The Cathedral of Learning", mockedCitySim9002.selectLocation(mockedCitySim9002.randomNumber(mockedRandom,4)));
    }


    //mock the random number select, set the number as 0
    //the index 0 of visitor is student, Equal, return true;
    @Test
    public void checkVisitor0() {
        Mockito.when(mockedCitySim9002.randomNumber(mockedRandom,4)).thenReturn(0);
        assertNotEquals(mockedStudent, mockedCitySim9002.selectVisitor(1,mockedCitySim9002.randomNumber(mockedRandom,4)));
    }


    //mock the random number select, set the number as 0
    //the index 0 of visitor is student, NotEqual, return true;
    @Test
    public void checkVisitor1() {
        Mockito.when(mockedCitySim9002.randomNumber(mockedRandom,4)).thenReturn(0);
        assertNotEquals(mockedProfessor, mockedCitySim9002.selectVisitor(1,mockedCitySim9002.randomNumber(mockedRandom,4)));
    }



}