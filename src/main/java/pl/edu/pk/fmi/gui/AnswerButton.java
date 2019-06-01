package pl.edu.pk.fmi.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AnswerButton extends JToggleButton
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
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0,0,this.getWidth(),this.getHeight());
        int x_points[] = {2,30,getWidth()-30,getWidth()-2,getWidth()-30,30,2};
        int y_points[] = {getHeight()/2,2,2,getHeight()/2,getHeight()-2,getHeight()-2,getHeight()/2};
        if(isSelected())g2d.setColor(Color.BLUE);
        g2d.fillPolygon(x_points,y_points,x_points.length);

        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(x_points,y_points,x_points.length);
        g2d.drawString(text,40,this.getHeight()/2);

    }
}
