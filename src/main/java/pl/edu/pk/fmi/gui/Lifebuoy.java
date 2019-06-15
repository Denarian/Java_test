package pl.edu.pk.fmi.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Lifebuoy extends JButton {
    BufferedImage image;
    boolean image_ok;
    public Lifebuoy(String file)
    {
        setBorder(null);
        setOpaque(false);
        setPreferredSize(new Dimension(80,80));
        image_ok = true;
        try {
            image = ImageIO.read(new File(file));
        } catch (IOException ex) {
            System.out.println("Nie zaleziono pliku "+file);
            image_ok = false;
        }
        ImageColorToRed ItR = new ImageColorToRed(Color.WHITE);
        image = ItR.change_image(image);


    }
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        if(image_ok) g.drawImage(image,0,0,getWidth(),getHeight(),this);
        else g2d.fillRect(0,0,80,80);
    }
}
