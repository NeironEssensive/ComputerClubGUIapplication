package org.example.compclubguiandspring.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameLibrary extends JFrame implements ActionListener {
    private Container c;
    ImageIcon icon = new ImageIcon("C:\\Users\\aglus\\IdeaProjects\\CompClubGUIandSpring\\src\\main\\resources\\photo_2024-09-28_16-30-31 (1).jpg");
    JLabel logotype = new JLabel(icon);
    private JButton launchSteamButton;
    GameLibrary(){
        setTitle("InvokerQWE");
        setBounds(300, 90, 1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);
        logotype.setBounds(175, -100, 800, 600);
        logotype.setIcon(icon);
        c.add(logotype);


        launchSteamButton = new JButton("Steam");
        launchSteamButton.setFont(new Font("Arial", Font.PLAIN, 15));
        launchSteamButton.setSize(150, 40);
        launchSteamButton.setLocation(500, 500);
        launchSteamButton.addActionListener(this);
        c.add(launchSteamButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==launchSteamButton){
    try {
        Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\steam.exe");
    } catch (IOException e1) {
        e1.printStackTrace();
    }
}
    }



}
