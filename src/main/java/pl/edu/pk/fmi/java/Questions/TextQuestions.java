package pl.edu.pk.fmi.java.Questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class TextQuestions implements Question
{
    private static int count = 0;
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
        /**
         *
         *  zwraca łańcuchy do labeli w głównym widoku
         *
         */
        String[] q = new String[6];
        q[0] = this.body;
        for (int i = 1; i < 5; i++)
        {
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
            for (int i = 0; i < 7 * this.count; i++)
            {
                bf.readLine();
            }
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
            count++;
        }
    }

    @Override
    public String toString()
    {
        return "Pytanie \n" +
                "{\n" +
                "nr=" + nr + "\n" +
                "tresc='" + body + '\'' + "\n" +
                "odpowiedzi=" + Arrays.toString(answers) + "\n" +
                "poprawna='" + correct + '\'' + "\n" +
                '}';
    }

    @Override
    public boolean is_correct(String answer)
    {
        /**
         *      Sprawdza czy odp jest poprawna dla string
         */
        if (answer == this.correct)
            return true;
        else
            return false;
    }

    public boolean is_correct(char answer)
    {
        /**
         *      Sprawdza czy odp jest poprawna dla char
         */
        if (answer == this.correct.charAt(0))
            return true;
        else
            return false;
    }

    public boolean is_correct(int answer)
    {
        /**
         *      Sprawdza czy odp jest poprawna dla int
         *      liczenie od 1
         */
        String a = new String();
        switch (answer)
        {
            case 1:
                a = "a";
                break;
            case 2:
                a = "b";
                break;
            case 3:
                a = "c";
                break;
            case 4:
                a = "d";
                break;
        }
        return is_correct(a);

    }


}
