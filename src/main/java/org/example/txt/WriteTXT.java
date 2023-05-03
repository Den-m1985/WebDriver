package org.example.txt;

import org.example.TextLinks;
import org.example.createPathFile.CreatePathFile;
import org.example.createPathFile.Date;
import org.example.txt.writeTxt.WriteTxtFile;


public class WriteTXT {

    public WriteTXT(String data) {

        // создаем имя файла
        CreatePathFile createPathFile = new CreatePathFile();
        TextLinks fileName = TextLinks.FILENAMESAVE;
        String downloadsPath = createPathFile.createPathFile(fileName.getString(), "txt");

        Date date = new Date();
        String time = date.currentDate();

        new WriteTxtFile(downloadsPath, time, data);
    }
}
