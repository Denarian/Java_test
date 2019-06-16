package pl.edu.pk.fmi.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LifebuoyDecorator extends Lifebuoy {

    BufferedImage image;
    boolean image_ok;
    Lifebuoy o;
    public LifebuoyDecorator(Lifebuoy oo)
    {
        o = oo;
        setBorder(null);
        setOpaque(false);
        setPreferredSize(new Dimension(80,80));
        try {
            image = ImageIO.read(new File("graphic/x.png"));
            image_ok = true;
        } catch (IOException ex) {
            System.out.println("Nie zaleziono pliku x.png");
            image_ok = false;
        }
    }
    public void  paintComponent(Graphics g)
    {
        o.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        if(image_ok) g.drawImage(image,10,10,getWidth()-20,getHeight()-20,o);
        else g2d.fillRect(10,10,60,60);

    }
}
