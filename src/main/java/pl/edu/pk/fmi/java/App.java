package pl.edu.pk.fmi.java;


import pl.edu.pk.fmi.java.Questions.Question;
import pl.edu.pk.fmi.java.Questions.TextQuestions;

import java.io.IOException;


public class App
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Hello World!");
        Question[] q = new Question[5];

        for (int i = 0; i < q.length; i++)
        {

            q[i] = new TextQuestions.TextQuestionsBuilder()
                    .build_from_file();
        }

        String[] a = new String[6];

        for (Question z : q)
        {
            a = z.get_questtion();
            for (String x : a)
            {
                System.out.println(x);
            }
            System.out.println();
        }
////      klasyczny działa
//        String[] s = new String[4];
//        s[0] = "Jeden";
//        s[1] = "Dwa";
//        s[2] = "Trzy";
//        s[3] = "Cztery";
//
//        TextQuestions tq = new TextQuestions.TextQuestionsBuilder()
//                .body("tresc")
//                .correct("c")
//                .answers(s)
//                .nr(1)
//                .build();
//        System.out.println(tq);
//
//        TextQuestions tq = new TextQuestions.TextQuestionsBuilder()
//                .build_from_file();
//        System.out.println(tq);

    }
}
