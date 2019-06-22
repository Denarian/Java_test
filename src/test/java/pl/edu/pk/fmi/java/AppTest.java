package pl.edu.pk.fmi.java;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.edu.pk.fmi.java.Lifelines.Lifelines_Phone;
import pl.edu.pk.fmi.java.Questions.TextQuestions;
import java.io.IOException;
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


    @Test
    public void test_TextQuestionsBuilder() throws IOException
    {
        String[] correct = new String[6];

        correct[0] = "tresc";
        correct[1] = "odp1";
        correct[2] = "odp2";
        correct[3] = "odp3";
        correct[4] = "odp4";
        correct[5] = "a";

        String[] a = new String[4];
        a[0] = correct[1];
        a[1] = correct[2];
        a[2] = correct[3];
        a[3] = correct[4];

        TextQuestions tq = new TextQuestions.TextQuestionsBuilder()
                .nr(1)
                .body(correct[0])
                .answers(a)
                .correct(correct[5])
                .build();


        String[] results = new String[6];
        results = tq.get_questtion();

        if(correct[0].equals(results[0]) && correct[1].equals(results[1]) && correct[2].equals(results[2]) &&
                correct[3].equals(results[3]) && correct[4].equals(results[4]) && correct[5].equals(results[5]))
        {
            assertTrue(true);
        }
        else
        {
            assertTrue(false);
        }
    }







}
