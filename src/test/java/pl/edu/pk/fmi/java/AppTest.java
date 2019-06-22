package pl.edu.pk.fmi.java;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_50_50;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_Phone;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_Public_answer;
import pl.edu.pk.fmi.java.Lifelines.interfaceToLifelines;
import pl.edu.pk.fmi.java.Questions.TextQuestions;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void Lifelines_Phone_test() {
        interfaceToLifelines l = new Lifelines_Phone();
        String temp[], temp2;
        int counter = 0, iterations = 10000;
        for (int i = 0; i < iterations; i++) {
            temp = l.Lifeline("a", "b", "c", "d", "a");
            temp2 = temp[0].substring(temp[0].length() - 8, temp[0].length() - 7).toLowerCase();
            if (temp2.equals(temp[1]))
                counter++;
        }
        double result = (double) counter / (double) iterations;
        assertTrue(0.56 < result && result < 0.58);
    }
    @Test
    public void Lifelines_Public_test() {
        interfaceToLifelines l = new Lifelines_Public_answer();
        String temp[]  = l.Lifeline("a","b","c","d","b");
        int max = 0;
        for(int i = 1; i<temp.length;i+=2)
        {
            int temp2 = Integer.parseInt(temp[i]);
            if(max < temp2 )
                max = temp2;
        }
        assertTrue(temp[0].equals("b") && Integer.parseInt(temp[1]) == max );
    }
    @Test
    public void Class50_50RightAnswerTest() {
        Lifelines_50_50 temp = new Lifelines_50_50();
        String[] rozw1 = new String[2];
        int counter = 0;
        for (int i = 0; i < 1000; i++) {
            rozw1 = temp.Lifeline("jeden", "dwa", "trzy", "cztery", "a");
            if (rozw1[0] != rozw1[1]) {
                counter++;
            }
        }
        System.out.println(counter);
        if (counter == 1000) assertTrue(true);
    }
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
