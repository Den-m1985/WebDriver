package org.example.csvRead;

import com.opencsv.exceptions.CsvException;
import org.example.TextLinks;
import org.example.csvRead.csv.CsvRead;
import org.example.csvRead.csv.DuplicateGoods;
import org.example.csvRead.csv.OnlyGoods;
import org.example.csvRead.csv.UniqueGoods;

import java.io.IOException;
import java.util.List;

public class CsvFilter {
    private final String fileName;


    public CsvFilter(String fileName) {
        this.fileName = fileName;
    }

    public List<String[]> csvFilter(int cellName, int cellPrice, int cellItem) throws IOException, CsvException {

        CsvRead csvRead = new CsvRead(fileName);
        List<String[]> rows = csvRead.readCSV();

        // В этом блоке оставляем только те колонки где есть цена и кол-во
        List<String[]> dataWithItem = new OnlyGoods().onlyGoods(rows, cellPrice, cellItem);

        // этот блок возвращает иникальные элементы
        UniqueGoods uniqueGoods = new UniqueGoods();
        List<String[]> uniqueValues = uniqueGoods.uniqueGoods(dataWithItem, cellName);
        List<String[]> duplicateNames = uniqueGoods.getDuplicateNames();

        // этот блок работатет с повторяющимися именами.
        List<String[]> resolveDuplicatedNames = new DuplicateGoods().duplicateGoods(duplicateNames);
        uniqueValues.addAll(resolveDuplicatedNames);

        TextLinks textLinks = TextLinks.COUNROWSCSV;
        System.out.println();
        System.out.println(textLinks.getString() + uniqueValues.size());

//        for (String[]x:duplicateNames) {
//            System.out.println(x[0] + "----" + x[1] + "----" + x[3]);
//        }
//        System.out.println();
//        for (String[]x:resolveDuplicatedNames) {
//            System.out.println(x[0] + "----" + x[1] + "----" + x[3]);
//        }
        return uniqueValues;
    }


}
