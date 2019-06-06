package pl.edu.pk.fmi.java.PlayerData;


public class MainPlayer
{

    private int PointCounter;
    private int UsedLifeline50_50=0;
    private int UsedLifeline_Phone=0;
    private int UsedLifeline_Public_answer=0;

    public MainPlayer()
    {
        this.PointCounter=0;
    }

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
