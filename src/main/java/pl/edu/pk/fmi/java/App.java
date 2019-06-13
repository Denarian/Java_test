package pl.edu.pk.fmi.java;


import pl.edu.pk.fmi.java.Questions.Question;
import pl.edu.pk.fmi.java.Questions.TextQuestions;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        TextQuestions q = new TextQuestions();
        String[] a = new String[6];
        a = q.get_questtion();
        for (String x: a)
        {
            System.out.println(x);
        }
    }
}
