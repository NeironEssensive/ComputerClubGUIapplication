package org.example.compclubguiandspring.gui;

import org.example.compclubguiandspring.Utils.API;
import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainForm extends JFrame implements ActionListener {


    private Container c;
    private JLabel titleWelcome;
    private JLabel invoker;
    private JButton signIn;
    private JButton login;
    private JLabel backgroundLabel;
    private JLabel timeLabel;
    ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\photo_2024-09-28_16-30-31 (1).png");
    JLabel logotype = new JLabel(icon);

    public MainForm() {
        setTitle("InvokerQWE");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        backgroundLabel = new JLabel(new ImageIcon("src\\main\\resources\\icons\\accountBackground.jpg"));
        backgroundLabel.setLayout(new GridBagLayout());
        getContentPane().add(backgroundLabel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        logotype.setPreferredSize(new Dimension(800, 300));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        backgroundLabel.add(logotype, gbc);

        titleWelcome = new JLabel("Welcome to the club, buddy");
        titleWelcome.setFont(new Font("Arial", Font.BOLD, 28));
        titleWelcome.setForeground(new Color(70, 130, 180));
        titleWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        backgroundLabel.add(titleWelcome, gbc);

        invoker = new JLabel("Invoker");
        invoker.setFont(new Font("Arial", Font.BOLD, 28));
        invoker.setForeground(new Color(70, 130, 180));
        invoker.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 2;
        backgroundLabel.add(invoker, gbc);

        signIn = new JButton("Sign in");
        signIn.setFont(new Font("Arial", Font.PLAIN, 14));
        signIn.setBackground(new Color(50, 150, 50));
        signIn.setForeground(Color.BLACK);
        signIn.setFocusPainted(false);
        signIn.setPreferredSize(new Dimension(120, 35));
        signIn.addActionListener(this);

        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 14));
        login.setBackground(new Color(200, 50, 50));
        login.setForeground(Color.BLACK);
        login.setFocusPainted(false);
        login.setPreferredSize(new Dimension(120, 35));
        login.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(login);
        buttonPanel.add(signIn);

        gbc.gridy = 3;
        backgroundLabel.add(buttonPanel, gbc);

        // Добавляем пустой JLabel для заполнения пространства
        JLabel filler = new JLabel();
        gbc.gridx = 0; // Устанавливаем на первый столбец
        gbc.gridy = 0; // Устанавливаем на первый ряд
        gbc.weightx = 1; // Устанавливаем вес для заполнения
        gbc.weighty = 1; // Устанавливаем вес для заполнения
        backgroundLabel.add(filler, gbc);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        timeLabel.setForeground(Color.BLACK);
        gbc.gridx = 2; // Устанавливаем на третий столбец
        gbc.gridy = 0; // Устанавливаем на первый ряд
        gbc.anchor = GridBagConstraints.NORTHEAST; // Выравнивание по правому верхнему углу
        gbc.weightx = 0; // Устанавливаем вес для времени
        gbc.weighty = 0; // Устанавливаем вес для времени
        backgroundLabel.add(timeLabel, gbc);
        updateTime();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
    }
    private void updateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        timeLabel.setText(formatter.format(date));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signIn) {
            RegistrationForm registrationForm = new RegistrationForm();
            this.dispose();
        } else if (e.getSource() == login) {
            LoginForm loginForm = new LoginForm();
            this.dispose();
        }
    }
}
