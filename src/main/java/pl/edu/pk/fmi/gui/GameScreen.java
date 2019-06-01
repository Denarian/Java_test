package pl.edu.pk.fmi.gui;
import java.awt.*;
import java.awt.geom.*;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
    public MyPanel() {
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}