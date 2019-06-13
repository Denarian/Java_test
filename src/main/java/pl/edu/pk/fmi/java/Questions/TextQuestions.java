package pl.edu.pk.fmi.java.Questions;

public class TextQuestions implements Question
{
    private int nr;
    private String body;
    private String[] answers;
    private String correct;

    @Override
    public String[] get_questtion()
    {
        /**
         *  zwraca łańcuchy do labeli w głównym widoku
         *
         */
        String[] q = new String[5];
        q[0] = this.body;
        for (int i = 1; i < 5; i++)
        {
            q[i] = answers[i-1];
        }
        q[5] = this.correct;
        return q;
    }
}
