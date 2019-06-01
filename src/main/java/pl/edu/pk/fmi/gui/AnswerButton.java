package pl.edu.pk.fmi.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AnswerButton extends JButton
{
    String text;
    BufferedImage frame[];
    boolean frame_ok;
    public AnswerButton(String text)
    {
        super(text);
        this.text = text;
        setBorderPainted(false);
        //setOpaque(true);
        setPreferredSize(new Dimension(100,80));
        frame = new BufferedImage[3];
        frame_ok = true;
        for(int i =0 ;i<frame.length;i++) {
            try {
                frame[i] =ImageIO.read(new File("graphic/"+(i+1)+".png"));
            } catch (IOException ex) {
                System.out.println("Nie zaleziono pliku "+(i+1)+".png");
                frame_ok = false;
            }
        }
    }
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.CYAN);
        g2d.fillRect(0,0,this.getWidth(),this.getHeight());
        if(frame_ok) g2d.drawImage(frame[0],0,0,43,80,this);
        else g2d.fillRect(0,0,43,80);
        if(frame_ok) g2d.drawImage(frame[2],this.getWidth() - 43,0,43,80,this);
        else g2d.fillRect(this.getWidth() - 43,0,43,80);
        for(int x = 41;x < this.getWidth() - 41 ;x++)
        {
            if(frame_ok) g2d.drawImage(frame[1],x,0,1,80,this);
            else g2d.fillRect(x,0,1,80);
        }

        g2d.setColor(Color.BLACK);

        g2d.drawString(text,40,this.getHeight()/2);

    }
}
