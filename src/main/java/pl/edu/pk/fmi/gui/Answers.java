package pl.edu.pk.fmi.gui;

import pl.edu.pk.fmi.java.Questions.TextQuestions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Answers extends JPanel implements ActionListener  {
    AnswerButton A;
    AnswerButton B;
    AnswerButton C;
    AnswerButton D;
    GameScreen g;

    public Answers(GameScreen gg)
    {
        //setPreferredSize(new Dimension(500, 150));
        //setLocation(50,50);
        g = gg;
        setLayout(new GridLayout(2, 2, 30,15));
        setBackground(new Color(0,0,0,0));
        setOpaque(false);
        A = new AnswerButton(g.question_strings[1]);
        B = new AnswerButton(g.question_strings[2]);
        C = new AnswerButton(g.question_strings[3]);
        D = new AnswerButton(g.question_strings[4]);
        A.addActionListener(this);
        B.addActionListener(this);
        C.addActionListener(this);
        D.addActionListener(this);
        add(A);
        add(B);
        add(C);
        add(D);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        Object source = e.getSource();
        if(source == A || source == B ||source == C || source == D)
        {
            if(A.text.equals("A: "))
                System.exit(0);
        }
        if(g.state == true && (source == A || source == B ||source == C || source == D))
        {
            if(g.question.get_count() == 20){
                g.question_strings[0] = "<html><center>Gratulacje wygrałeś:<br>"+g.player.GetPointCounter()*50000+"zł<font size=\"1\"> długu</font></center></html>";
                for (int i = 1;i< g.question_strings.length;i++)
                    g.question_strings[i]="";
                    g.update_content_fin();
            }
            else {
                g.question = new TextQuestions.TextQuestionsBuilder().build_from_file();
                g.update_content();
            }
            reset_state();
        }
        else if(source == A ) {
            if(g.question.is_correct('a')){
                g.player.PlusPointCounter();
                g.update_content();
                A.changeColor(Color.GREEN);
                g.state = true;
            }else{
                A.changeColor(Color.RED);
                g.state = true;
            }
        }
        else if(source == B) {
            if(g.question.is_correct('b')) {
                g.player.PlusPointCounter();
                g.update_content();
                B.changeColor(Color.GREEN);
                g.state = true;
            }else{
                B.changeColor(Color.RED);
                g.state = true;
            }
        }
        else if(source == C) {
            if(g.question.is_correct('c')) {
                g.player.PlusPointCounter();
                g.update_content();
                C.changeColor(Color.GREEN);
                g.state = true;
            }else{
                C.changeColor(Color.RED);
                g.state = true;
            }
        }
        else if(source == D) {
            if(g.question.is_correct('d')) {
                g.player.PlusPointCounter();
                g.update_content();
                D.changeColor(Color.GREEN);
                g.state = true;
            }else{
                D.changeColor(Color.RED);
                g.state = true;
            }
        }

    }
    void update_content(){
        A.update("A: "+g.question_strings[1]);
        B.update("B: "+g.question_strings[2]);
        C.update("C: "+g.question_strings[3]);
        D.update("D: "+g.question_strings[4]);

    }
    void block_answer(String x)
    {
        if(x.equals("a"))
        {
            A.changeColor(Color.MAGENTA);
            A.removeActionListener(this);
        }
        else if(x.equals("b"))
        {
            B.changeColor(Color.MAGENTA);
            B.removeActionListener(this);
        }
        else if(x.equals("c"))
        {
            C.changeColor(Color.MAGENTA);
            C.removeActionListener(this);
        }
        else if(x.equals("d"))
        {
            D.changeColor(Color.MAGENTA);
            D.removeActionListener(this);
        }
    }

    void display_percentage(String x, String p)
    {
        if(x.equals("a"))
        {
            A.text += ": "+p+"%";
            A.repaint();
        }
        else if(x.equals("b"))
        {
            B.text += ": "+p+"%";
            B.repaint();
        }
        else if(x.equals("c"))
        {
            C.text += ": "+p+"%";
            C.repaint();
        }
        else if(x.equals("d"))
        {
            D.text += ": "+p+"%";
            D.repaint();
        }
    }

    void reset_state()
    {
        g.state = false;
        A.resetColor();
        B.resetColor();
        C.resetColor();
        D.resetColor();
        if(A.getActionListeners().length == 0)
            A.addActionListener(this);

        if(B.getActionListeners().length == 0)
            B.addActionListener(this);

        if(C.getActionListeners().length == 0)
            C.addActionListener(this);

        if(D.getActionListeners().length == 0)
            D.addActionListener(this);
    }
}
