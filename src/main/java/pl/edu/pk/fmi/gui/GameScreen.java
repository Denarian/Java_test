package pl.edu.pk.fmi.gui;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_50_50;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_Phone;
import pl.edu.pk.fmi.java.Lifelines.Lifelines_Public_answer;
import pl.edu.pk.fmi.java.PlayerData.MainPlayer;
import pl.edu.pk.fmi.java.Questions.Question;
import pl.edu.pk.fmi.java.Questions.TextQuestions;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.*;

public class GameScreen extends JPanel implements ActionListener{
    public String question_strings[];
    JLabel scoreLabel;
    Answers answers;
    Question_panel question_panel;
    BufferedImage background_picture;
    Lifebuoys lifebuoys;
    JLabel friend_info;
    Question question;
    MainPlayer player;
    boolean state;

    Lifelines_50_50 life_50_50;
    Lifelines_Phone life_phone;
    Lifelines_Public_answer life_answer;

    public GameScreen(MainPlayer p, Question q) {
        player = p;
        question = q;

        life_50_50 = new Lifelines_50_50();
        life_phone = new Lifelines_Phone();
        life_answer = new Lifelines_Public_answer();
        player.AttachN(life_50_50);
        player.AttachN(life_phone);
        player.AttachN(life_answer);


        setPreferredSize(new Dimension(800, 600));
        try {
            background_picture = ImageIO.read(new File("graphic/background.jpg"));
        } catch (IOException ex) {
            System.out.println("Nie zaleziono pliku background.jpg");
        }


        question_strings = q.get_questtion();

        friend_info = new JLabel();
        friend_info.setBackground(new Color(0,0,0,0));
        friend_info.setOpaque(false);
        friend_info.setForeground(Color.WHITE);
        friend_info.setFont(friend_info.getFont().deriveFont(12.f));

        lifebuoys = new Lifebuoys(this);
        answers = new Answers(this);
        question_panel = new Question_panel();
        scoreLabel = new JLabel(""+player.GetPointCounter());
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(30.0f));
        setLayout(null);
        add(scoreLabel);
        add(question_panel);
        add(answers);
        add(lifebuoys);
        add(friend_info);
        scoreLabel.setBounds(635,263,100,50);
        lifebuoys.setBounds(250,310,300,80);
        friend_info.setBounds(10,300,240,100);
        answers.setBounds(0,400,800,200);
        question_panel.setBounds(80,40,600,230);

        question_panel.change_text(question_strings[0]);
        answers.update_content();


        state = false;

    }
    @Override
    protected void paintComponent(Graphics g) {

       g.drawImage(background_picture, 0, 0, null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
    }
    public void update_content()
    {
        question_strings = question.get_questtion();
        scoreLabel.setText(""+player.GetPointCounter());
        question_panel.change_text(question_strings[0]);
        answers.update_content();
        friend_info.setText("");
        friend_info.repaint();
    }
    public void update_content_fin()
    {
        scoreLabel.setText(""+player.GetPointCounter());
        question_panel.change_text(question_strings[0]);
        answers.update_content();
        friend_info.setText("");
        friend_info.repaint();
    }

}