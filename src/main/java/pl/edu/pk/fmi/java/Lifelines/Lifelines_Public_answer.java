package pl.edu.pk.fmi.java.Lifelines;
import java.util.Random;

import pl.edu.pk.fmi.java.PlayerData.MainPlayer;
import pl.edu.pk.fmi.java.observer.Observer;
public class Lifelines_Public_answer implements interfaceToLifelines,Observer {

    //zmienna informująca czy koło zostało użyte
    private int stat=0;
    //inicjalizacja generatora liczb
    private Random generator = new Random();

    void checkstatus(int a)
    {
        if(a==2)
        {
            stat=1;
        }
    }

    @Override
    public int getUseValue() {return this.stat;}

    @Override
    public void ChangeUsed() {this.stat=1; }

    @Override
    public void Update(Object o)
    {
        if(o instanceof MainPlayer)
        {
            MainPlayer MP=(MainPlayer) o;
            checkstatus(MP.changePublic());
        }
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
        //LOSOWANIE SZANS
        int a = generator.nextInt(100);
        int b = generator.nextInt(100-a);
        int c = generator.nextInt(100-a-b);
        int d=100-a-b-c;
        //TABLICA SZANS
        int [] tabValue={a,b,c,d};
        //MAX TABLE
        int max=0,rembi=0;
        for(int i=0;i<4;i++)
        {
            if (tabValue[i]>max) {
                max = tabValue[i];
                rembi=i;
            }
        }

        if(rembi!=3){
            int tempindex=tabValue[3];
            tabValue[3]=tabValue[rembi];
            tabValue[rembi]=tempindex;
        }

        if (answerA.equals(rightAnswer))
        {
            String[] wynikowa={answerA,Integer.toString(max),answerB,Integer.toString(tabValue[0]),answerC,Integer.toString(tabValue[1]),answerD,Integer.toString(tabValue[2])};
            return wynikowa;
        }
        if (answerB.equals(rightAnswer))
        {
            String[] wynikowa={answerB,Integer.toString(max),answerA,Integer.toString(tabValue[0]),answerC,Integer.toString(tabValue[1]),answerD,Integer.toString(tabValue[2])};
            return wynikowa;
        }
        if (answerC.equals(rightAnswer))
        {
            String[] wynikowa={answerC,Integer.toString(max),answerA,Integer.toString(tabValue[0]),answerB,Integer.toString(tabValue[1]),answerD,Integer.toString(tabValue[2])};
            return wynikowa;
        }
        if (answerD.equals(rightAnswer))
        {
            String[] wynikowa={answerD,Integer.toString(max),answerA,Integer.toString(tabValue[0]),answerB,Integer.toString(tabValue[1]),answerC,Integer.toString(tabValue[2])};
            return wynikowa;
        }
        String []taberror={"ERROR"};
        return taberror;
}}
