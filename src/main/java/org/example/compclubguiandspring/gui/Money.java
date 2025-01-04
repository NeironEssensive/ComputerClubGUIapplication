package org.example.compclubguiandspring.gui;

import org.example.compclubguiandspring.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Money extends JFrame implements ActionListener {
    JLabel amount;
    Container c;
    JTextField balanceField;
    JButton addBalance;
    Account account;


    public Money(Account account) {
        this.account = account;
        setTitle("InvokerQWE");
        setBounds(300, 90, 400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.lightGray);

        addBalance = new JButton("Add Balance");
        addBalance.addActionListener(this);
        addBalance.setFont(new Font("Tahoma", Font.PLAIN, 12));
        addBalance.setLocation(100, 100);
        addBalance.setSize(190, 20);
        c.add(addBalance);


        amount = new JLabel();
        amount.setFont(new Font("Arial", Font.PLAIN, 17));
        amount.setText("Select the amount");
        amount.setBounds(10, 10, 200, 30);
        amount.setLocation(125, 25);
        c.add(amount);

        balanceField = new JTextField();
        balanceField.setFont(new Font("Arial", Font.PLAIN, 15));
        balanceField.setSize(190, 20);
        balanceField.setLocation(100, 75);
        c.add(balanceField);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBalance) {
            String amountText = balanceField.getText();
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
            Session session = null;
            try {
                session = factory.getCurrentSession();
                int amount = Integer.parseInt(amountText);
                session.beginTransaction();
                User currentUser = account.getCurrentUser();
                int newBalance = currentUser.getBalance() + amount;
                currentUser.setBalance(newBalance);
                session.update(currentUser);
                session.getTransaction().commit();
                account.updateBalanceDisplay();
                JOptionPane.showMessageDialog(this, "Deposit successful!");
                dispose();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
                factory.close();
            }
        }
    }
}
