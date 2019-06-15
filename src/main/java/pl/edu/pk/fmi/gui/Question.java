package pl.edu.pk.fmi.gui;
import javax.swing.*;
import java.awt.*;

public class Question  extends JPanel
{
    JLabel text;
    public Question()
    {
        text = new JLabel("TEST");
        setBackground(new Color(0,0,0,0));
        text.setForeground(Color.WHITE);
        text.setFont(text.getFont().deriveFont(30.0f));
        add(text);
    }

}
