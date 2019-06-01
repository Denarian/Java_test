package pl.edu.pk.fmi.gui;

import javax.swing.*;
import java.awt.*;

public class MenuScreen extends JPanel {
    public MenuScreen() {
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.RED);

    }
}