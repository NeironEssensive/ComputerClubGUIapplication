package org.example.compclubguiandspring.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame implements ActionListener {


    private Container c;
    private JLabel titleWelcome;
    private JLabel invoker;
    private JLabel invokerQ;
    private JLabel invokerW;
    private JLabel invokerE;
    private JButton signIn;
    private JButton login;
    ImageIcon icon = new ImageIcon("C:\\Users\\aglus\\IdeaProjects\\CompClubGUIandSpring\\src\\main\\resources\\photo_2024-09-28_16-30-31 (1).jpg");
    JLabel logotype = new JLabel(icon);


public MainForm(){
    setTitle("InvokerQWE");
    setBounds(300, 90, 900, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    c = getContentPane();
    c.setLayout(null);

    logotype.setBounds(40, -30, 800, 600);
    logotype.setIcon(icon);
    c.add(logotype);


    titleWelcome = new JLabel("Welcome to the club, buddy");
    titleWelcome.setFont(new Font("Arial", Font.PLAIN, 30));
    titleWelcome.setSize(600, 30);
    titleWelcome.setLocation(250, 15);
    c.add(titleWelcome);

    invoker = new JLabel("Invoker");
    invoker.setFont(new Font("Arial", Font.PLAIN, 30));
    invoker.setSize(600, 30);
    invoker.setLocation(360, 50);
    c.add(invoker);

    invokerQ = new JLabel("Q");
    invokerQ.setFont(new Font("Arial", Font.PLAIN, 30));
    invokerQ.setSize(600, 30);
    invokerQ.setLocation(470, 50);
    invokerQ.setForeground(Color.blue);
    c.add(invokerQ);

    invokerW = new JLabel("W");
    invokerW.setFont(new Font("Arial", Font.PLAIN, 30));
    invokerW.setSize(600, 30);
    invokerW.setLocation(491, 50);
    invokerW.setForeground(Color.magenta);
    c.add(invokerW);

    invokerE = new JLabel("E");
    invokerE.setFont(new Font("Arial", Font.PLAIN, 30));
    invokerE.setSize(600, 30);
    invokerE.setLocation(520, 50);
    invokerE.setForeground(Color.ORANGE);
    c.add(invokerE);


    signIn = new JButton("Sign in");
    signIn.setFont(new Font("Arial", Font.PLAIN, 15));
    signIn.setSize(150, 40);
    signIn.setLocation(580, 250);
    signIn.addActionListener(this);
    c.add(signIn);

    login = new JButton("Login");
    login.setFont(new Font("Arial", Font.PLAIN, 15));
    login.setSize(150, 40);
    login.setLocation(150, 250);
    login.addActionListener(this);
    c.add(login);

}
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == signIn){
        RegistrationForm registrationForm = new RegistrationForm();
        this.dispose();
    }
    else if(e.getSource() == login){
        this.dispose();
    }
    }



}
