package pl.edu.pk.fmi.java.Lifelines;

public class Lifelines_Public_answer implements interfaceToLifelines {

    //zmienna informująca czy koło zostało użyte
    private int stat=0;

    @Override
    public int getUseValue() {return this.stat; }

    @Override
    public void ChangeUsed() {this.stat=1; }

    @Override
    public String[] Lifeline(String answerA, String answerB, String answerC, String answerD, String rightAnswer) {
        //tba
        return new String[0];
    }
}
