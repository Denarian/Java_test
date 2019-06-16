package pl.edu.pk.fmi.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageColorChange {
    Color t,s;
    public ImageColorChange(Color source, Color target)
    {
        t = target;
        s = source;
    }

    BufferedImage change_image(BufferedImage image)
    {
        // get width and height
        int width = image.getWidth();
        int height = image.getHeight();

        // convert to green image
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
               if(s.getRGB() == image.getRGB(x,y))
               {
                   image.setRGB(x, y, t.getRGB());
               }

            }
        }
        return image;
    }


}
