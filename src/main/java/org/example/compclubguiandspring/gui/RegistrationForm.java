package org.example.compclubguiandspring.gui;


import org.example.compclubguiandspring.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Component
public class RegistrationForm extends JFrame implements ActionListener {
    private Container c;
    private JLabel title;
    private JLabel login;
    private JTextField textLogin;
    private JLabel password;
    private JLabel phone;
    private JPasswordField textPassword;
    private JTextField textPhone;
    private JLabel dateOfBirth;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JButton submitButton;
    private JLabel res;
    private JButton backButton;
    private JButton togglePasswordVisibilityButton;
    private boolean passwordVisible = false;

    private String dates[]
            = {"1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31"};
    private String months[]
            = {"Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec"};
    private String years[]
            = {"1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019"};

    public RegistrationForm() {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setBackground(new Color(240, 240, 240));
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(new Color(50, 50, 150));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        c.add(title, gbc);

        login = new JLabel("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        c.add(login, gbc);

        textLogin = new JTextField(15);
        textLogin.setFont(new Font("Arial", Font.PLAIN, 15));
        textLogin.setBackground(Color.WHITE);
        gbc.gridx = 1;
        c.add(textLogin, gbc);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        c.add(password, gbc);

        textPassword = new JPasswordField(15);
        textPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        textPassword.setBackground(Color.WHITE);
        textPassword.setEchoChar('•');
        gbc.gridx = 1;
        c.add(textPassword, gbc);

        ImageIcon showPasswordIcon = new ImageIcon("src/main/resources/icons/showPassword.jpg");
        ImageIcon hidePasswordIcon = new ImageIcon("src/main/resources/icons/hidePassword.jpg");

        togglePasswordVisibilityButton = new JButton(showPasswordIcon);
        togglePasswordVisibilityButton.setFont(new Font("Arial", Font.PLAIN, 15));
        togglePasswordVisibilityButton.setPreferredSize(new Dimension(25, 25));
        togglePasswordVisibilityButton.setBackground(Color.WHITE);
        togglePasswordVisibilityButton.setFocusPainted(false);
        togglePasswordVisibilityButton.setBorderPainted(false);
        gbc.gridx = 2;
        c.add(togglePasswordVisibilityButton, gbc);
        togglePasswordVisibilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordVisible = !passwordVisible;
                if (passwordVisible) {
                    textPassword.setEchoChar((char) 0);
                    togglePasswordVisibilityButton.setIcon(hidePasswordIcon); // Меняем иконку на "скрыть"
                } else {
                    textPassword.setEchoChar('•');
                    togglePasswordVisibilityButton.setIcon(showPasswordIcon); // Меняем иконку на "показать"
                }
            }
        });

        phone = new JLabel("Phone");
        phone.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 3;
        c.add(phone, gbc);

        textPhone = new JTextField(15);
        textPhone.setFont(new Font("Arial", Font.PLAIN, 15));
        textPhone.setBackground(Color.WHITE);
        gbc.gridx = 1;
        c.add(textPhone, gbc);

        dateOfBirth = new JLabel("DOB");
        dateOfBirth.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 4;
        c.add(dateOfBirth, gbc);

        JPanel dobPanel = new JPanel();
        dobPanel.setLayout(new FlowLayout());
        date = new JComboBox<>(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        dobPanel.add(date);

        month = new JComboBox<>(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        dobPanel.add(month);

        year = new JComboBox<>(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        dobPanel.add(year);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        c.add(dobPanel, gbc);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
        submitButton.setBackground(new Color(50, 150, 50));
        submitButton.setForeground(Color.BLACK);
        submitButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        c.add(submitButton, gbc);

        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButton.setBackground(new Color(70, 170, 70));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButton.setBackground(new Color(50, 150, 50));
            }
        });

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setForeground(new Color(255, 0, 0));
        res.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        c.add(res, gbc);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 15));
        backButton.setBackground(new Color(200, 50, 50)); // Красный цвет
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(this);
        GridBagConstraints gbcBack = new GridBagConstraints();
        gbcBack.gridx = 0;
        gbcBack.gridy = 7; // Позиция под результатом
        gbcBack.gridwidth = 2;
        gbcBack.fill = GridBagConstraints.HORIZONTAL;
        c.add(backButton, gbcBack);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            MainForm mainForm = new MainForm();
            mainForm.setVisible(true);
            this.dispose();

        }
        if (e.getSource() == submitButton) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
            Session session = null;
            try {
                session = factory.getCurrentSession();
                String loginValue = textLogin.getText();
                String passwordValue = new String(textPassword.getPassword());
                String phoneValue = textPhone.getText();
                session.beginTransaction();
                Query<User> query = session.createQuery("from User where login = :loginValue", User.class);
                query.setParameter("loginValue", loginValue);
                List<User> users = query.list();
                if (loginValue.isEmpty()) {
                    res.setText("Login must not be empty");
                } else if (!users.isEmpty()) {
                    res.setText("This login is "
                            + " already exists");
                } else if (passwordValue.isEmpty()) {
                    res.setText("Password must not be empty");
                } else if (phoneValue.isEmpty()) {
                    res.setText("Fill phone number for"
                            + " registration");
                } else if (phoneValue.length() != 11) {
                    res.setText("Phone number must be 11 digits");
                } else if (loginValue.length() < 4) {
                    res.setText("Login must have at least 4 characters");
                } else if (loginValue.length() > 15) {
                    res.setText("Login must have at most 15 characters");
                } else {
                    User user = new User();
                    user.setLogin(loginValue);
                    user.setPassword(passwordValue);
                    user.setPhone(phoneValue);
                    session.save(user);
                    Thread thread = new Thread();
                    thread.start();
                    Thread.sleep(5000);
                    LoginForm loginForm = new LoginForm();
                    this.dispose();
                }
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
                factory.close();
            }
        }
    }
}


