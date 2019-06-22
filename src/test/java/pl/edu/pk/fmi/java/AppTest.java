package pl.edu.pk.fmi.java;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
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

//    @Test
//    public void test1() {
//        Lifelines_Phone Lifelines_Phone_Test = new Lifelines_Phone();
//
//
//        Lifelines_Phone_Test.checkstatus(2);
//
//        if (Lifelines_Phone_Test.getUseValue()==1)
//        {
//            assertTrue(true);
//        }
//        else if (Lifelines_Phone_Test.getUseValue() != 1)
//        {
//            assertTrue(false);
//        }
//
//    }

    @Test
    public void is_correct_test() throws IOException{
        String[]  a = new String[4];
        a[0] = "odp1";
        a[1] = "odp2";
        a[2] = "odp3";
        a[3] = "odp4";


        TextQuestions tq = new TextQuestions.TextQuestionsBuilder()
                .nr(1)
                .body("tresc")
                .answers(a)
                .correct("a")
                .build();


        assertTrue(tq.is_correct("a"));
    }


}
