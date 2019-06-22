package pl.edu.pk.fmi.java;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.edu.pk.fmi.java.Lifelines.Lifelines_Phone;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */


    @Test
    public void test_Lifelines_Phone_status()
    {
        Lifelines_Phone Lifelines_Phone_Test = new Lifelines_Phone();


        Lifelines_Phone_Test.checkstatus(1);

        if (Lifelines_Phone_Test.getUseValue() == 1)
        {
            assertTrue(true);
        } else if (Lifelines_Phone_Test.getUseValue() != 1)
        {
            assertTrue(false);
        }
    }

    public void test_Lifelines_Phone_status()
    {
        Lifelines_Phone Lifelines_Phone_Test = new Lifelines_Phone();

        Lifelines_Phone_Test.checkstatus(1);

        if (Lifelines_Phone_Test.getUseValue() == 1)
        {
            assertTrue(true);
        } else if (Lifelines_Phone_Test.getUseValue() != 1)
        {
            assertTrue(false);
        }
    }





}
