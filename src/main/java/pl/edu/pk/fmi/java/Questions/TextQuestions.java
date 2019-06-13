package pl.edu.pk.fmi.java.Questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class TextQuestions implements Question
{
    private int nr;
    private String body;
    private String[] answers;
    private String correct;

    public TextQuestions() throws IOException
    {
        this.set_from_file();
    }

    @Override
    public String[] get_questtion()
    {
        System.out.println("get_questtion");
        /**
         *
         *  zwraca łańcuchy do labeli w głównym widoku
         *
         */
        String[] q = new String[6];
        q[0] = this.body;
        for(int i = 1; i < 5; i++)
        {
            System.out.println(i);
            q[i] = answers[i - 1];
        }
        q[5] = this.correct;
        return q;
    }

    private void set_from_file() throws IOException
    {
        BufferedReader bf = null;
        try
        {
            this.answers = new String[4];
            String fileName = "src\\main\\java\\pl\\edu\\pk\\fmi\\java\\Questions\\Question.txt";

            bf = new BufferedReader(new FileReader(fileName));

            this.nr = Integer.valueOf(bf.readLine());
            this.body = bf.readLine();
            for (int i = 0; i < 4; i++)
            {
                this.answers[i] = bf.readLine();
            }
            this.correct = bf.readLine();

        }
        catch (IOException ex)
        {
            System.out.println("blad pliku");
            System.exit(1);
        }
        finally
        {
            bf.close();
        }
        }

        @Override
        public String toString ()
        {
            return "Pytanie \n" +
                    "{\n" +
                    "nr=" + nr + "\n" +
                    "tresc='" + body + '\'' + "\n" +
                    "odpowiedzi=" + Arrays.toString(answers) + "\n" +
                    "poprawna='" + correct + '\'' + "\n" +
                    '}';
        }


    }
