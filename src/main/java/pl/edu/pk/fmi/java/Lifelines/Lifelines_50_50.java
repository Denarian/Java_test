package pl.edu.pk.fmi.java.Lifelines;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;
//RADEME:
//Klasa zwraca 2 stringi jeden z nich jest poprawną odpowiedzią a drugi z nich jest losową inną odpowiedzią
//zmienna stat określa czy koło zostało urzyte-tutaj zrobię w najbliższym czasie obserwatora narazie go nie ma

public class Lifelines_50_50 implements interfaceToLifelines
{
    //zmienna informująca czy koło zostało użyte
    private int stat=0;
    //inicjalizacja generatora liczb
    private Random generator = new Random();

    @Override
    public int getUseValue(){
        return this.stat;
    }

    @Override
    public void ChangeUsed() {
        this.stat=1;
    }

    @Override
    public int Lifeline(String answerA, String answerB, String answerC, String answerD, String rightAnswer) {
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
        //inicjalizacja słownika
        Dictionary answers=new Hashtable();
        //umieszczanie odpowiedzi w słowniku
        answers.put(0,answerA);
        answers.put(1,answerB);
        answers.put(2,answerC);
        answers.put(3,answerD);
        //użycie generatora
        while(true) {
            int a = generator.nextInt(4);
            if (answers.get(a) == rightAnswer) continue;
            else System.out.println(answers.get(a)+" "+rightAnswer);
            return 0;
        }
    }
}
