package pl.edu.pk.fmi.java.Lifelines;
import pl.edu.pk.fmi.java.PlayerData.MainPlayer;
import pl.edu.pk.fmi.java.observer.Observer;
import java.util.Random;

//RADEME:
//Klasa zwraca 2 stringi jeden z nich jest odpowiedzią którą udzielił expert a drugi z nich jest poprawną odpowiedzią
//zmienna stat określa czy koło zostało urzyte-tutaj zrobię w najbliższym czasie obserwatora narazie go nie ma
//!!!!!!!!!!! METODA LIFELINE ODPOWIEDZIALNA ZA DZIAŁANIE KOŁA ZWRACA TABLICE 2 ELEMENTOWA

public class Lifelines_Phone implements interfaceToLifelines, Observer
{
    //zmienna informująca czy koło zostało użyte
    private int stat=0;
    //inicjalizacja generatora liczb
    private Random generator = new Random();


    public void checkstatus(int a)
    {
        if(a==1)
        {
            stat=1;
        }
    }

    @Override
    public void Update(Object o)
    {
        if(o instanceof MainPlayer)
        {
            MainPlayer MP=(MainPlayer) o;
            checkstatus(MP.changePhone());
        }
    }

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
        answerA="a";
        answerB="b";
        answerC="c";
        answerD="d";

        if(stat==1)
        {
            return new String[0];
        }
        if(answerA.equals(answerB) || answerA.equals(answerC) || answerA.equals(answerD) || answerB.equals(answerC) ||answerB.equals(answerD) || answerC.equals(answerD))
        {
            throw new IllegalArgumentException("kilka odpowiedzi jest takich samych: ");
        }
        if( !rightAnswer.equals(answerA) && !rightAnswer.equals(answerB) && !rightAnswer.equals(answerC) && !rightAnswer.equals(answerD))
        {
            throw new IllegalArgumentException("Poprawna odpowiedz nie jest jedną z podanych: ");
        }
        String text1="<html>Witaj Przyjacielu! Postaram się pomóc!<br/>";
        String text2="Zastanówmy się<br/>";
        String text3=".......<br/>";
        String text4="Moim zdaniem Poprawna odpowiedz to: ";
        String randAnswer,finall;
        //użycie generatora
        int a = generator.nextInt(7);
        switch (a){
            case 0:
                randAnswer=rightAnswer;
                break;
            case 1:
                randAnswer=rightAnswer;
                break;
            case 2:
                randAnswer=rightAnswer;
                break;
            case 3:
                randAnswer=answerA;
                break;
            case 4:
                randAnswer=answerB;
                break;
            case 5:
                randAnswer=answerC;
                break;
            case 6:
                randAnswer=answerD;
                break;
            default:
                randAnswer="coś poszło nie tak";
                //System.exit(1);

        }

        finall=text1+text2+text3+text4+randAnswer.toUpperCase()+"</html>";
        String[] tab=new String[2];
        tab[0]=finall;
        tab[1]=rightAnswer;
    return tab;
    }
}
