package pl.edu.pk.fmi.java.Questions;

public interface Question
{
    String[] get_questtion();
    boolean is_correct(String x);
    boolean is_correct(char x);
    boolean is_correct(int x);


}
