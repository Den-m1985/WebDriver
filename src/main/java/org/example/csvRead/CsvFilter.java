package org.example.csvRead;

import com.opencsv.exceptions.CsvException;
import org.example.TextLinks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFilter {
    private final String fileName;
    private List<String[]> duplicateValues;


    public CsvFilter(String fileName) {
        this.fileName = fileName;
    }

    public List<String[]> csvFilter(int cellName, int cellItem) throws IOException, CsvException {

        CsvRead csvRead = new CsvRead(fileName);
        List<String[]> rows = csvRead.readCSV();


        List<String[]> dataWithItem = new ArrayList<>();
        // check - if cell item is integer?
        for (String[] row : rows) {
            if (isInteger(row[cellItem]) && isInteger(row[2]))
                dataWithItem.add(row);
        }

        List<String[]> uniqueValues = new ArrayList<>();
        duplicateValues = new ArrayList<>();

        for (String[] row : dataWithItem) {
            String name = row[cellName];
            boolean found = false;
            for (String[] value : duplicateValues) {
                if (name.equals(value[cellName])) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (String[] value : uniqueValues) {
                    if (name.equals(value[cellName])) {
                        uniqueValues.remove(value);
                        String[] error = {name, "Повторяются товары"};
                        duplicateValues.add(error);
                        break;
                    }
                }
                uniqueValues.add(row);
            }
        }

//        for (String[] x : duplicateValues) {
//            System.out.println("Повтояющееся имя товара: " + x[0]);
//        }


//        List<String[]> dataCSV = new ArrayList<>();
//
//
//        for (String[] row : rows) {
//            boolean isUnique = true;
//
//            // Проверяем уникальность текущего элемента среди уже имеющихся в новом списке
//            for (String[] uniq : dataCSV) {
//                if (row[cellName].equals(uniq[cellName])) {
//                    // Строка не уникальна - выходим из цикла по поиску уникальных строк
//                    isUnique = false;
//                    System.out.println("Повтояющееся имя товара: " + row[cellName]);
//                    reportList = new String[]{uniq[cellName], "Повторяются товары"};
//                    break;
//                }
//            }
//
//            if (isUnique) {
//                // Если проверяемая строка уникальна, добавляем её в список уникальных строк
//                if (isInteger(row[cellItem]))    // check - if cell item is integer?
//                    dataCSV.add(row);
//            }
//        }

        TextLinks textLinks = TextLinks.COUNROWSCSV;
        System.out.println();
        System.out.println(textLinks.getString() + uniqueValues.size());

        return uniqueValues;
    }


    boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public List<String[]> getReportListCsv() {
        return duplicateValues;
    }


}
