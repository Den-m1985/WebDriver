package org.example.window.helper_classes;

import org.example.txt.WriteTXT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MyMenuBar {


    public JMenuBar menuBar (StringBuilder data){


        JMenuBar menuBar = new JMenuBar();

        // Создание выпадающего меню
        JMenu file = new JMenu("Дополнительно");

        //JMenuItem save = new JMenuItem("Сохранить");
        //save.setIcon(new ImageIcon("src\\main\\java\\resources\\save40.png"));
        JMenuItem info = new JMenuItem();
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/info40.png")));
        info.setIcon(icon);

        // Добавим в меню
//        file.add(save);
//        save.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                new WriteTXT(data);
//                //System.out.println("This is save.\n");
//            }
//        });

        //file.addSeparator();
        file.add(info);
        info.addActionListener(arg0 -> new Info());

        menuBar.add(file);
        return menuBar;
    }

}
