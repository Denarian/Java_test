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
    Color color;
    boolean frame_ok;
    public AnswerButton(String text)
    {
        super(text);
        this.text = text;
        setBorder(null);
        setOpaque(false);
        setPreferredSize(new Dimension(100,80));
        frame = new BufferedImage[3];
        frame_ok = true;
        for(int i =0 ;i<frame.length;i++) {
            try {
                frame[i] = ImageIO.read(new File("graphic/"+(i+1)+".png"));
            } catch (IOException ex) {
                System.out.println("Nie zaleziono pliku "+(i+1)+".png");
                frame_ok = false;
            }
        }
        color = Color.WHITE;
    }
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if(frame_ok) g.drawImage(frame[0],0,0,43,80,this);
        else g2d.fillRect(0,0,43,80);
        if(frame_ok) g2d.drawImage(frame[2],this.getWidth() - 43,0,43,80,this);
        else g2d.fillRect(this.getWidth() - 43,0,43,80);
        for(int x = 41;x < this.getWidth() - 41; x++)
        {
            if(frame_ok) g2d.drawImage(frame[1],x,0,1,80,this);
            else g2d.fillRect(x,0,1,80);
        }

        g2d.setColor(Color.BLACK);
        int y = this.getHeight()/2 - 12;
        for(String x: text.split("<br/>"))
            g2d.drawString(x,40,y+=12);


    }
    void update(String s){
        text = s;
        repaint();
    }
    void changeColor(Color c)
    {
        ImageColorChange i = new ImageColorChange(color,c);
        color = c;
        for(int j=0;j<3;j++)
            frame[j] = i.change_image(frame[j]);
        repaint();
    }
    void resetColor()
    {
        ImageColorChange i = new ImageColorChange(color, Color.WHITE);
        color = Color.WHITE;
        for(int j=0;j<3;j++)
            frame[j] = i.change_image(frame[j]);
        repaint();
    }


}
