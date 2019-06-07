package pl.edu.pk.fmi.java;

import pl.edu.pk.fmi.java.Lifelines.Lifelines_50_50;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_Phone;
import pl.edu.pk.fmi.java.PlayerData.MainPlayer;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Lifelines_50_50 temp=new Lifelines_50_50();
        Lifelines_Phone temp2=new Lifelines_Phone();
        String[] temp4=new String[2];
        temp4=temp2.Lifeline("jeden","dwa","trzy","cztery","dwa");
        System.out.println(temp4[0]+" "+temp4[1]);


    }
}
