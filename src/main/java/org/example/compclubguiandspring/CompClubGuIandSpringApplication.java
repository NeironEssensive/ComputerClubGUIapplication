package org.example.compclubguiandspring;

import org.example.compclubguiandspring.gui.MainForm;
import org.example.compclubguiandspring.gui.RegistrationForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompClubGuIandSpringApplication {

    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);
    }

}
