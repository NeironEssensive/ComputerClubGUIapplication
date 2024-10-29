package org.example.compclubguiandspring.gui;

import org.example.compclubguiandspring.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class LoginForm extends JFrame implements ActionListener {
    JFrame jframe;
    JButton loginButton;
    JTextField loginText;
    JTextField passwordText;
    JLabel usernameError;
    JLabel passwordError;
    public LoginForm() {
        jframe = new JFrame("Login Form");
        loginText = new JTextField() ;
        passwordText = new JTextField();

        loginButton = new JButton("LOGIN") ;

        usernameError = new JLabel();
        passwordError = new JLabel();

        jframe.setContentPane(new JPanel());
        loginText.setPreferredSize(new Dimension(250,35));
        passwordText.setPreferredSize(new Dimension(250,35));
        loginButton.setPreferredSize(new Dimension(250,35));
        loginButton.setBackground(new Color(66, 245, 114));
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(this);

        loginText.setText("Enter your login");
        loginText.setForeground(Color.gray);
        passwordText.setText("Enter your password");
        passwordText.setForeground(Color.gray);

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
        jframe.add(passwordText,input);

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
        if (e.getSource() == loginButton) {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
            Session session = null;
            try {
                session = sessionFactory.getCurrentSession();
                if (session != null) {
                    session.beginTransaction();
                    String textLogin = loginText.getText();
                    Query<User> query = session.createQuery("from User where login = :textLogin", User.class);
                    query.setParameter("textLogin", textLogin);
                    List<User> users = query.list();
                    if (!users.isEmpty()) {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        String password = passwordText.getText();

                        User foundUser = users.get(0);
                        if (foundUser.getPassword().equals(password)) {
                            GameLibrary gameLibrary = new GameLibrary();
                            gameLibrary.setVisible(true);
                            this.jframe.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Логин или пароль не верны.", "Ошибка входа", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Пользователь с таким логином не найден.", "Ошибка входа", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } catch (Exception ex) {
                    System.out.println("Не удалось выполнить запрос: " + ex.getMessage());
                } finally {
                    if (session != null && session.isOpen()) {
                        session.close();
                    }
                    sessionFactory.close();
                }
        }
    }
    }
