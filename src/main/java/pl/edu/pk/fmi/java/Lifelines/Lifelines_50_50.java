package pl.edu.pk.fmi.java.Lifelines;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import pl.edu.pk.fmi.java.PlayerData.MainPlayer;
import pl.edu.pk.fmi.java.observer.Observer;
import java.util.Random;
//RADEME:
//Klasa zwraca 2 stringi jeden z nich jest poprawną odpowiedzią a drugi z nich jest losową inną odpowiedzią
//zmienna stat określa czy koło zostało urzyte-tutaj zrobię w najbliższym czasie obserwatora narazie go nie ma
//!!!!!!!!!!! METODA LIFELINE ODPOWIEDZIALNA ZA DZIAŁANIE KOŁA ZWRACA TABLICE 2 ELEMENTOWA

public class Lifelines_50_50 implements interfaceToLifelines,Observer
{
    //zmienna informująca czy koło zostało użyte
    private int stat=0;
    //inicjalizacja generatora liczb
    private Random generator = new Random();

    void checkstatus(int a)
    {
        if(a==0)
        {
            stat=1;
        }
    }
    @Override
    public void ChangeUsed() {
        this.stat=1;
    }

    @Override
    public void Update(Object o)
    {
        if(o instanceof MainPlayer)
        {
            MainPlayer MP=(MainPlayer) o;
            checkstatus(MP.change50_50());
        }
    }

    @Override
    public int getUseValue(){
        return stat;
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
        //inicjalizacja słownika
        Dictionary answers=new Hashtable();
        //umieszczanie odpowiedzi w słowniku
        answers.put(0,answerA);
        answers.put(1,answerB);
        answers.put(2,answerC);
        answers.put(3,answerD);

        String[] temp = new String[2];
        int i = 0;
        while(true) {
            //użycie generatora
            int a = generator.nextInt(4);
            if (answers.get(a).equals(rightAnswer)) continue;
            else {
                //System.out.println(answers.get(a) + " " + rightAnswer);
                if( i > 0 && temp[0]==answers.get(a)) continue;

                temp[i++]=answers.get(a).toString();
                if(i == 2)
                    return temp;
            }
        }
    }
}
