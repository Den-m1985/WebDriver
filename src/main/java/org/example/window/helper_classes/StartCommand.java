package org.example.window.helper_classes;

import org.example.TextLinks;
import org.example.command.Command;
import org.example.createPathFile.GetPathFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartCommand implements ActionListener {
    String pathCSV;

    @Override
    public void actionPerformed(ActionEvent e) {
        GetPathFile getPathFile = new GetPathFile();

        int i = 0;
        while (i < 2) {
            TextLinks extension = TextLinks.CSV;
            pathCSV = getPathFile.getPathFile(extension.getString());
            if (pathCSV != null)
                break;
            else i++;
        }

        System.out.println();
        TextLinks textLinks = TextLinks.TEXTFILEOPEN;
        System.out.println(textLinks.getString());
        System.out.println(pathCSV);
        System.out.println();

        try {
            new Command(pathCSV);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        JOptionPane.showMessageDialog(null, "Успешно");
    }

//    @Override
//    public void run() {
//        try {
//            new Command(pathCSV);
//            //new Command(pathCSV);
//
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//        JOptionPane.showMessageDialog(null, "Успешно");
//    }

}
