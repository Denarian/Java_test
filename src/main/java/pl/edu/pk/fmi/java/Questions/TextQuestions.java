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
        String[] q = new String[5];
        return q;
    }
}
