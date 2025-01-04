package org.example.compclubguiandspring.Utils;

import org.example.compclubguiandspring.gui.Account;
import org.example.compclubguiandspring.gui.GameLibrary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameTimer {
    private int totalSeconds;
    private Timer timer;
    private JLabel timerLabel;

    public GameTimer(JLabel timerLabel) {
        this.timerLabel = timerLabel;
        this.totalSeconds = 0;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (totalSeconds > 0) {
                    totalSeconds--;
                    updateTimerDisplay();
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Время истекло!");
                }
            }
        });
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setInitialTime(int hours) {
        totalSeconds += hours * 3600;
        updateTimerDisplay();
    }

    public int getRemainingHours() {
        return totalSeconds / 3600; // Возвращает оставшиеся часы
    }

    public void updateTimerDisplay() {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;

        String timeString = String.format("%02d:%02d:%02d", hours, minutes, secs);
        timerLabel.setText("Time: " + timeString);
    }

    public String getCurrentTime() {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
}
