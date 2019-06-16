package pl.edu.pk.fmi.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lifebuoys extends JPanel implements ActionListener {
    Lifebuoy fifty_fifty;
    Lifebuoy q_public;
    Lifebuoy q_friend;
    GameScreen g;
    public Lifebuoys(GameScreen gg)
    {
        g = gg;
        setPreferredSize(new Dimension(250, 80));
        setBackground(new Color(0,0,0,0));
        setOpaque(false);
        fifty_fifty =new Lifebuoy("graphic/50_50.png");
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(!g.state) {
            if (source == fifty_fifty) {
                String a[] = g.question_strings;
                String temp[]  = g.life_50_50.Lifeline(a[1],a[2],a[3],a[4],a[5]);
                for (String x: temp) {
                    g.answers.block_answer(x);
                }
                g.player.Notify50_50();
                remove(fifty_fifty);
                fifty_fifty = new LifebuoyDecorator(fifty_fifty);
                add(fifty_fifty);
                revalidate();
                repaint();

            }
            else if (source == q_public) {
                String a[] = g.question_strings;
                String temp[]  = g.life_answer.Lifeline(a[1],a[2],a[3],a[4],a[5]);
                for (int i = 0; i < temp.length ; i+=2) {
                    g.answers.display_percentage(temp[i],temp[i+1]);
                }
                g.player.NotifyPublic();
                remove(q_public);
                q_public = new LifebuoyDecorator(q_public);
                add(q_public);
                revalidate();
                repaint();

            }
            else if(source == q_friend) {
                String a[] = g.question_strings;
                String temp[]  = g.life_phone.Lifeline(a[1],a[2],a[3],a[4],a[5]);
                if(temp.length>0) {
                    g.friend_info.setText(temp[0]);
                    g.friend_info.repaint();
                }
                g.player.NotifyPhone();
                remove(q_friend);
                q_friend = new LifebuoyDecorator(q_friend);
                add(q_friend);
                revalidate();
                repaint();


            }
        }
    }

}
