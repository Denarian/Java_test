package pl.edu.pk.fmi.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class GameScreen extends JPanel implements ActionListener{
    public int score = 10;
    public String answer[];
    JLabel scoreLabel;
    Answers answers;
    Question question;
    public GameScreen() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.GREEN);
        answer = new String[4];
        answer[0] = "Odpowiedz1 \n loll\n adasd";
        answer[1] = "Odpowiedz2 \n loll\n adasd";
        answer[2] = "Odpowiedz3 \n loll\n adasd";
        answer[3] = "Odpowiedz4 \n loll\n adasd";
        answers = new Answers(this);
        question = new Question();
        scoreLabel = new JLabel(""+score);
        setLayout(new BorderLayout());
        add(scoreLabel, BorderLayout.NORTH);
        add(question, BorderLayout.CENTER);
        add(answers, BorderLayout.SOUTH);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
    }
    public void update()
    {
        scoreLabel.setText(""+score);
    }

}