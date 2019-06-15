package pl.edu.pk.fmi.gui;

import javax.swing.*;

public class Gui extends JFrame{
    private JPanel Game;
    private JPanel Menu;
    private JPanel panel;
    public Gui() {
        super("Bankruci");
        Game = new GameScreen();
        panel = Game;
        add(panel);
        setSize(800, 600);
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
