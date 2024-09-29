package org.example.compclubguiandspring.gui;


import org.example.compclubguiandspring.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class RegistrationForm extends JFrame implements ActionListener {
    private Container c;
    private JLabel title;
    private JLabel login;
    private JTextField textLogin;
    private JLabel password;
    private JLabel phone;
    private JTextField textPassword;
    private JTextField textPhone;
    private JLabel dateOfBirth;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JCheckBox term;
    private JButton submitButton;
    private JButton resetButton;
    private JTextArea finishText;
    private JLabel res;
    private JTextArea resadd;

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };
    // constructor, to initialize the components
    // with default values.
    public RegistrationForm()
    {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        login = new JLabel("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 20));
        login.setSize(100, 20);
        login.setLocation(100, 100);
        c.add(login);

        textLogin = new JTextField();
        textLogin.setFont(new Font("Arial", Font.PLAIN, 15));
        textLogin.setSize(190, 20);
        textLogin.setLocation(200, 100);
        c.add(textLogin);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(100, 150);
        c.add(password);

        textPassword = new JTextField();
        textPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        textPassword.setSize(190, 20);
        textPassword.setLocation(200, 150);
        c.add(textPassword);

        phone = new JLabel("Phone");
        phone.setFont(new Font("Arial", Font.PLAIN, 20));
        phone.setSize(100, 20);
        phone.setLocation(100, 200);
        c.add(phone);

        textPhone = new JTextField();
        textPhone.setFont(new Font("Arial", Font.PLAIN, 15));
        textPhone.setSize(150, 20);
        textPhone.setLocation(200, 200);
        c.add(textPhone);


        dateOfBirth = new JLabel("DOB");
        dateOfBirth.setFont(new Font("Arial", Font.PLAIN, 20));
        dateOfBirth.setSize(100, 20);
        dateOfBirth.setLocation(100, 250);
        c.add(dateOfBirth);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 250);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 250);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 250);
        c.add(year);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
        submitButton.setSize(100, 20);
        submitButton.setLocation(150, 450);
        submitButton.addActionListener(this);
        c.add(submitButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setSize(100, 20);
        resetButton.setLocation(270, 450);
        resetButton.addActionListener(this);
        c.add(resetButton);

        finishText = new JTextArea();
        finishText.setFont(new Font("Arial", Font.PLAIN, 15));
        finishText.setSize(300, 400);
        finishText.setLocation(500, 100);
        finishText.setLineWrap(true);
        finishText.setEditable(false);
        c.add(finishText);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);



    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submitButton) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
            Session session = null;
            try {
                session = factory.getCurrentSession();
                String loginValue = textLogin.getText();
                String passwordValue = textPassword.getText();
                String phoneValue = textPhone.getText();
                session.beginTransaction();
                if (loginValue.isEmpty()) {
                    res.setText("Login must not be empty"
                            + " for registration..");
                } else if (passwordValue.isEmpty()) {
                    res.setText("Password must not be empty"
                            + " for registration..");
                } else if (phoneValue.isEmpty()) {
                    res.setText("Fill phone number for"
                            + " registration..");
                } else {
                    if (term.isSelected()) {
                        User user = new User();
                        user.setLogin(loginValue);
                        user.setPassword(passwordValue);
                        user.setPhone(phoneValue);
                        session.save(user);
                        String data
                                = "Login : "
                                + textLogin.getText() + "\n"
                                + "Password : "
                                + textPassword.getText() + "\n"
                                + "Phone Number : +"
                                + textPhone.getText() + "\n";


                        String data2
                                = "DOB : "
                                + (String) date.getSelectedItem()
                                + "/" + (String) month.getSelectedItem()
                                + "/" + (String) year.getSelectedItem()
                                + "\n";

                        finishText.setText(data + data2);
                        finishText.setEditable(false);
                        res.setText("Registration Successfully..");
                        Thread thread = new Thread();
                        thread.start();
                        Thread.sleep(5000);
                        LoginForm loginForm = new LoginForm();
                        this.dispose();
                    } else {
                        finishText.setText("");
                        resadd.setText("");
                        res.setText("Please accept the"
                                + " terms & conditions..");
                    }
                }
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } finally {
                session.close();
                factory.close();
            }
        }

        else if (e.getSource() == resetButton) {
            String def = "";
            textLogin.setText(def);
            textPhone.setText(def);
            textPassword.setText(def);
            res.setText(def);
            finishText.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            resadd.setText(def);
        }
    }
}


