package org.example.compclubguiandspring.gui;

import org.example.compclubguiandspring.Utils.API;
import org.example.compclubguiandspring.Utils.GameTimer;
import org.example.compclubguiandspring.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Account extends JFrame implements ActionListener {
    private JLabel balance;
    private Container c;
    private JLabel balanceText;
    private JButton balanceAddButton;
    private JButton tariffPay;
    private JButton exitSession;
    private JButton joinGameLibrary;
    private JLabel timerLabel;
    private JComboBox tariff;
    private User currentUser;
    private JSONObject weatherData;
    private GameTimer gameTimer;
    String[] listOfTariffs = {"1 hour = 200", "3 hours = 500", "8 hours = 1000"};
    JLabel tariffLabel;

    public Account(User user, GameTimer gameTimer) {
        this.currentUser = user;
        this.gameTimer = gameTimer;
        setTitle("InvokerQWE");
        setBounds(300, 90, 1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("src\\main\\resources\\icons\\accountBackground.jpg");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        getContentPane().add(backgroundPanel);

        tariff = new JComboBox<>(listOfTariffs);
        tariff.setFont(new Font("Serif", Font.PLAIN, 14));
        tariff.setSize(175, 50);
        tariff.setLocation(1000, 150);
        backgroundPanel.add(tariff);

        tariffLabel = new JLabel("Choose the tariff");
        tariffLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        tariffLabel.setSize(190, 100);
        tariffLabel.setLocation(1000, 75);
        backgroundPanel.add(tariffLabel);

        timerLabel = new JLabel("Time: 00:00:00");
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        timerLabel.setSize(150, 80);
        timerLabel.setLocation(10, 10);
        timerLabel.setForeground(Color.BLACK);
        backgroundPanel.add(timerLabel);

        balance = new JLabel("Balance: ");
        balance.setFont(new Font("Arial", Font.PLAIN, 20));
        balance.setSize(150, 80);
        balance.setLocation(1000, 0);
        balance.setForeground(Color.BLACK);
        backgroundPanel.add(balance);

        balanceText = new JLabel(String.valueOf(currentUser.getBalance()));
        balanceText.setFont(new Font("Arial", Font.PLAIN, 20));
        balanceText.setSize(150, 80);
        balanceText.setLocation(1100, 0);
        balanceText.setForeground(Color.BLACK);
        backgroundPanel.add(balanceText);

        exitSession = new JButton("Exit");
        exitSession.setFont(new Font("Arial", Font.PLAIN, 20));
        exitSession.setSize(175, 40);
        exitSession.setLocation(0, 723);
        exitSession.addActionListener(this);
        styleButton(exitSession);
        backgroundPanel.add(exitSession);

        joinGameLibrary = new JButton("Start playing");
        joinGameLibrary.setFont(new Font("Arial", Font.PLAIN, 20));
        joinGameLibrary.setSize(175, 40);
        joinGameLibrary.setLocation(1000, 275);
        joinGameLibrary.addActionListener(this);
        styleButton(joinGameLibrary);
        backgroundPanel.add(joinGameLibrary);

        tariffPay = new JButton("Pay");
        tariffPay.setFont(new Font("Arial", Font.PLAIN, 20));
        tariffPay.setSize(175, 40);
        tariffPay.setLocation(1000, 200);
        tariffPay.addActionListener(this);
        styleButton(tariffPay);
        backgroundPanel.add(tariffPay);

        balanceAddButton = new JButton("Deposit");
        balanceAddButton.setFont(new Font("Arial", Font.PLAIN, 15));
        balanceAddButton.setSize(150, 25);
        balanceAddButton.setLocation(1000, 60);
        balanceAddButton.addActionListener(this);
        styleButton(balanceAddButton);
        backgroundPanel.add(balanceAddButton);

        JPanel weatherPanel = new JPanel();
        weatherPanel.setLayout(new GridBagLayout());
        weatherPanel.setOpaque(false); // Делаем фон прозрачным
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel weatherConditionalImage = new JLabel();
        weatherConditionalImage.setPreferredSize(new Dimension(250, 217));
        gbc.gridx = 0;
        gbc.gridy = 0;
        weatherPanel.add(weatherConditionalImage, gbc);

        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 24));
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 1;
        weatherPanel.add(temperatureText, gbc);

        JLabel weatherConditionalDesc = new JLabel("Cloudy");
        weatherConditionalDesc.setFont(new Font("Dialog", Font.BOLD, 24));
        weatherConditionalDesc.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 2;
        weatherPanel.add(weatherConditionalDesc, gbc);

        weatherPanel.setBounds(400, 100, 400, 400);
        backgroundPanel.add(weatherPanel);



        if (gameTimer != null) {
            updateTimerDisplay();
            Timer refreshTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateTimerDisplay();
                }
            });
            refreshTimer.start();

        }

        String city = "kamyshin";
        weatherData = API.getWeatherData(city);
        String weatherCondition = (String) weatherData.get("weather_condition");
        switch(weatherCondition){
            case "Clear":
                weatherConditionalImage.setIcon(loadImage("src/main/resources/icons/clear.png"));
                break;
            case "Cloudy":
                weatherConditionalImage.setIcon(loadImage("src/main/resources/icons/cloudy.png"));
                break;
            case "Rain":
                weatherConditionalImage.setIcon(loadImage("src/main/resources/icons/rain.png"));
                break;
            case "Snow":
                weatherConditionalImage.setIcon(loadImage("src/main/resources/icons/snow.png"));
                break;
        }
        double temperature = (double) weatherData.get("temperature");
        temperatureText.setText(temperature + " C");
        weatherConditionalDesc.setText(weatherCondition);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(70, 130, 180)); // Цвет кнопки
        button.setForeground(Color.BLACK); // Цвет текста на кнопке
        button.setFocusPainted(false); // Убираем обводку при фокусе
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void updateTimerDisplay() {
        timerLabel.setText("Time: " + gameTimer.getCurrentTime());
        gameTimer.start();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void updateBalanceDisplay() {
        balanceText.setText(String.valueOf(currentUser.getBalance()));
    }

    private void convertTimeToMoney() {
        if (gameTimer != null) {
            int remainingHours = gameTimer.getRemainingHours();
            int refundAmount = remainingHours * 100;
            int currentBalance = currentUser.getBalance();
            currentUser.setBalance(currentBalance + refundAmount);
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
            Session session = null;
            try {

                session = factory.getCurrentSession();
                session.beginTransaction();
                session.update(currentUser);
                session.getTransaction().commit();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
                factory.close();
            }
            updateBalanceDisplay();
            JOptionPane.showMessageDialog(this, "You have received " + refundAmount + " for the remaining time.");
        }
    }
    private ImageIcon loadImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            return new ImageIcon(image);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Image not found");
        return null;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == joinGameLibrary) {
            if (this.gameTimer == null) {
                JOptionPane.showMessageDialog(this, "Pay the tariff to start playing");
                return;
            }
            GameLibrary game = new GameLibrary(gameTimer, currentUser);
            game.setVisible(true);
            this.dispose();
        }
        if (e.getSource() == exitSession) {
            convertTimeToMoney();
            MainForm mainForm = new MainForm();
            mainForm.setVisible(true);
            this.dispose();
        }
        if (e.getSource() == balanceAddButton) {
            Money money = new Money(this);
            money.setVisible(true);
            money.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        if (e.getSource() == tariffPay) {
            String selectedTariff = (String) tariff.getSelectedItem();
            int cost = Integer.parseInt(selectedTariff.split("=")[1].trim());
            int currentBalance = currentUser.getBalance();
            if (currentBalance >= cost) {
                SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory();
                Session session = null;
                try {
                    session = factory.getCurrentSession();
                    session.beginTransaction();
                    User currentUser = this.getCurrentUser();
                    int newBalance = currentUser.getBalance() - cost;
                    currentUser.setBalance(newBalance);
                    session.update(currentUser);
                    session.getTransaction().commit();
                    this.updateBalanceDisplay();
                    int hoursToAdd = 0;
                    if (selectedTariff.startsWith("1 hour")) {
                        hoursToAdd = 1;
                    } else if (selectedTariff.startsWith("3 hours")) {
                        hoursToAdd = 3;
                    } else if (selectedTariff.startsWith("8 hours")) {
                        hoursToAdd = 8;
                    }
                    if (gameTimer != null) {
                        gameTimer.setInitialTime(hoursToAdd);
                    } else {
                        gameTimer = new GameTimer(timerLabel);
                        gameTimer.setInitialTime(hoursToAdd);
                    }
                    gameTimer.stop();
                } finally {
                    if (session != null && session.isOpen()) {
                        session.close();
                    }
                    factory.close();
                }
                currentBalance -= cost;
                currentUser.setBalance(currentBalance);
                balanceText.setText(String.valueOf(currentBalance));
                JOptionPane.showMessageDialog(this, "Payment successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient balance!");
            }
        }
    }
}
