package pl.edu.pk.fmi.java;
import pl.edu.pk.fmi.gui.Gui;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_50_50;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_Phone;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_Public_answer;
import pl.edu.pk.fmi.java.PlayerData.MainPlayer;
import pl.edu.pk.fmi.java.Questions.Question;
import pl.edu.pk.fmi.java.Questions.TextQuestions;


import java.awt.*;


public class App 
{
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Question question = new TextQuestions.TextQuestionsBuilder().build_from_file();
                MainPlayer player=new MainPlayer();
                Gui g = new Gui(player,question);
            }
        });

    /*
	MainPlayer player=new MainPlayer();
        Lifelines_50_50 temp=new Lifelines_50_50();
        Lifelines_Phone temp2=new Lifelines_Phone();
        Lifelines_Public_answer temp3=new Lifelines_Public_answer();
        player.AttachN(temp);
        player.AttachN(temp2);
        player.AttachN(temp3);
        String[] rozw1=new String[2];
        String[] rozw2=new String[2];
        String[] rozw3=new String[2];
        rozw1=temp.Lifeline("jeden","dwa","trzy","cztery","a");
        System.out.println(rozw1[0]+" "+rozw1[1]+"\n\n");
        rozw2=temp2.Lifeline("jeden","dwa","trzy","cztery","a");
        System.out.println(rozw2[0]+" "+rozw2[1]+"\n\n");
        rozw3=temp3.Lifeline("jeden","dwa","trzy","cztery","a");
        for(int i=0;i<8;i++)System.out.println(rozw3[i]);
        System.out.println("\n\n\n");
        System.out.println(temp.getUseValue()+" "+temp2.getUseValue()+" "+temp3.getUseValue());
        player.NotifyPhone();
        System.out.println(player.getPhone()+" "+player.get50_50()+" "+player.getPublic());
        System.out.println(temp.getUseValue()+" "+temp2.getUseValue()+" "+temp3.getUseValue());
        rozw1=temp.Lifeline("jeden","dwa","trzy","cztery","a");
        System.out.println(rozw1[0]+" "+rozw1[1]+"\n\n");
        rozw2=temp2.Lifeline("jeden","dwa","trzy","cztery","a");
        System.out.println(rozw2[0]+" "+rozw2[1]+"\n\n");
        rozw3=temp3.Lifeline("jeden","dwa","trzy","cztery","a");
        for(int i=0;i<8;i++)System.out.println(rozw3[i]);

*/
    }
}
