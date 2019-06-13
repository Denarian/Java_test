package pl.edu.pk.fmi.java;


import pl.edu.pk.fmi.java.Questions.Question;
import pl.edu.pk.fmi.java.Questions.TextQuestions;

import java.io.IOException;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Question[] q = new Question[4];

        for (int i = 0; i < q.length; i++)
        {
            System.out.println( "Hello World!" );
            q[i] = new TextQuestions();
        }

        String[] a = new String[6];

        for (Question z: q)
        {
            a = z.get_questtion();
            for (String x: a)
            {
                System.out.println(x);
            }
            System.out.println();
        }
    }
}
