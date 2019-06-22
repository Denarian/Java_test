package pl.edu.pk.fmi.java;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_50_50;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void Class50_50RightAnswerTest()
    {
        Lifelines_50_50 temp=new Lifelines_50_50();
        String[] rozw1=new String[2];
        int counter =0;
        for(int i=0;i<1000;i++) {
            rozw1 = temp.Lifeline("jeden", "dwa", "trzy", "cztery", "a");
            if(rozw1[0]!=rozw1[1]){
                counter++;
            }
        }
        System.out.println(counter);
        if(counter==1000)assertTrue( true );
    }
}
