package org.example;

import com.opencsv.exceptions.CsvException;
import org.example.createPathFile.GetPathFile;
import org.example.csvRead.CsvFilter;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException, CsvException {

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

        CsvFilter csvFilter = new CsvFilter(pathCSV);
        List<String[]> data = csvFilter.csvFilter(0, 3);

//        for (String [] dat: data) {
//            System.out.println(dat[0]);
//            System.out.println(dat[1]);
//            System.out.println(dat[2]);
//            System.out.println(dat[3]);
////            System.out.println("****************************");
//
//        }

        try {
            command.startProgram(pathCSV);

        } catch (IOException | CsvException ex) {
            throw new RuntimeException(ex);
        }

    }
}
