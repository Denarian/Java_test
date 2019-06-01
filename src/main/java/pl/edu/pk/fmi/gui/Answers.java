package pl.edu.pk.fmi.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Answears extends JPanel implements ActionListener  {
    JButton A;
    JButton B;
    JButton C;
    JButton D;
    GameScreen g;
    public Answears(GameScreen gg)
    {
        //setPreferredSize(new Dimension(500, 150));
        //setLocation(50,50);
        g = gg;
        setLayout(new GridLayout(2, 2, 30,15));

        A = new JButton("A");
        B = new JButton("B");
        C = new JButton("C");
        D = new JButton("D");
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
