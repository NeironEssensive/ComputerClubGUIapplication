package org.example.compclubguiandspring.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameLibrary extends JFrame implements ActionListener {
    JLabel balance;
    JLabel balanceText;
    JButton balanceAddButton;
    private Container c;
    ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\photo_2024-09-28_16-30-31 (1).jpg");
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
    GameLibrary(){
        setTitle("InvokerQWE");
        setBounds(300, 90, 1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.lightGray);
        logotype.setBounds(175, -100, 800, 600);
        logotype.setIcon(icon);
        c.add(logotype);


        launchSteamButton = new JButton("Steam", iconSteam);
        launchSteamButton.setFont(new Font("Arial", Font.PLAIN, 15));
        launchSteamButton.setSize(175, 65); //icon 50x50
        launchSteamButton.setLocation(500, 500);
        launchSteamButton.addActionListener(this);
        c.add(launchSteamButton);


        launchDotaButton = new JButton("Dota 2", iconDota);
        launchDotaButton.setFont(new Font("Arial", Font.PLAIN, 15));
        launchDotaButton.setSize(175, 65); //icon 50x50
        launchDotaButton.setLocation(300, 500);
        launchDotaButton.addActionListener(this);
        c.add(launchDotaButton);

        launchBrawlhallaButton = new JButton("BrawlHalla", iconBrawlHalla);
        launchBrawlhallaButton.setFont(new Font("Arial", Font.PLAIN, 15));
        launchBrawlhallaButton.setSize(175, 65); //icon 50x50
        launchBrawlhallaButton.setLocation(700, 500);
        launchBrawlhallaButton.addActionListener(this);
        c.add(launchBrawlhallaButton);

        launchCounterStrikeButton = new JButton("CS2", iconCS);
        launchCounterStrikeButton.setFont(new Font("Arial", Font.PLAIN, 15));
        launchCounterStrikeButton.setSize(175, 65); //icon 50x50
        launchCounterStrikeButton.setLocation(100, 500);
        launchCounterStrikeButton.addActionListener(this);
        c.add(launchCounterStrikeButton);

        launchDBDButton = new JButton("DBD", iconDBD);
        launchDBDButton.setFont(new Font("Arial", Font.PLAIN, 15));
        launchDBDButton.setSize(175, 65); //icon 50x50
        launchDBDButton.setLocation(900, 500);
        launchDBDButton.addActionListener(this);
        c.add(launchDBDButton);

        launchValorantButton = new JButton("Valorant", iconValorant);
        launchValorantButton.setFont(new Font("Arial", Font.PLAIN, 15));
        launchValorantButton.setSize(175, 65); //icon 50x50
        launchValorantButton.setLocation(500, 600);
        launchValorantButton.addActionListener(this);
        c.add(launchValorantButton);

        launchFortniteButton = new JButton("Fortnite", iconFortnite);
        launchFortniteButton.setFont(new Font("Arial", Font.PLAIN, 15));
        launchFortniteButton.setSize(175, 65); //icon 50x50
        launchFortniteButton.setLocation(300, 600);
        launchFortniteButton.addActionListener(this);
        c.add(launchFortniteButton);

        launchLOLButton = new JButton("LoL", iconLOL);
        launchLOLButton.setFont(new Font("Arial", Font.PLAIN, 15));
        launchLOLButton.setSize(175, 65); //icon 50x50
        launchLOLButton.setLocation(700, 600);
        launchLOLButton.addActionListener(this);
        c.add(launchLOLButton);

        launchDiscordButton = new JButton("Discord", iconDiscord);
        launchDiscordButton.setFont(new Font("Arial", Font.PLAIN, 15));
        launchDiscordButton.setSize(175, 65); //icon 50x50
        launchDiscordButton.setLocation(100, 600);
        launchDiscordButton.addActionListener(this);
        c.add(launchDiscordButton);

        launchGHubButton = new JButton("GHub", iconGHub);
        launchGHubButton.setFont(new Font("Arial", Font.PLAIN, 15));
        launchGHubButton.setSize(175, 65); //icon 50x50
        launchGHubButton.setLocation(900, 600);
        launchGHubButton.addActionListener(this);
        c.add(launchGHubButton);

        balance = new JLabel("Balance : ");
        balance.setFont(new Font("Arial", Font.PLAIN, 20));
        balance.setSize(150,80);
        balance.setLocation(1000,0);
        c.add(balance);

        balanceText = new JLabel("0");
        balanceText.setFont(new Font("Arial", Font.PLAIN, 20));
        balanceText.setSize(150,80);
        balanceText.setLocation(1100,0);
        c.add(balanceText);

        balanceAddButton = new JButton("Deposit");
        balanceAddButton.setFont(new Font("Arial", Font.PLAIN, 15));
        balanceAddButton.setSize(150    , 25);
        balanceAddButton.setLocation(1000, 60);
        balanceAddButton.addActionListener(this);
        c.add(balanceAddButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==launchSteamButton){
    try {
        Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe");
    } catch (IOException e1) {
        e1.printStackTrace();
        JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

    }
}
        if(e.getSource()==launchBrawlhallaButton){
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(e.getSource()==launchDiscordButton){
            try {
                Runtime.getRuntime().exec("C:\\Users\\aglus\\AppData\\Local\\Discord\\app-1.0.9164\\Discord.exe");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(e.getSource()==launchDotaButton){
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1       ");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(e.getSource()==launchValorantButton){
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(e.getSource()==launchLOLButton){
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(e.getSource()==launchGHubButton){
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(e.getSource()==launchDBDButton){
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(e.getSource()==launchCounterStrikeButton){
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(e.getSource()==launchFortniteButton){
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe1");
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "Не удалось запустить игру", "Ошибка запуска игры", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public static void main(String[] args) {
        GameLibrary gameLibrary = new GameLibrary();
        gameLibrary.setVisible(true);
    }

}
