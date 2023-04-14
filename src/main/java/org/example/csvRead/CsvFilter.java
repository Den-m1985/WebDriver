package org.example.csvRead;

import com.opencsv.exceptions.CsvException;
import org.example.TextLinks;
import org.example.csvRead.csv.*;

import java.io.IOException;
import java.util.List;

public class CsvFilter {
    private final String fileName;


    public CsvFilter(String fileName) {
        this.fileName = fileName;
    }

    public List<StructureCSV> csvFilter(int cellPrice, int cellItem) throws IOException, CsvException {

        CsvRead csvRead = new CsvRead(fileName);
        List<String[]> rows = csvRead.readCSV();

        // В этом блоке оставляем только те колонки где есть цена и кол-во
        List<StructureCSV> dataWithItem = new OnlyGoods().onlyGoods(rows, cellPrice, cellItem);

        // этот блок возвращает иникальные элементы
        UniqueGoods uniqueGoods = new UniqueGoods();
        List<StructureCSV> uniqueValues = uniqueGoods.uniqueGoods(dataWithItem);
        List<StructureCSV> duplicateNames = uniqueGoods.getDuplicateNames();

        // этот блок работатет с повторяющимися именами.
        List<StructureCSV> resolveDuplicatedNames = new DuplicateGoods().duplicateGoods(duplicateNames);
        uniqueValues.addAll(resolveDuplicatedNames);

        TextLinks textLinks = TextLinks.COUNROWSCSV;
        System.out.println();
        System.out.println(textLinks.getString() + uniqueValues.size());

//        for (StructureCSV x:duplicateNames) {
//            System.out.println(x.getName() + "----" + x.getArtucul() + "----" + x.getItem());
//        }
//        System.out.println();
//        for (StructureCSV x:resolveDuplicatedNames) {
//            System.out.println(x.getName() + "----" + x.getArtucul() + "----" + x.getItem());
//        }
        return uniqueValues;
    }


}
