package org.example.compclubguiandspring.gui;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginForm extends JFrame implements ActionListener {
    JFrame jframe;
    JButton loginButton;
    JTextField loginText;
    JPasswordField password;
    JLabel usernameError;
    JLabel passwordError;


    public LoginForm() {
        jframe = new JFrame("Login Form");
        loginText = new JTextField() ;
        password = new JPasswordField();

        loginButton = new JButton("LOGIN") ;

        usernameError = new JLabel();
        passwordError = new JLabel();

        jframe.setContentPane(new JPanel());
        loginText.setPreferredSize(new Dimension(250,35));
        password.setPreferredSize(new Dimension(250,35));
        loginButton.setPreferredSize(new Dimension(250,35));
        loginButton.setBackground(new Color(66, 245, 114));
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(this);

        loginText.setText("Enter your login");
        loginText.setForeground(Color.gray);
        password.setText("Enter your password");
        password.setForeground(Color.gray);
        password.setEchoChar((char)0);

        usernameError.setFont(new Font("SansSerif", Font.BOLD, 11));
        usernameError.setForeground(Color.RED);

        passwordError.setFont(new Font("SansSerif", Font.BOLD, 11));
        passwordError.setForeground(Color.RED);

        jframe.setLayout(new GridBagLayout());

        Insets textInsets = new Insets(10, 10, 5, 10);
        Insets buttonInsets = new Insets(20, 10, 10, 10);
        Insets errorInsets = new Insets(0,20,0,0);

        GridBagConstraints input = new GridBagConstraints();
        input.anchor = GridBagConstraints.CENTER;
        input.insets = textInsets;
        input.gridy = 1;
        jframe.add(loginText,input);

        input.gridy = 2;
        input.insets = errorInsets;
        input.anchor = GridBagConstraints.WEST;
        jframe.add(usernameError,input);

        input.gridy = 3;
        input.insets = textInsets;
        input.anchor = GridBagConstraints.CENTER;
        jframe.add(password,input);

        input.gridy = 4;
        input.insets = errorInsets;
        input.anchor = GridBagConstraints.WEST;
        jframe.add(passwordError,input);

        input.insets = buttonInsets;
        input.anchor = GridBagConstraints.WEST;
        input.gridx = 0;
        input.gridy = 5;
        jframe.add(loginButton,input);

        jframe.setSize(950,650);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        jframe.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            GameLibrary gameLibrary = new GameLibrary();
            gameLibrary.setVisible(true);
            jframe.dispose();
        }
    }
}
