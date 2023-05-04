package org.example.txt.writeTxt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteTxtFile {

    public WriteTxtFile(String downloadsPath, String time, String data) {

        try {
            FileWriter fileWriter = new FileWriter(downloadsPath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("");
            //printWriter.println(data.length());
            printWriter.println("*******************" + time + "*************************");
            printWriter.println(data); // записываем данные в файл с новой строки
            printWriter.close(); // закрываем PrintWriter
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл.");
            e.printStackTrace();
        }
    }
}
