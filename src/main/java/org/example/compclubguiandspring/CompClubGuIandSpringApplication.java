package org.example.compclubguiandspring;

import org.example.compclubguiandspring.gui.MainForm;
import org.example.compclubguiandspring.gui.RegistrationForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class CompClubGuIandSpringApplication {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                     UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
            MainForm mainForm = new MainForm();
            mainForm.setVisible(true);
        });
    }
}
