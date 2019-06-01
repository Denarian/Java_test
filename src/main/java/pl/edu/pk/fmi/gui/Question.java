package pl.edu.pk.fmi.gui;
import javax.swing.*;
import java.awt.*;

public class Question  extends JPanel
{
    JLabel text;
    public Question()
    {
        text = new JLabel("TEST");
        setBackground(Color.yellow);
        add(text);
    }

}
