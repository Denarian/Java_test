package pl.edu.pk.fmi.java.Lifelines;
import java.util.Random;

//RADEME:
//Klasa zwraca 2 stringi jeden z nich jest odpowiedzią którą udzielił expert a drugi z nich jest poprawną odpowiedzią
//zmienna stat określa czy koło zostało urzyte-tutaj zrobię w najbliższym czasie obserwatora narazie go nie ma
//!!!!!!!!!!! METODA LIFELINE ODPOWIEDZIALNA ZA DZIAŁANIE KOŁA ZWRACA TABLICE 2 ELEMENTOWA

public class Lifelines_Phone implements interfaceToLifelines
{
    //zmienna informująca czy koło zostało użyte
    private int stat=0;
    //inicjalizacja generatora liczb
    private Random generator = new Random();

    @Override
    public int getUseValue() {
        return this.stat;
    }

    @Override
    public void ChangeUsed() {
        this.stat=1;
    }

    @Override
    public String[] Lifeline(String answerA, String answerB, String answerC, String answerD, String rightAnswer) {
        //obsługa wyjątków dla argumentów funkcji
        if(this.stat==1)
        {
            throw new RuntimeException("to koło zostało już użyte: ");
        }
        if(answerA==answerB || answerA==answerC || answerA==answerD || answerB==answerC ||answerB==answerD || answerC==answerD)
        {
            throw new IllegalArgumentException("kilka odpowiedzi jest takich samych: ");
        }
        if(rightAnswer!=answerA && rightAnswer!=answerB && rightAnswer!=answerC && rightAnswer!=answerD)
        {
            throw new IllegalArgumentException("Poprawna odpowiedz nie jest jedną z podanych: ");
        }
        String text1="Witaj Przyjaciuelu! Postaram się pomóc!\n";
        String text2="Zastanówmy się\n";
        String text3=".......\n";
        String text4="Moim zdaniem Poprawna odpowiedz to: ";
        String randAnswer,finall;
        //użycie generatora
        int a = generator.nextInt(7);
        switch (a){
            case 0:{
                randAnswer=rightAnswer;
                break;}
            case 1:{
                randAnswer=rightAnswer;
                break;}
            case 2:{
                randAnswer=rightAnswer;
                break;}
            case 3: {
            randAnswer=answerA;
            break; }
            case 4:{
                randAnswer=answerB;
                break; }
            case 5:{
                randAnswer=answerC;
                break; }
            case 6:{
                randAnswer=answerD;
                break; }
            default:{
                randAnswer="coś poszło nie tak";
                System.exit(1);
            }
        }

        finall=text1+text2+text3+text4+randAnswer;
        String[] tab=new String[2];
        tab[0]=finall;
        tab[1]=rightAnswer;
        ChangeUsed();
    return tab;
    }
}
