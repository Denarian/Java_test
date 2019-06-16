package pl.edu.pk.fmi.gui;

import pl.edu.pk.fmi.java.PlayerData.MainPlayer;
import pl.edu.pk.fmi.java.Questions.Question;

import javax.swing.*;

public class Gui extends JFrame{
    private JPanel Game;
    private JPanel Menu;
    private JPanel panel;
    public Gui(MainPlayer p, Question q) {
        super("Bankruci");
        Game = new GameScreen(p,q);
        panel = Game;
        add(panel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
