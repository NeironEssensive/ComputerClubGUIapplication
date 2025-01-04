package org.example.compclubguiandspring.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame implements ActionListener {


    private Container c;
    private JLabel titleWelcome;
    private JLabel invoker;
    private JButton signIn;
    private JButton login;
    private JLabel backgroundLabel;
    ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\photo_2024-09-28_16-30-31 (1).png");
    JLabel logotype = new JLabel(icon);

    public MainForm() {
        setTitle("InvokerQWE");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        backgroundLabel = new JLabel(new ImageIcon("src\\main\\resources\\icons\\background.jpg"));
        backgroundLabel.setLayout(new GridBagLayout());
        getContentPane().add(backgroundLabel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        logotype.setPreferredSize(new Dimension(800, 300));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Занять 3 колонки
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
