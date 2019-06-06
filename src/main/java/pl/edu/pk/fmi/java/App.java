package pl.edu.pk.fmi.java;

import pl.edu.pk.fmi.java.Lifelines.Lifelines_50_50;
import pl.edu.pk.fmi.java.PlayerData.MainPlayer;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Lifelines_50_50 temp=new Lifelines_50_50();
        temp.Lifeline("jeden","dwa","trzy","cztery","dwa");
        temp.ChangeUsed();
        System.out.println(temp.getUseValue());

    }
}
