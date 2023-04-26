package org.example.window.helper_classes;

import org.example.txt.WriteTXT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuBar {


    public JMenuBar menuBar (StringBuilder data){


        JMenuBar menuBar = new JMenuBar();

        // Создание выпадающего меню
        JMenu file = new JMenu("Дополнительно");

        //JMenuItem save = new JMenuItem("Сохранить");
        //save.setIcon(new ImageIcon("src\\main\\java\\resources\\save40.png"));
        JMenuItem info = new JMenuItem("info");
        info.setIcon(new ImageIcon("src\\main\\java\\resources\\info40.png"));

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
        info.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Info();
            }
        });

        menuBar.add(file);
        return menuBar;
    }

}
