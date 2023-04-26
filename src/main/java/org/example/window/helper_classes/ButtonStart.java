package org.example.window.helper_classes;

import javax.swing.*;

public class ButtonStart {


    public JButton buttonStart(){
        JButton startButton = new JButton("<html><h2><font color=\"blue\">START");
        startButton.setFocusPainted(false);  // бираем рамку вокруг кнопки
        startButton.setIcon(new ImageIcon("resources\\play64.png"));

        startButton.addActionListener(new StartCommand());
        return startButton;
    }


}
