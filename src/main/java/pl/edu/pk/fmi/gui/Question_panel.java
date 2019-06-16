package pl.edu.pk.fmi.gui;
import javax.swing.*;
import java.awt.*;

public class Question_panel extends JPanel
{
    JLabel text;
    public Question_panel()
    {
        text = new JLabel("TEST",SwingConstants.CENTER);
        setBackground(new Color(0,0,0,0));
        setOpaque(false);
        text.setForeground(Color.WHITE);
        text.setFont(text.getFont().deriveFont(20.0f));
        add(text);
    }
    void change_text(String s){
       text.setText(s);

    }

}
