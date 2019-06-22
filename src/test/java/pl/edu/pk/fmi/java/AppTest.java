package pl.edu.pk.fmi.java;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_50_50;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_Phone;
import pl.edu.pk.fmi.java.Lifelines.interfaceToLifelines;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void Lifelines_Phone_test()
    {
        interfaceToLifelines l = new Lifelines_Phone();
        String temp[],temp2;
        int counter = 0,iterations = 10000;
        for(int i= 0; i < iterations;i++) {
            temp = l.Lifeline("a", "b", "c", "d", "a");
            temp2 = temp[0].substring(temp[0].length()-8,temp[0].length()-7).toLowerCase();
            if(temp2.equals(temp[1]))
                counter++;
        }
        double result = (double)counter/(double)iterations;
        assertTrue( 0.56 < result && result < 0.58 );
    }
}
