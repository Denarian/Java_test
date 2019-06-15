package pl.edu.pk.fmi.gui;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.*;

public class GameScreen extends JPanel implements ActionListener{
    public int score = 10000;
    public String answer[];
    JLabel scoreLabel;
    Answers answers;
    Question question;
    BufferedImage background_picture;
    Lifebuoys lifebuoys;
    public GameScreen() {
        setPreferredSize(new Dimension(800, 600));

        try {
            background_picture = ImageIO.read(new File("graphic/background.jpg"));
        } catch (IOException ex) {
            System.out.println("Nie zaleziono pliku background.jpg");
        }
        answer = new String[4];
        answer[0] = "Odpowiedz1 \n loll\n adasd";
        answer[1] = "Odpowiedz2 \n loll\n adasd";
        answer[2] = "Odpowiedz3 \n loll\n adasd";
        answer[3] = "Odpowiedz4 \n loll\n adasd";
        lifebuoys = new Lifebuoys();
        answers = new Answers(this);
        question = new Question();
        scoreLabel = new JLabel(""+score);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(30.0f));
        setLayout(null);
        add(scoreLabel);
        add(question);
        add(answers);
        add(lifebuoys);
        scoreLabel.setBounds(635,263,100,50);
        lifebuoys.setBounds(250,320,300,80);
        answers.setBounds(0,400,800,200);
        question.setBounds(100,100,400,500);
    }
    @Override
    protected void paintComponent(Graphics g) {

       g.drawImage(background_picture, 0, 0, null);


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