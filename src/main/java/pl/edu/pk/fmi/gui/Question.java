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
        setOpaque(false);
        add(text);
        text.setForeground(Color.WHITE);
        text.setFont(getFont().deriveFont(30.0f));
    }

}
