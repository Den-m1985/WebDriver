package org.example.csvRead;

import com.opencsv.exceptions.CsvException;
import org.example.TextLinks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFilter {
    private final String fileName;
    private final List<String[]> reportList;
    private List<String[]> dublicatNames;


    public CsvFilter(String fileName, List<String[]> reportList) {
        this.fileName = fileName;
        this.reportList = reportList;
    }

    public List<String[]> csvFilter(int cellName,int cellPrice, int cellItem) throws IOException, CsvException {

        CsvRead csvRead = new CsvRead(fileName);
        List<String[]> rows = csvRead.readCSV();

        // В этом блоке оставляем только те колонки где есть цена и кол-во
        List<String[]> dataWithItem = OnlyGoods(rows, cellPrice, cellItem);

        // этот блок возвращает иникальные элементы
        List<String[]> uniqueValues = uniqGoods(dataWithItem, cellName);

        // этот блок работатет с повторяющимися именами.
        List<String[]> resolveDublicatedNames = dublicateGoods();
        uniqueValues.addAll(resolveDublicatedNames);

        TextLinks textLinks = TextLinks.COUNROWSCSV;
        System.out.println();
        System.out.println(textLinks.getString() + uniqueValues.size());

        return uniqueValues;
    }


    static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<String[]> OnlyGoods(List<String[]> rows, int cellPrice, int cellItem) {

        List<String[]> dataWithItem = new ArrayList<>();
        for (String[] row : rows) {
            if (isInteger(row[cellItem]) && isInteger(row[cellPrice]))
                dataWithItem.add(row);
        }
        return dataWithItem;
    }


    public List<String[]> uniqGoods(List<String[]> dataWithItem, int cellName) {

        List<String[]> uniqueValues = new ArrayList<>();
        dublicatNames = new ArrayList<>();
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
        return uniqueValues;
    }


    public List<String[]> dublicateGoods() {
        List<String[]> Names = new ArrayList<>();
        for (String[] row : dublicatNames) {
            String name = row[0];
            String size = row[1];
            String price = row[2];
            String item = row[3];
            boolean duplicated = false;
            for (String[] existing : Names) {
                String str1 = existing[0];
                String str2 = existing[1];

                if (str1.equals(name)) {
                    if (str2.equals(size)) {
                        existing[3] = String.valueOf(Integer.parseInt(existing[3]) + Integer.parseInt(item));
                        duplicated = true;
                        break;
                    } else {
                        continue;
                    }
                }
            }
            if (!duplicated) {
                Names.add(new String[]{name, size, price, item});
            }
        }
        return Names;
    }


}
