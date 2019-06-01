package pl.edu.pk.fmi.gui;
import java.awt.*;
import java.awt.geom.*;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
    public GameScreen() {
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.GREEN);

    }
}