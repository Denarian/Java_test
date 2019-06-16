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

        if(g.state == true && (source == A || source == B ||source == C || source == D))
        {
            g.question = new TextQuestions.TextQuestionsBuilder().build_from_file();

            A.resetColor();
            B.resetColor();
            C.resetColor();
            D.resetColor();
            g.update_content();
        }
        else if(source == A ) {
            if(g.question.is_correct('a')){
                g.score++;
                g.update_content();
                A.changeColor(Color.GREEN);
                g.state = true;
            }else{
                A.changeColor(Color.RED);
                g.state = true;
            }
            System.out.println("a");
        }
        else if(source == B) {
            if(g.question.is_correct('b')) {
                g.score++;
                g.update_content();
                B.changeColor(Color.GREEN);
                g.state = true;
            }else{
                B.changeColor(Color.RED);
                g.state = true;
            }
            System.out.println("b");
        }
        else if(source == C) {
            if(g.question.is_correct('c')) {
                g.score++;
                g.update_content();
                C.changeColor(Color.GREEN);
                g.state = true;
            }else{
                C.changeColor(Color.RED);
                g.state = true;
            }
            System.out.println("c");
        }
        else if(source == D) {
            if(g.question.is_correct('d')) {
                g.score++;
                g.update_content();
                D.changeColor(Color.GREEN);
                g.state = true;
            }else{
                D.changeColor(Color.RED);
                g.state = true;
            }
            System.out.println("d");
        }

    }
    void update_content(){
        A.update(g.question_strings[1]);
        B.update(g.question_strings[2]);
        C.update(g.question_strings[3]);
        D.update(g.question_strings[4]);

    }
}
