package org.example.window.helper_classes;

import org.example.txt.WriteTXT;

import javax.swing.*;
import java.util.Objects;

public class MyMenuBar {


    public JMenuBar menuBar (JTextArea data){
        JMenuBar menuBar = new JMenuBar();

        // Создание выпадающего меню
        JMenu file = new JMenu("Дополнительно");

        JMenuItem save = new JMenuItem();
        ImageIcon iconSave = new ImageIcon(Objects.requireNonNull(getClass().getResource("/save40.png")));
        save.setIcon(iconSave);

        JMenuItem info = new JMenuItem();
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/info40.png")));
        info.setIcon(icon);

        JMenuItem login = new JMenuItem();
        ImageIcon iconLogin = new ImageIcon(Objects.requireNonNull(getClass().getResource("/enter40.png")));
        login.setIcon(iconLogin);

        file.add(save);
        file.addSeparator();
        file.add(info);
        file.addSeparator();
        file.add(login);

        save.addActionListener(arg0 ->  new WriteTXT(data.getText()));
        info.addActionListener(arg0 -> new Info());
        login.addActionListener(arg0 -> {
            try {
                new Authorization();
                System.out.println("Авторизация прошла успешно");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        menuBar.add(file);
        return menuBar;
    }

}
