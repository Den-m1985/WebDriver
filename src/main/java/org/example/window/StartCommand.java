package org.example.window;

import org.example.Command;
import com.opencsv.exceptions.CsvException;
import org.example.TextLinks;
import org.example.createPathFile.GetPathFile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartCommand implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        String pathCSV = null;

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

        Command command = new Command();

        try {
            command.startProgram(pathCSV);

        } catch (IOException | CsvException ex) {
            throw new RuntimeException(ex);
        }

    }

}
