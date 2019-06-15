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
            throw new RuntimeException("to koło Publika zostało już użyte: ");
        }
        if(answerA==answerB || answerA==answerC || answerA==answerD || answerB==answerC ||answerB==answerD || answerC==answerD)
        {
            throw new IllegalArgumentException("kilka odpowiedzi jest takich samych: ");
        }
        if(rightAnswer!=answerA && rightAnswer!=answerB && rightAnswer!=answerC && rightAnswer!=answerD)
        {
            throw new IllegalArgumentException("Poprawna odpowiedz nie jest jedną z podanych: ");
        }
        //LOSOWANIE SZANS
        int a = generator.nextInt(100);
        int b = generator.nextInt(100-a);
        int c = generator.nextInt(100-a-b);
        int d=100-a-b-c;
        //TABLICA SZANS
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
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

        if (answerA==rightAnswer)
        {
            String[] wynikowa={answerA,Integer.toString(max),answerB,Integer.toString(tabValue[0]),answerC,Integer.toString(tabValue[1]),answerD,Integer.toString(tabValue[2])};
            return wynikowa;
        }
        if (answerB==rightAnswer)
        {
            String[] wynikowa={answerB,Integer.toString(max),answerA,Integer.toString(tabValue[0]),answerC,Integer.toString(tabValue[1]),answerD,Integer.toString(tabValue[2])};
            return wynikowa;
        }
        if (answerC==rightAnswer)
        {
            String[] wynikowa={answerC,Integer.toString(max),answerA,Integer.toString(tabValue[0]),answerB,Integer.toString(tabValue[1]),answerD,Integer.toString(tabValue[2])};
            return wynikowa;
        }
        if (answerD==rightAnswer)
        {
            String[] wynikowa={answerD,Integer.toString(max),answerA,Integer.toString(tabValue[0]),answerB,Integer.toString(tabValue[1]),answerC,Integer.toString(tabValue[2])};
            return wynikowa;
        }
        String []taberror={"ERROR"};
        return taberror;
}}
