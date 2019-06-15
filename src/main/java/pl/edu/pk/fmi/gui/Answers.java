package pl.edu.pk.fmi.gui;

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
        setPreferredSize(new Dimension(800, 200));

        g = gg;
        setLayout(new GridLayout(2, 2, 10,10));
        setBackground(new Color(0,0,0,0));
        setOpaque(false);
        A = new AnswerButton(g.answer[0]);
        B = new AnswerButton(g.answer[1]);
        C = new AnswerButton(g.answer[2]);
        D = new AnswerButton(g.answer[3]);
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
        if(source == A || source == B || source == C || source == D) {
            g.score++;
            g.update();
            System.out.println(g.score);
        }

    }
}
