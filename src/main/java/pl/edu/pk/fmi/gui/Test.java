package pl.edu.pk.fmi.gui;

import java.awt.EventQueue;


public class Test {
    public static void main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui();
            }
        });
    }
}