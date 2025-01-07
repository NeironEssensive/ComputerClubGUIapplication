package org.example.compclubguiandspring.gui;

import org.example.compclubguiandspring.Utils.GameTimer;
import org.example.compclubguiandspring.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameLibrary extends JFrame implements ActionListener {
    ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\photo_2024-09-28_16-30-31 (1).png");
    ImageIcon iconSteam = new ImageIcon("src\\main\\resources\\icons\\Steam_icon_logo.svg.png");
    ImageIcon iconDota = new ImageIcon("src\\main\\resources\\icons\\dotalogo0.png");
    ImageIcon iconCS = new ImageIcon("src\\main\\resources\\icons\\cslogo0.jpg");
    ImageIcon iconBrawlHalla = new ImageIcon("src\\main\\resources\\icons\\brawlhallalogo0.png");
    ImageIcon iconDBD = new ImageIcon("src\\main\\resources\\icons\\deadbydaylightlogo0.png");
    ImageIcon iconValorant = new ImageIcon("src\\main\\resources\\icons\\valorantlogo0.png");
    ImageIcon iconFortnite = new ImageIcon("src\\main\\resources\\icons\\fortnitelogo0.jpg");
    ImageIcon iconLOL = new ImageIcon("src\\main\\resources\\icons\\lollogo0.jpg");
    ImageIcon iconDiscord = new ImageIcon("src\\main\\resources\\icons\\discordlogo0.jpg");
    ImageIcon iconGHub = new ImageIcon("src\\main\\resources\\icons\\ghublogo0.jpg");
    JLabel logotype = new JLabel(icon);
    private JButton launchSteamButton;
    private JButton launchDotaButton;
    private JButton launchBrawlhallaButton;
    private JButton launchCounterStrikeButton;
    private JButton launchDBDButton;
    private JButton launchValorantButton;
    private JButton launchFortniteButton;
    private JButton launchLOLButton;
    private JButton launchDiscordButton;
    private JButton launchGHubButton;

    private Container c;
    private JLabel timerLabel;
    private JButton backToAccount;
    private User currentUser;
    private GameTimer gameTimer;

    public GameLibrary(GameTimer gameTimer, User user) {
        this.gameTimer = gameTimer;
        this.currentUser = user;

        setTitle("InvokerQWE");
        setBounds(300, 90, 1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("src\\main\\resources\\icons\\accountBackground.jpg"); // Замените на ваше изображение
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        getContentPane().add(backgroundPanel);

        JLabel logotype = new JLabel(icon);
        logotype.setBounds(175, -100, 800, 600);
        backgroundPanel.add(logotype);

        timerLabel = new JLabel("Time: 00:00:00");
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        timerLabel.setSize(150, 80);
        timerLabel.setLocation(1000, 10);
        timerLabel.setForeground(Color.black);
        backgroundPanel.add(timerLabel);

        updateTimerDisplay();
        Timer refreshTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimerDisplay();
            }
        });
        refreshTimer.start();
        gameTimer.start();

        backToAccount = new JButton("Account");
        backToAccount.setFont(new Font("Arial", Font.PLAIN, 20));
        backToAccount.setSize(150, 80);
        backToAccount.setLocation(0, 0);
        backToAccount.addActionListener(this);
        styleButton(backToAccount);
        backgroundPanel.add(backToAccount);

        launchSteamButton = createGameButton("Steam", iconSteam, 500, 500);
        launchDotaButton = createGameButton("Dota 2", iconDota, 300, 500);
        launchBrawlhallaButton = createGameButton("BrawlHalla", iconBrawlHalla, 700, 500);
        launchCounterStrikeButton = createGameButton("CS2", iconCS, 100, 500);
        launchDBDButton = createGameButton("DBD", iconDBD, 900, 500);
        launchValorantButton = createGameButton("Valorant", iconValorant, 500, 600);
        launchFortniteButton = createGameButton("Fortnite", iconFortnite, 300, 600);
        launchLOLButton = createGameButton("LoL", iconLOL, 700, 600);
        launchDiscordButton = createGameButton("Discord", iconDiscord, 100, 600);
        launchGHubButton = createGameButton("GHub", iconGHub, 900, 600);
        backgroundPanel.add(launchSteamButton);
        backgroundPanel.add(launchDotaButton);
        backgroundPanel.add(launchBrawlhallaButton);
        backgroundPanel.add(launchCounterStrikeButton);
        backgroundPanel.add(launchDBDButton);
        backgroundPanel.add(launchValorantButton);
        backgroundPanel.add(launchFortniteButton);
        backgroundPanel.add(launchLOLButton);
        backgroundPanel.add(launchDiscordButton);
        backgroundPanel.add(launchGHubButton);

        setVisible(true);

    }

    private JButton createGameButton(String text, ImageIcon icon, int x, int y) {
        JButton button = new JButton(text, icon);
        button.setFont(new Font("Arial", Font.PLAIN, 15));
        button.setSize(175, 65);
        button.setLocation(x, y);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener(this);
        return button;
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.black);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void updateTimerDisplay() {
        if (gameTimer != null) {
            timerLabel.setText("Time: " + gameTimer.getCurrentTime());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backToAccount) {
            Account account = new Account(currentUser, gameTimer);
            account.setVisible(true);
            account.updateTimerDisplay();
            this.dispose();
        }
        if (e.getSource() == launchSteamButton) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == launchBrawlhallaButton) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == launchDiscordButton) {
            try {
                Runtime.getRuntime().exec("C:\\Users\\aglus\\AppData\\Local\\Discord\\app-1.0.9164\\Discord.exe");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == launchDotaButton) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1       ");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == launchValorantButton) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == launchLOLButton) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == launchGHubButton) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == launchDBDButton) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == launchCounterStrikeButton) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == launchFortniteButton) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
