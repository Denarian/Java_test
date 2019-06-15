package pl.edu.pk.fmi.java.PlayerData;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import pl.edu.pk.fmi.java.observer.Observer;
import pl.edu.pk.fmi.java.observer.Subject;


import java.util.ArrayList;


//IMPLEMENTACJA DO UI MA BYć TAKA ŻE JAK KTÓREs Z PoL JEST ROWNE 1 TO NIE DA SIE PONOWNIE URZYC DANEGO KOLA
public class MainPlayer implements Subject
{

    private int PointCounter;
    private int UsedLifeline50_50=0;
    private int UsedLifeline_Phone=0;
    private int UsedLifeline_Public_answer=0;
    private ArrayList<Observer> observers;

    public MainPlayer()
    {
        this.PointCounter=0;
        observers=new ArrayList<>();
    }

    public int getPhone()
    {
        return UsedLifeline_Phone;
    }

    public int get50_50()
    {
        return UsedLifeline50_50;
    }

    public int getPublic()
    {
        return UsedLifeline_Public_answer;
    }
    //OBSERWATOR MODULE START---------------------------------------------------------


    @Override
    public void AttachN(Observer o)
    {
        observers.add(o);
    }
    @Override
    public void DetachN(Observer o)
    {
        observers.remove(o);
    }

    @Override
    public void Notify()
    {
        for(int i=0;i< observers.size();i++)
        {
            observers.get(i).Update(this);
        }

    }

    public void Notify50_50()
    {
        UsedLifeline50_50=1;
        Notify();
    }
    public int change50_50()
    {
        if(UsedLifeline50_50==1)
        {
            int a = 0;
            return a;
        }
        return 3;
    }
    public void NotifyPhone()
    {
        UsedLifeline_Phone=1;
        Notify();
    }
    public int changePhone()
    {
        if(UsedLifeline_Phone==1)
        {
            int b=1;
            return b;
        }
        return 3;
    }
    public void NotifyPublic()
    {
        UsedLifeline_Public_answer=1;
        Notify();

    }
    public int changePublic()
    {
        if(UsedLifeline_Public_answer==1)
        {
            int c=2;
            return c;
        }
        return 3;
    }
    //OBSERWATOR MODULE END----------------------------------------------------------------------------
    public int GetPointCounter()
    {
        return PointCounter;
    }//geter do punktów

    public void PlusPointCounter()//metoda dodająca punkty
    {
        this.PointCounter=PointCounter+1;
    }
    public void MinusPointCounter()//na wszelki wypadek metoda odejmująca punkty, nie mniej niż 0
    {
        if (this.PointCounter!=0)
        this.PointCounter=PointCounter-1;
    }
    public void SetZeroPointCounter()//wyzerowanie licznika punktów-w ten sposób można nijako zresetować grę
    {
        if(this.PointCounter!=0)
            this.PointCounter=0;
    }


}
