package org.example.csvRead;

import com.opencsv.exceptions.CsvException;
import org.example.TextLinks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestCsv {
    public static void main(String[] args) throws IOException, CsvException {
        int cellName = 0;   // Cell with name or articular
        int cellPrice = 2;
        int cellItem = 3;


        CsvRead csvRead = new CsvRead("C:\\Users\\Den\\Downloads\\альфа 11.04.csv");
        List<String[]> rows = csvRead.readCSV();

        // В этом блоке отсеиваваем лишнее
        List<String[]> dataWithItem = new ArrayList<>();
        // check - if cell item is integer?
        for (String[] row : rows) {
            if (isInteger(row[cellItem]) && isInteger(row[cellPrice]))
                dataWithItem.add(row);
        }

        // этот блок возвращает иникальные элементы
        List<String[]> uniqueValues = new ArrayList<>();
        List<String[]> dublicatNames = new ArrayList<>();
        int i = 0;
        for (String[] row : dataWithItem) {
            String name = row[cellName];
            for (String[] value : dataWithItem) {
                String name2 = value[cellName];
                if (name.equals(name2)) {
                    i++;
                    if (i > 1) {
                        dublicatNames.add(row);
                        break;
                    }
                }
            }
            if (i == 1) {
                uniqueValues.add(row);
            }
            i = 0;
        }

        // этот блок работатет с повторяющимися именами.
        int j = 0;
        for (String[] row1 : dublicatNames) {
            String name = row1[cellName];
            String price = row1[cellPrice];
            String item = row1[cellItem];
            for (String[] row2 : dublicatNames){
                String name2 = row2[cellName];
                String price2 = row2[cellPrice];
                String item2 = row2[cellItem];
                if (name.equals(name2)) {
                    j++;
                    if (j > 1) {
                        //dublicatNames.add(row);
                        break;
                    }
            }

            }
        }

/*
        java.
        есть: List<String[]> dublicatNames = new ArrayList<>();
        List<String[]> Names = new ArrayList<>();
        for (String[] row : dublicatNames) {
            String name = row[0];
            String size = row[1];
            String price = row[2];
            String item = row[3];
        }
        В dublicatNames есть повторяющиеся name.
        Напиши метод - если name и size повторяется то item нужно сложить, добавляем в Names.
        если name повторяется, а size нет, то добавляем в Names.
*/

        TextLinks textLinks = TextLinks.COUNROWSCSV;
        System.out.println();
        System.out.println(textLinks.getString() + uniqueValues.size());
        System.out.println(dublicatNames.get(0));

//        for (String [] x:dublicatNames) {
//            System.out.println(x[0]);
//        }

    }


    static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
