package pl.edu.pk.fmi.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lifebuoys extends JPanel implements ActionListener {
    Lifebuoy fifty_fifty;
    Lifebuoy q_public;
    Lifebuoy q_friend;

    public Lifebuoys()
    {
        setPreferredSize(new Dimension(250, 80));
        setBackground(new Color(0,0,0,0));
        setOpaque(false);

        fifty_fifty = new Lifebuoy("graphic/50_50.png");
        q_public = new Lifebuoy("graphic/pdp.png");
        q_friend = new Lifebuoy("graphic/pdpr.png");
        fifty_fifty.setSize(80,80);
        q_friend.setSize(80,80);
        q_public.setSize(80,80);
        fifty_fifty.addActionListener(this);
        q_friend.addActionListener(this);
        q_public.addActionListener(this);
        add(fifty_fifty);
        add(q_public);
        add(q_friend);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
